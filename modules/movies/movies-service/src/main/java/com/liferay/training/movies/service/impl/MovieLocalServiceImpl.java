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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.base.MovieLocalServiceBaseImpl;

/**
 * The implementation of the movie local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.movies.service.MovieLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MovieLocalServiceBaseImpl
 * @see com.liferay.training.movies.service.MovieLocalServiceUtil
 */
public class MovieLocalServiceImpl extends MovieLocalServiceBaseImpl {
	
	
	public Movie addMovie(long groupId, String movieName, String description, 
			int rating, ServiceContext serviceContext) throws PortalException {
		
		//Group is used for the scoping the Movie entity to the site
		Group group = groupPersistence.findByPrimaryKey(groupId);
		
		//getting the user, first get the user id go get the user : userPersistence || userLocalService
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		
		
		//Generate primary key for the new movie - referencing the movie class in the specific movie about to create
		long movieId = counterLocalService.increment(Movie.class.getName()); //counterLocalService helps with primary key
		
		//create new movie object
		Movie movie = super.createMovie(movieId);
		
		//populate all movie object fields
		movie.setCompanyId(group.getCompanyId());
		movie.setGroupId(groupId);
		movie.setUserId(userId);
		movie.setDescription(description);
		movie.setMovieName(movieName);
		movie.setRating(rating);
		movie.setUserName(user.getScreenName());
		movie.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		movie.setCreateDate(serviceContext.getCreateDate(new Date()));
		
		//persist the movie
		movie = super.addMovie(movie);
		
		//add permission resources
		boolean portletActions = false;
		boolean addGroupPermissions = true;
		boolean addGuestPermissions = true;
		
		//when creating the movie, we create the permission resource along it.
		resourceLocalService.addResources(group.getCompanyId(),groupId, userId, Movie.class.getName(), 
				movie.getMovieId(), portletActions, addGroupPermissions, addGuestPermissions);
		
		return movie;
	}
	
	public Movie deleteMovie(Long movieId) throws PortalException {
		Movie movie = getMovie(movieId);
		
		return deleteMovie(movie);
	}
	
	public Movie deleteMovie(Movie movie) throws PortalException {
		
		//if we create the movie and the resource along it, when deleting we need to delete the resource permission too.
		resourceLocalService.deleteResource(movie, ResourceConstants.SCOPE_INDIVIDUAL);
		
		//delete asset data - delete associated asset and idexes to the entity to clean up stored asset and indexed info
		assetEntryLocalService.deleteEntry(Movie.class.getName(), movie.getMovieId());
		
		return super.deleteMovie(movie);
	}
	
	public List<Movie> getMoviesByGroupId(Long groupId) {
		
		return moviePersistence.findByGroupId(groupId);
	}
	
	public List<Movie> getMoviesByGroupId(Long groupId, int start, int end) {
		
		return moviePersistence.findByGroupId(groupId, start, end);
	}
	
	public int getMovieCountByGroupId(long groupId) {
		
		return moviePersistence.countByGroupId(groupId);
	}
	
	
	
	public Movie updateMovie(Long movieId, String movieName, String description, 
			int rating, ServiceContext serviceContext) throws PortalException {
		
		Movie movie = getMovie(movieId);
		
		//update changes to movie
		movie.setDescription(description);
		movie.setMovieName(movieName);
		movie.setModifiedDate(new Date());
		movie.setRating(rating);
		
		//persist the changes
		movie = super.updateMovie(movie);
		
		return movie;
	}
}