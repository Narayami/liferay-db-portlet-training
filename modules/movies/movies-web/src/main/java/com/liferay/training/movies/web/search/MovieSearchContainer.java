
package com.liferay.training.movies.web.search;

import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.training.movies.model.Movie;

public class MovieSearchContainer extends SearchContainer<Movie> {
	public static final String EMPTY_RESULTS_MESSAGE = "No Movies Found";
	public static final int DEFAULT_DELTA = 10;
	
	static List<String> headerNames = new ArrayList<String>();
	static {
		headerNames.add("movieId");
		headerNames.add("movieName");
		headerNames.add("description");
		headerNames.add("rating");
		headerNames.add("authorName");
		headerNames.add("biography");
	}

	public MovieSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new DisplayTerms(portletRequest), new DisplayTerms(portletRequest), 
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);	
	}
}
