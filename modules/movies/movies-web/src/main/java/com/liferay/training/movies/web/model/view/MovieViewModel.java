package com.liferay.training.movies.web.model.view;

import java.util.List;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.movies.model.Author;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.MovieLocalServiceUtil;

public class MovieViewModel {
	
	public static final Log log = LogFactoryUtil.getLog(Movie.class);
	private Author author;
	private String movieName;
	private String description;
	private int rating;
	
	public SearchContainer<Movie> setSearchContainerMoviesResults() {
		SearchContainer<Movie> searchContainer = new SearchContainer<Movie>();
		List<Movie> movies = getMoviesAndAuthors(0, getMoviesCount());
		searchContainer.setTotal(getMoviesCount());
		searchContainer.setResults(movies);
		searchContainer.setEmptyResultsMessage("No movies found");
		return searchContainer;
		
	}
	
	public List<Movie> getMovies(int startPost, int endPos) {
		return MovieLocalServiceUtil.getMovies(startPost, endPos);
	}
	
	public List<Movie> getMoviesAndAuthors(int startPos, int endPost) {
		return MovieLocalServiceUtil.getMoviesAndAuthors(startPos, endPost);
	}
	
	public int getMoviesCount() {
		return MovieLocalServiceUtil.getMoviesCount();
	}
	
	public void addMovieAndAuthor(long groupId, String movieName, String description, 
			int rating, String authorName, String biography, ServiceContext serviceContext) {
		
		try {
			MovieLocalServiceUtil.addMovieAndAuthor(groupId, movieName, description, rating, authorName, 
					biography, serviceContext);
		} catch (PortalException e) {
			log.error(e);
		}
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
