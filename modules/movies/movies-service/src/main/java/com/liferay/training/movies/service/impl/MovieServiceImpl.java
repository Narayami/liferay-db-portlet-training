/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.movies.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.permission.MoviePermissionChecker;
import com.liferay.training.movies.service.base.MovieServiceBaseImpl;
import com.liferay.training.movies.service.permission.impl.MoviePermissionCheckerImpl;

/**
 * The implementation of the movie remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.movies.service.MovieService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MovieServiceBaseImpl
 * @see com.liferay.training.movies.service.MovieServiceUtil
 */
public class MovieServiceImpl extends MovieServiceBaseImpl {
	
	/**
	 * Service builder classes are not OSGi components but Spring beans and you
	 * cannot use the @Reference annotation. Use @ServiceReference instead.
	 */
	@ServiceReference(
		type = com.liferay.training.movies.permission.MoviePermissionChecker.class
	)
	private MoviePermissionChecker moviePermissionChecker;
	
	@Indexable(
		type = IndexableType.REINDEX
	)
	public Movie addMovie(long groupId, String movieName, String description, 
			int rating, ServiceContext serviceContext) throws PortalException {
		
		moviePermissionChecker.checkTopLevel(getPermissionChecker(), 
				serviceContext.getScopeGroupId(), MoviePermissionCheckerImpl.ADD_MOVIE);
		
		
		return movieLocalService.addMovie(groupId, movieName, description, rating, serviceContext);
	} 
	
	@Indexable(
			type = IndexableType.DELETE
	)
	public Movie deleteMovie(long movieId) throws PortalException{
		Movie movie = movieLocalService.getMovie(movieId);
		
		moviePermissionChecker.check(getPermissionChecker(), movie.getGroupId(), 
				movie.getMovieId(), ActionKeys.DELETE);
		
		return movieLocalService.deleteMovie(movie);
	}
	
	public Movie getMovie(long movieId) throws PortalException {
		Movie movie = movieLocalService.getMovie(movieId);
		
		
		moviePermissionChecker.check(getPermissionChecker(), 
				movie.getGroupId(), movie.getMovieId(), ActionKeys.VIEW);
		
		
		return movie;
	}
		
	public List<Movie> getMoviesByGroupId(long groupId, int start, 
			int end) {
		
		return movieLocalService.getMoviesByGroupId(groupId, start, end);
	} 
	
	@Indexable(
			type = IndexableType.REINDEX
		)
	public Movie updateMovie(long movieId, String movieName, 
			String description, int rating, ServiceContext serviceContext) throws PortalException {
		
		Movie movie = movieLocalService.getMovie(movieId);
		
		
		moviePermissionChecker.check(getPermissionChecker(), movie.getGroupId(), 
				movie.getMovieId(), ActionKeys.UPDATE);
		
		
		return movieLocalService.updateMovie(movieId, movieName, description, rating, serviceContext);
	}
}