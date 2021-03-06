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

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.training.movies.exception.NoSuchAuthorException;
import com.liferay.training.movies.model.Author;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.AuthorLocalServiceUtil;
import com.liferay.training.movies.service.AuthorServiceUtil;
import com.liferay.training.movies.service.base.MovieLocalServiceBaseImpl;

/**
 * The implementation of the movie local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.training.movies.service.MovieLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MovieLocalServiceBaseImpl
 * @see com.liferay.training.movies.service.MovieLocalServiceUtil
 */
public class MovieLocalServiceImpl extends MovieLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public Movie addMovie(long groupId, String movieName, String description, int rating, ServiceContext serviceContext)
			throws PortalException {

		Group group = groupPersistence.findByPrimaryKey(groupId);

		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		
		long movieId = counterLocalService.increment(Movie.class.getName());
																			
		Movie movie = super.createMovie(movieId);
		
		// populate all movie object fields
		movie.setCompanyId(group.getCompanyId());
		movie.setGroupId(groupId);
		movie.setUserId(userId);
		movie.setDescription(description);
		movie.setMovieName(movieName);
		movie.setRating(rating);
		movie.setUserName(user.getScreenName());
		movie.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		movie.setCreateDate(serviceContext.getCreateDate(new Date()));

		// add permission resources
		boolean portletActions = false;
		boolean addGroupPermissions = true;
		boolean addGuestPermissions = true;
		
		// persist the movie
		movie = super.addMovie(movie);
		
		// when creating the movie, we create the permission resource along it.
		resourceLocalService.addResources(group.getCompanyId(), groupId, userId, Movie.class.getName(),
				movie.getMovieId(), portletActions, addGroupPermissions, addGuestPermissions);
		
		//set status
		movie.setStatus(WorkflowConstants.STATUS_DRAFT);
		movie.setStatusByUserId(userId);
		movie.setStatusByUserName(user.getFullName());
		movie.setStatusDate(serviceContext.getModifiedDate(null));
		
		// update asset
		updateAsset(movie, serviceContext);
		
		return startWorkflowInstance(userId, movie, serviceContext);
	}

	@Indexable(type = IndexableType.REINDEX)
	public Movie addMovieAndAuthor(long groupId, String movieName, String description, int rating, String authorName,
			String biography, ServiceContext serviceContext) throws PortalException {

		Movie movie = addMovie(groupId, movieName, description, rating, serviceContext);
		
		long userId = serviceContext.getUserId();

		Author author = AuthorServiceUtil.addAuthor(movie.getMovieId(), authorName, biography, serviceContext);
		author = AuthorLocalServiceUtil.addAuthor(author);
				
		return startWorkflowInstance(userId, movie, serviceContext);
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Movie updateMovie(Long movieId, String movieName, String description, int rating, ServiceContext serviceContext) 
			throws PortalException {
		
		Movie movie = getMovie(movieId);
		
		movie.setDescription(description);
		movie.setMovieName(movieName);
		movie.setModifiedDate(new Date());
		movie.setRating(rating);
		
		movie = super.updateMovie(movie);
		
		return movie;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public Movie deleteMovieAndAuthor(long movieId, long authorId) throws PortalException {

		//long userId = serviceContext.getUserId();
		
		Movie movie = getMovie(movieId);
		Author author = AuthorLocalServiceUtil.getAuthor(authorId);

		author = AuthorLocalServiceUtil.deleteAuthor(author);
		assetEntryLocalService.deleteEntry(Movie.class.getName(), movie.getMovieId());

		//return startWorkflowInstance(userId, movie, serviceContext);
		
		return deleteMovie(movie);
	}

	@Indexable(type = IndexableType.DELETE)
	public Movie deleteMovie(Long movieId) throws PortalException {

		Movie movie = getMovie(movieId);

		return deleteMovie(movie);
	}

	@Indexable(type = IndexableType.DELETE)
	public Movie deleteMovie(Movie movie) throws PortalException {
		
		//if we create the movie and the resource along it, when deleting we need to delete the resource permission too.
		resourceLocalService.deleteResource(movie, ResourceConstants.SCOPE_INDIVIDUAL);

		//delete asset data - delete associated asset and idexes to the entity to cleanup stored asset and indexed info
		assetEntryLocalService.deleteEntry(Movie.class.getName(), movie.getMovieId());
		
		//delete workflow instance
		workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(movie.getCompanyId(), 
				movie.getGroupId(), movie.getClass().getName(), movie.getMovieId());
		
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

	public List<Movie> getMoviesAndAuthors(int startPos, int endPost) {

		// fetch the movies
		List<Movie> movies = super.getMovies(startPos, endPost);
		
		// fetch authors and set the author to the movie
		if ((movies != null && (!movies.isEmpty()))) {

			Author author;
			
			for (Movie movie : movies) {
				try {
					author = AuthorLocalServiceUtil.getAuthorByMovieId(movie.getMovieId());
					movie.setAuthor(author);
					
				} catch (NoSuchAuthorException e) {
					e.printStackTrace();
				}	
			}
		}
		return movies;
	}
	
	//receives the queriedList so it can set the author to the movie
	public List<Movie> getMoviesAndAuthorsQueried(List<Movie> movies) {
		
		if ((movies != null && (!movies.isEmpty()))) {

			Author author;

			for (Movie movie : movies) {
				try {
					author = AuthorLocalServiceUtil.getAuthorByMovieId(movie.getMovieId());
					movie.setAuthor(author);
				} catch (NoSuchAuthorException e) {
					e.printStackTrace();
				}
			}	
		}
		return movies;
	}

	public List<Movie> getMovies(long groupId, long movieId, int start, int end, OrderByComparator<Movie> obc) {
		return moviePersistence.findByG_G(groupId, movieId, start, end, obc);

	}

	private void updateAsset(Movie movie, ServiceContext serviceContext) throws PortalException {
		
		assetEntryLocalService.updateEntry(serviceContext.getUserId(), serviceContext.getScopeGroupId(),
				movie.getCreateDate(), movie.getModifiedDate(), Movie.class.getName(), movie.getMovieId(),
				movie.getUuid(), movie.getRating(), serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true, movie.getCreateDate(), null, null, null,
				ContentTypes.TEXT_HTML, null, null, movie.getMovieName(), null, null, 0, 0,
				serviceContext.getAssetPriority());
	}
	
	
	public Movie updateStatus(long userId, long movieId, int status, ServiceContext serviceContext)
			throws PortalException, SystemException {
		
		User user = userLocalService.getUser(userId);
		Movie movie = getMovie(movieId);
		
		movie.setStatus(status);
		movie.setStatusByUserId(userId);
		movie.setStatusByUserName(user.getFullName());
		movie.setStatusDate(new Date());

		moviePersistence.update(movie);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateVisible(Movie.class.getName(), movieId, true);
		
		} else {	
			assetEntryLocalService.updateVisible(Movie.class.getName(), movieId, false);
		
		}
		
		return movie;
	}
	
	protected Movie startWorkflowInstance( long userId, Movie movie, ServiceContext serviceContext) 
			throws PortalException {

		Map<String, Serializable> workflowContext = new HashMap();

		String userPortraitURL = StringPool.BLANK;
		String userURL = StringPool.BLANK;

		if (serviceContext.getThemeDisplay() != null) {
			User user = userLocalService.getUser(userId);

			userPortraitURL = user.getPortraitURL(serviceContext.getThemeDisplay());
			userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
		}

		workflowContext.put(WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL);
		workflowContext.put(WorkflowConstants.CONTEXT_USER_URL, userURL);
		workflowContext.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME, Movie.class);
		
		return WorkflowHandlerRegistryUtil.startWorkflowInstance(movie.getCompanyId(), movie.getGroupId(), userId,
			Movie.class.getName(), movie.getMovieId(), movie, serviceContext, workflowContext);
		}
}
