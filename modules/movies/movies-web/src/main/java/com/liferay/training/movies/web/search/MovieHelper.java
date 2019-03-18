package com.liferay.training.movies.web.search;

import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.service.persistence.PortletUtil;
import com.liferay.portal.kernel.servlet.ServletContextUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.MovieLocalServiceUtil;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;

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

		if ((Validator.isBlank(keywords)) && (!isAdvancedSearch)) {// No search
			movieList = MovieLocalServiceUtil.getMovies(0, MovieLocalServiceUtil.getMoviesCount());
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
				junction.add(PropertyFactoryUtil.forName("movieName").like(keywords));
			}
			
			dynamicQuery.add(junction);
			movieList = MovieLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			//invokes the method that will set the queried movies to set the movies the respective author
			moviesListQueriedAndSettedAuthorsList = MovieLocalServiceUtil.getMoviesAndAuthorsQueried(movieList);
			
		}
		return moviesListQueriedAndSettedAuthorsList;
	}
}