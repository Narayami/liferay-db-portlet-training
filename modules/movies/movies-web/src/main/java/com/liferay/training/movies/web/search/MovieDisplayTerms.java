package com.liferay.training.movies.web.search;


import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.movies.model.Author;

public class MovieDisplayTerms extends DisplayTerms {
	
	private int movieId;
	private String movieName;
	
	private String description;
	private int rating;
	private String authorName;
	private String biography;
	private Author author;
	
	public MovieDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		movieId = ParamUtil.getInteger(portletRequest, "movieId");
		movieName = ParamUtil.getString(portletRequest, "movieName");
		
		description = ParamUtil.getString(portletRequest, "description");
		rating = ParamUtil.getInteger(portletRequest, "rating");
		authorName = ParamUtil.getString(portletRequest, "authorName");
		biography = ParamUtil.getString(portletRequest, "biography");
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
