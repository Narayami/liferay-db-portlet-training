package com.liferay.training.movies.web.portlet.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.MovieLocalServiceUtil;
import com.liferay.training.movies.web.comparator.MovieComparatorUtil;
import com.liferay.training.movies.web.constants.MVCCommandNames;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;


@Component(
		immediate=true,
		property = {
			"javax.portlet.name=" + MoviesPortletKeys.MOVIES,
			"MVC.command.name=" + MVCCommandNames.VIEW_MOVIE,
		},
		service = MVCRenderCommand.class
)
public class ViewMoviesMVCRenderCommand implements MVCRenderCommand {
		
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {  
		
		
		orderColumnsByAscDesc(renderRequest, renderResponse);
		
		return "/view_test.jsp";
		
	}

	private void orderColumnsByAscDesc(RenderRequest renderRequest, RenderResponse renderResponse) {
				
		//toggle asc/desc logic
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol"); 
		String orderByType = ParamUtil.getString(renderRequest, "orderByType"); 
		
		if(orderByCol == null || orderByCol.equals("") || orderByCol.isEmpty()) { 
		   orderByCol="movieName"; 	
		   renderRequest.setAttribute("orderByCol", orderByCol);
		}
		
		if(orderByType == null || orderByType.equals("") || orderByType.isEmpty()) { 
		   orderByType = "asc";         
		   renderRequest.setAttribute("orderByType", orderByType); 
		}
		
		//Logic for toggle asc and desc on rendering the page 
		if(orderByType.equals("desc")){     
		   orderByType = "desc";
		}
		else {
		   orderByType = "asc";
		}
		/*
		//setting the iterator for the search container
		PortletURL iteratorURL = renderResponse.createRenderURL();
		
		//search container
		SearchContainer<Movie> searchContainer = new SearchContainer<Movie>(renderRequest, null, null, 
				SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, iteratorURL, null, StringPool.BLANK);
		
		searchContainer.setIteratorURL(iteratorURL);
		searchContainer.setOrderByType(orderByType);
		searchContainer.setOrderByCol(orderByCol);
		
		List<Movie> movieList = MovieLocalServiceUtil.getMoviesAndAuthors(-1, -1);
		
		//get local copy to be sorted in our need
		List<Movie> sortedMovieList = new ArrayList<Movie>(ListUtil.subList(movieList, 
				searchContainer.getStart(), searchContainer.getEnd()));
		
		//sort the list based on order and column
		sortedMovieList = MovieComparatorUtil.sortMovies(sortedMovieList, orderByCol, orderByType);
		
		searchContainer.setResults(sortedMovieList);
		searchContainer.setTotal(movieList.size());
		
		renderRequest.setAttribute("orgMovies", sortedMovieList);
		*/
	}
}
