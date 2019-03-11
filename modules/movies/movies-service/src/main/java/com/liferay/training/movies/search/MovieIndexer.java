
package com.liferay.training.movies.search;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.MovieLocalService;

@Component(
	immediate = true,
	service = Indexer.class
)
public class MovieIndexer extends BaseIndexer<Movie> {
	
	private static final Log _log = LogFactoryUtil.getLog(MovieIndexer.class);
	private static final String CLASS_NAME = Movie.class.getName();
	
	@Reference
	private MovieLocalService movieLocalService;
	
	@Reference
	protected IndexWriterHelper indexWriterHelper;
	

	public MovieIndexer() {
		setDefaultSelectedFieldNames(Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.UID, Field.DESCRIPTION);
		setDefaultSelectedLocalizedFieldNames(Field.TITLE);
		setFilterSearch(true);
		setPermissionAware(true);
	}
	
	@Override
	public String getClassName() {
		return CLASS_NAME;
	}
	
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK, 
			String actionId) throws Exception {
		
		Movie movie = movieLocalService.getMovie(entryClassPK);
		return permissionChecker.hasPermission(movie.getGroupId(), Movie.class.getName(), movie.getMovieId(), ActionKeys.VIEW);
	}
	
	/*
	@Override
	public boolean isVisible(long classPK, int status) throws Exception {
		Movie entry = movieLocalService.getMovie(classPK);

		return isVisible(entry.getStatus(), status);
	}
	*/
	
	@Override
	public void postProcessContextBooleanFilter(
		BooleanFilter contextBooleanFilter, SearchContext searchContext) throws Exception {
		addStatus(contextBooleanFilter, searchContext);
	}

	@Override
	protected void doDelete(Movie movie) throws Exception {
		deleteDocument(movie.getCompanyId(), movie.getMovieId());
	}

	 @Override
	    public void postProcessSearchQuery( BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter, 
	    		SearchContext searchContext) throws Exception {

	        addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, false);
	        addSearchTerm(searchQuery, searchContext, Field.DESCRIPTION, false);
	    }
	
	
	@Override
	protected Document doGetDocument(Movie movie) throws Exception {

		Document document = getBaseModelDocument(CLASS_NAME, movie);
		//document.addLocalizedText(Field.TITLE, movie.getTitleMap());
		//document.addText(Field.DESCRIPTION, assignment.getDescription());
		
		document.addText(Field.TITLE, movie.getMovieName());
		//document.addText(Field.DESCRIPTION, movie.getDescription());
		
		
		
		

		return document;
	}

	@Override
	protected Summary doGetSummary( Document document, Locale locale, String snippet, 
			PortletRequest portletRequest, PortletResponse portletResponse) throws Exception {
		
		String prefix = Field.SNIPPET + StringPool.UNDERLINE;
		String title = document.get(prefix + Field.TITLE, Field.TITLE);
		String content = HtmlUtil.stripHtml(
			document.get(prefix + Field.DESCRIPTION, Field.DESCRIPTION));

		Summary summary = new Summary(title, content);
		summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected void doReindex(String className, long classPK)
		throws Exception {

		Movie movie = movieLocalService.getMovie(classPK);
		doReindex(movie);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);
		reindexMovies(companyId);
	}

	@Override
	protected void doReindex(Movie movie) throws Exception {

		Document document = getDocument(movie);
		indexWriterHelper.updateDocument(getSearchEngineId(), movie.getCompanyId(), document, isCommitImmediately());
	}

	protected void reindexMovies(long companyId) throws PortalException {

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = movieLocalService.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);

		// Actionable query

		indexableActionableDynamicQuery.setPerformActionMethod( new ActionableDynamicQuery.PerformActionMethod<Movie>() {

				@Override
				public void performAction(Movie movie) {

					try {
						Document document = getDocument(movie);
						indexableActionableDynamicQuery.addDocuments(document);
					}
					catch (PortalException pe) {
						if (_log.isWarnEnabled()) {
							_log.warn(
								"Unable to index assignment " +
									movie.getMovieId(),
								pe);
						}
					}
				}
			});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
	}
}
