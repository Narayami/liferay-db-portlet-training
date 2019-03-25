package com.liferay.training.movies.web.search;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.MovieLocalServiceUtil;

public class MovieHelper {
	
	public static List<Movie> getMovie(DisplayTerms displayTerms, int start, int end) throws SystemException {
		
		List<Movie> movieList = getMovieData(displayTerms.isAdvancedSearch(), displayTerms.isAndOperator(),
				displayTerms.getKeywords());

		return ListUtil.subList(movieList, start, end);
	}

	public static int getTotalMovieCount(DisplayTerms displayTerms, int start, int end) throws SystemException {
		
		return getMovieData(displayTerms.isAdvancedSearch(), displayTerms.isAndOperator(), 
				displayTerms.getKeywords()).size();
	}
	
	public static List<Movie> getMovieData(boolean isAdvancedSearch, boolean isAndOperator, String keywords) throws SystemException {
		
		List<Movie> movieList = Collections.EMPTY_LIST;
		List<Movie> moviesListQueriedAndSettedAuthorsList = Collections.EMPTY_LIST;
		
		//if the keyword has more than 1 space replace them with only 1 space
		keywords = keywords.replaceAll(" +", " ");
		
		if ((Validator.isBlank(keywords)) && (!isAdvancedSearch)) {// No search
			moviesListQueriedAndSettedAuthorsList = MovieLocalServiceUtil.getMoviesAndAuthors(0, 
					MovieLocalServiceUtil.getMoviesCount());
		} else {
			
			DynamicQuery dynamicQuery = MovieLocalServiceUtil.dynamicQuery();
			
			Junction junction = null;
			if (isAdvancedSearch) {// Advanced Search
				if (isAndOperator) {
					System.out.println("All means And");
					junction = RestrictionsFactoryUtil.conjunction();
					junction.add(PropertyFactoryUtil.forName("movieName").like(keywords));
				}
				else {
					System.out.println("Any means OR");
					junction = RestrictionsFactoryUtil.disjunction();
				}	
					junction.add(PropertyFactoryUtil.forName("movieName").like(keywords));
			}
			else {// Normal Search
				junction = RestrictionsFactoryUtil.disjunction();

				if (Validator.isDigit(keywords)) {
					junction.add(PropertyFactoryUtil.forName("movieId").eq(Long.valueOf(keywords)));
					junction.add(PropertyFactoryUtil.forName("rating").eq(Integer.valueOf(keywords)));
				}
				junction.add(RestrictionsFactoryUtil.ilike("movieName", keywords));
				
			}
			
			dynamicQuery.add(junction);
			movieList = MovieLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			//invokes the method that will set the queried movies the respectives authors
			moviesListQueriedAndSettedAuthorsList = MovieLocalServiceUtil.getMoviesAndAuthorsQueried(movieList);
			
		}
		return moviesListQueriedAndSettedAuthorsList;
	}
}