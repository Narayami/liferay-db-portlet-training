package com.liferay.training.movies.web.model.view;

import java.util.List;

import com.liferay.training.movies.model.Author;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.MovieLocalServiceUtil;

public class MovieViewModel {
	
	private Author author;
	private String movieName;
	private String description;
	private int rating;
	
	
	public List<Movie> getMovies(int startPost, int endPos) {
		
		return MovieLocalServiceUtil.getMovies(startPost, endPos);
	}
	
	
	public List<Movie> getMoviesAndAuthors(int startPos, int endPost) {
		
		return MovieLocalServiceUtil.getMoviesAndAuthors(startPos, endPost);
	}
	
	public int getMoviesCount() {
		
		return MovieLocalServiceUtil.getMoviesCount();
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public void setMovieName(String movieName) {
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
}
