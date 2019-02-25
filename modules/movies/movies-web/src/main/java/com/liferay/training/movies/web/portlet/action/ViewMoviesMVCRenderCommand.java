package com.liferay.training.movies.web.portlet.action;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.permission.MoviePermissionChecker;
import com.liferay.training.movies.service.MovieService;
import com.liferay.training.movies.web.constants.MVCCommandNames;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;
import com.liferay.training.movies.web.display.context.MoviesManagementToolbarDisplayContext;

@Component(
		immediate=true,
		property = {
			"javax.portlet.name=" + MoviesPortletKeys.MOVIES,
			"MVC.command.name=" + MVCCommandNames.VIEW_MOVIE,
		},
		service = MVCRenderCommand.class
)
public class ViewMoviesMVCRenderCommand implements MVCRenderCommand {
	
	@Reference
	protected MoviePermissionChecker moviePermissionChecker;

	@Reference
	protected MovieService movieService;

	@Reference
	private Portal portal;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		
		//add movie list attributes
		addMovieListAttributes(renderRequest);
		
		//add permissionChecker
		renderRequest.setAttribute("moviePermissionChecker", moviePermissionChecker);
		
		//add attributes needed by Application Display Templates render
		addADTAttributes(renderRequest);
		
		return "/view_test.jsp";
	}

	private void addMovieListAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		//resolve start and end of search
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		
		int start = ((currentPage > 0) ? (currentPage -1 ) : 0) * delta;
		int end = start + delta;
		
		// Get sorting options.
		// Notice that this doesn't really sort on title because the field is
		// stored in XML
		// In real world this search would be integrated to the search engine to
		// get localized
		// sort options.
		
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "movieName");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");
		
		//create comparator
		OrderByComparator<Movie> comparator = OrderByComparatorFactoryUtil.create(
				"Movie", orderByCol, !("asc").equals(orderByType));
		
		//get keywords (cleaning keywords is not implemented)
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		
		//workflow status for the list here
		
		
		//call service to get the movie list
		List<Movie> movies = movieService.getMoviesByGroupId(themeDisplay.getScopeGroupId(), start, end);
		
		//set request attributes
		renderRequest.setAttribute("movies", movies);
		renderRequest.setAttribute("movieCount", movieService.getMoviesByGroupId(themeDisplay.getScopeGroupId(), start, end));
		
	}
	
	private void addADTAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay =  (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		renderRequest.setAttribute("movieClassName", Movie.class.getName());
		
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		
		renderRequest.setAttribute("ADTdisplayStyle", portletPreferences.getValue("displayStyle", StringPool.BLANK));
		renderRequest.setAttribute("ADTdisplayStyleGroupId", GetterUtil.getLong(portletPreferences.getValue(
				"displayStyleGroupId", null), themeDisplay.getScopeGroupId()));
		
	}
}
