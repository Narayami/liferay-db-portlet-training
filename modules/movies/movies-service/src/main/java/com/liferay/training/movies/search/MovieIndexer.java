
package com.liferay.training.movies.search;

import java.util.LinkedHashMap;
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
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.permission.MoviePermissionChecker;
import com.liferay.training.movies.service.MovieLocalService;

@Component(immediate = true, service = Indexer.class)
public class MovieIndexer extends BaseIndexer<Movie> {

    private static final String CLASS_NAME = Movie.class.getName();
    private static final Log _log = LogFactoryUtil.getLog(MovieIndexer.class);
    
    @Reference
    protected IndexWriterHelper indexWriterHelper;
    
    @Reference
    private MovieLocalService _movieLocalService;
    
    @Reference
    private MoviePermissionChecker _moviePermissionChecker;

    public MovieIndexer() {
        setDefaultSelectedFieldNames(Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
            Field.UID, Field.SCOPE_GROUP_ID, Field.GROUP_ID);
        setDefaultSelectedLocalizedFieldNames(Field.TITLE, Field.CONTENT);
        setFilterSearch(true);
        setPermissionAware(true);
    }

    @Override
    public String getClassName() {
    	return CLASS_NAME;
    }

    @Override
    public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, 
    		long entryClassPK, String actionId) throws Exception {

        return _moviePermissionChecker.containsTopLevel(permissionChecker, entryClassPK, ActionKeys.VIEW);
    }

    @Override
    public void postProcessContextBooleanFilter(BooleanFilter contextBooleanFilter, SearchContext searchContext) 
    		throws Exception {

        addStatus(contextBooleanFilter, searchContext);
    }

    @Override
    public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
    		SearchContext searchContext) throws Exception {

    	addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, true);
    	addSearchLocalizedTerm(searchQuery, searchContext, Field.CONTENT, true);
        addSearchLocalizedTerm(searchQuery, searchContext, "movieName", false);
        addSearchLocalizedTerm(searchQuery, searchContext, "rating", false);
        addSearchLocalizedTerm(searchQuery, searchContext, "description", false);
        
    }
    
    @Override
    protected void doDelete(Movie movie) throws Exception {

        deleteDocument(movie.getCompanyId(), movie.getMovieId());
    }

    @Override
    protected Document doGetDocument(Movie movie) throws Exception {
    	        
    	Document document = getBaseModelDocument(CLASS_NAME, movie);
    	
        document.addDate(Field.MODIFIED_DATE, movie.getModifiedDate());

        Locale defaultLocale = PortalUtil.getSiteDefaultLocale(movie.getGroupId());
        String localizedTitle = LocalizationUtil.getLocalizedName(Field.TITLE, defaultLocale.toString());
        String localizedMessage = LocalizationUtil.getLocalizedName(Field.CONTENT, defaultLocale.toString());

        document.addText(localizedTitle, movie.getMovieName());
        document.addText(localizedMessage, movie.getDescription());
		
    	
    	
    	document.addText("movieName", movie.getMovieName());
    	document.addText("description", movie.getDescription());
    	document.addNumber("rating", movie.getRating());
    	    	
        return document;
    }
    @Override
    protected Summary doGetSummary( Document document, Locale locale, String snippet,
        PortletRequest portletRequest, PortletResponse portletResponse) throws Exception {

    	System.out.println("summary");
        Summary summary = createSummary(document);

        summary.setMaxContentLength(200);

        return summary;
    }

    @Override
    protected void doReindex(Movie movie) throws Exception {

        Document document = getDocument(movie);
        indexWriterHelper.updateDocument(getSearchEngineId(), movie.getCompanyId(), document, isCommitImmediately());
        
    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {

        Movie movie = _movieLocalService.getMovie(classPK);
        doReindex(movie);
    }

    @Override
    protected void doReindex(String[] ids) throws Exception {
    	System.out.println("reindex3");

        long companyId = GetterUtil.getLong(ids[0]);
        reindexEntries(companyId);
    }

    protected void reindexEntries(long companyId) throws PortalException {
    	System.out.println("REINDEX ENTRIE");

        final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
            _movieLocalService.getIndexableActionableDynamicQuery();

        indexableActionableDynamicQuery.setCompanyId(companyId);

        indexableActionableDynamicQuery.setPerformActionMethod(
            new ActionableDynamicQuery.PerformActionMethod<Movie>() {

                @Override
                public void performAction(Movie movie) {

                    try {
                        Document document = getDocument(movie);
                        indexableActionableDynamicQuery.addDocuments(document);
                    }
                    catch (PortalException pe) {
                        if (_log.isWarnEnabled()) {
                            _log.warn("Unable to index entry " + movie.getMovieId(), pe);
                        }
                    }
                }
            });
        indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
        indexableActionableDynamicQuery.performActions();
    }

}