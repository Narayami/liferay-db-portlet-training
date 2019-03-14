package com.liferay.training.movies.web.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class MovieDisplayTerms extends DisplayTerms {
	
	private int movieId;
	private String movieName;

	public MovieDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		movieId = ParamUtil.getInteger(portletRequest, "movieId");
		movieName = ParamUtil.getString(portletRequest, "movieName");
	}

	public int getId() {
		return movieId;
	}

	public void setId(int movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return movieName;
	}

	public void setName(String movieName) {
		this.movieName = movieName;
	}
}
