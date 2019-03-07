package com.liferay.training.movies.web.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import com.liferay.training.movies.model.Movie;

public class MovieComparatorUtil {

	public static List<Movie> sortMovies(List<Movie> moviesList, String orderByCol, String orderByType) {
		
		if (orderByCol.equals("movieName")) {
			if (orderByType.equals("asc")) {
				Collections.sort(moviesList, movieNameAsc);
			}
			else {
				Collections.sort(moviesList, movieNameDesc);
			}
		}
		else if (orderByCol.equals("rating")) {
			if (orderByType.equals("asc")) {
				Collections.sort(moviesList, movieRatingAsc);
			}
			else {
				Collections.sort(moviesList, movieRatingDesc);
			}
		}
		else if (orderByCol.equals("authorName")) {
			if (orderByType.equals("asc")) {
				Collections.sort(moviesList, movieAuthorNameAsc);
			} 	
			else {
				Collections.sort(moviesList, movieAuthorNameDesc);
			}
		}
		
		return moviesList;
	}
	
	public static Comparator<Movie> movieNameAsc = new Comparator<Movie>() {

		@Override
		public int compare(Movie movie1, Movie movie2) {
			
			int value = movie1.getMovieName().toLowerCase().compareTo(movie2.getMovieName().toLowerCase());
			return value;
			
		}
	};
	
	public static Comparator<Movie> movieNameDesc = new Comparator<Movie>() {

		@Override
		public int compare(Movie movie1, Movie movie2) {
			
			int value = movie2.getMovieName().toLowerCase().compareTo(movie1.getMovieName().toLowerCase());
			return value;
		}
	};
	
	public static Comparator<Movie> movieRatingAsc = new Comparator<Movie>() {
		
		@Override
		public int compare(Movie movie1, Movie movie2) {
			
			boolean value = movie1.getRating() > movie2.getRating();
			
			if (value) {
				return 1;
			}
			else {				
				return -1;
			}
		}
	};
	
	public static Comparator<Movie> movieRatingDesc = new Comparator<Movie>() {

		@Override
		public int compare(Movie movie1, Movie movie2) {
			
			boolean value = movie2.getRating() > movie1.getRating(); 
			
			if (value) {
				return 1;
			}
			else {				
				return -1;
			}
		}
	};
	
	public static Comparator<Movie> movieAuthorNameAsc = new Comparator<Movie>() {
		
		@Override
		public int compare(Movie movie1, Movie movie2) {
			
			int value = movie1.getAuthor().getAuthorName().toLowerCase().compareTo(movie2.getAuthor().getAuthorName().toLowerCase());
			return value;
		}
	};
	
	public static Comparator<Movie> movieAuthorNameDesc = new Comparator<Movie>() {

		@Override
		public int compare(Movie movie1, Movie movie2) {
		
			int value = movie2.getAuthor().getAuthorName().toLowerCase().compareTo(movie1.getAuthor().getAuthorName().toLowerCase());
			return value;
		}
	};
}
