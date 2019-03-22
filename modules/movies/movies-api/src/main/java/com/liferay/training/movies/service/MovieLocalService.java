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

package com.liferay.training.movies.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.training.movies.model.Movie;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Movie. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MovieLocalServiceUtil
 * @see com.liferay.training.movies.service.base.MovieLocalServiceBaseImpl
 * @see com.liferay.training.movies.service.impl.MovieLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface MovieLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MovieLocalServiceUtil} to access the movie local service. Add custom service methods to {@link com.liferay.training.movies.service.impl.MovieLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Movie addMovie(long groupId, String movieName, String description,
		int rating, ServiceContext serviceContext) throws PortalException;

	/**
	* Adds the movie to the database. Also notifies the appropriate model listeners.
	*
	* @param movie the movie
	* @return the movie that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Movie addMovie(Movie movie);

	@Indexable(type = IndexableType.REINDEX)
	public Movie addMovieAndAuthor(long groupId, String movieName,
		String description, int rating, String authorName, String biography,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Creates a new movie with the primary key. Does not add the movie to the database.
	*
	* @param movieId the primary key for the new movie
	* @return the new movie
	*/
	@Transactional(enabled = false)
	public Movie createMovie(long movieId);

	@Indexable(type = IndexableType.DELETE)
	public Movie deleteMovie(Long movieId) throws PortalException;

	/**
	* Deletes the movie with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param movieId the primary key of the movie
	* @return the movie that was removed
	* @throws PortalException if a movie with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Movie deleteMovie(long movieId) throws PortalException;

	/**
	* Deletes the movie from the database. Also notifies the appropriate model listeners.
	*
	* @param movie the movie
	* @return the movie that was removed
	* @throws PortalException
	*/
	@Indexable(type = IndexableType.DELETE)
	public Movie deleteMovie(Movie movie) throws PortalException;

	@Indexable(type = IndexableType.DELETE)
	public Movie deleteMovieAndAuthor(long movieId, long authorId)
		throws PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.movies.model.impl.MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.movies.model.impl.MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Movie fetchMovie(long movieId);

	/**
	* Returns the movie matching the UUID and group.
	*
	* @param uuid the movie's UUID
	* @param groupId the primary key of the group
	* @return the matching movie, or <code>null</code> if a matching movie could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Movie fetchMovieByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the movie with the primary key.
	*
	* @param movieId the primary key of the movie
	* @return the movie
	* @throws PortalException if a movie with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Movie getMovie(long movieId) throws PortalException;

	/**
	* Returns the movie matching the UUID and group.
	*
	* @param uuid the movie's UUID
	* @param groupId the primary key of the group
	* @return the matching movie
	* @throws PortalException if a matching movie could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Movie getMovieByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMovieCountByGroupId(long groupId);

	/**
	* Returns a range of all the movies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.movies.model.impl.MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @return the range of movies
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Movie> getMovies(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Movie> getMovies(long groupId, long movieId, int start,
		int end, OrderByComparator<Movie> obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Movie> getMoviesAndAuthors(int startPos, int endPost);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Movie> getMoviesAndAuthorsQueried(List<Movie> movies);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Movie> getMoviesByGroupId(Long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Movie> getMoviesByGroupId(Long groupId, int start, int end);

	/**
	* Returns all the movies matching the UUID and company.
	*
	* @param uuid the UUID of the movies
	* @param companyId the primary key of the company
	* @return the matching movies, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Movie> getMoviesByUuidAndCompanyId(String uuid, long companyId);

	/**
	* Returns a range of movies matching the UUID and company.
	*
	* @param uuid the UUID of the movies
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching movies, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Movie> getMoviesByUuidAndCompanyId(String uuid, long companyId,
		int start, int end, OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the number of movies.
	*
	* @return the number of movies
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMoviesCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public Movie updateMovie(Long movieId, String movieName,
		String description, int rating, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Updates the movie in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param movie the movie
	* @return the movie that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Movie updateMovie(Movie movie);

	public Movie updateStatus(long userId, long movieId, int status,
		ServiceContext serviceContext) throws PortalException, SystemException;
}