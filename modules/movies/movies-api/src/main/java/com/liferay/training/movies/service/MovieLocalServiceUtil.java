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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Movie. This utility wraps
 * {@link com.liferay.training.movies.service.impl.MovieLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MovieLocalService
 * @see com.liferay.training.movies.service.base.MovieLocalServiceBaseImpl
 * @see com.liferay.training.movies.service.impl.MovieLocalServiceImpl
 * @generated
 */
@ProviderType
public class MovieLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.movies.service.impl.MovieLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.training.movies.model.Movie addMovie(
		long groupId, String movieName, String description, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addMovie(groupId, movieName, description, rating,
			serviceContext);
	}

	/**
	* Adds the movie to the database. Also notifies the appropriate model listeners.
	*
	* @param movie the movie
	* @return the movie that was added
	*/
	public static com.liferay.training.movies.model.Movie addMovie(
		com.liferay.training.movies.model.Movie movie) {
		return getService().addMovie(movie);
	}

	public static com.liferay.training.movies.model.Movie addMovieAndAuthor(
		long groupId, String movieName, String description, int rating,
		String authorName, String biography,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addMovieAndAuthor(groupId, movieName, description, rating,
			authorName, biography, serviceContext);
	}

	/**
	* Creates a new movie with the primary key. Does not add the movie to the database.
	*
	* @param movieId the primary key for the new movie
	* @return the new movie
	*/
	public static com.liferay.training.movies.model.Movie createMovie(
		long movieId) {
		return getService().createMovie(movieId);
	}

	public static com.liferay.training.movies.model.Movie deleteMovie(
		Long movieId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMovie(movieId);
	}

	/**
	* Deletes the movie with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param movieId the primary key of the movie
	* @return the movie that was removed
	* @throws PortalException if a movie with the primary key could not be found
	*/
	public static com.liferay.training.movies.model.Movie deleteMovie(
		long movieId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMovie(movieId);
	}

	/**
	* Deletes the movie from the database. Also notifies the appropriate model listeners.
	*
	* @param movie the movie
	* @return the movie that was removed
	* @throws PortalException
	*/
	public static com.liferay.training.movies.model.Movie deleteMovie(
		com.liferay.training.movies.model.Movie movie)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMovie(movie);
	}

	public static com.liferay.training.movies.model.Movie deleteMovieAndAuthor(
		long movieId, long authorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMovieAndAuthor(movieId, authorId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.training.movies.model.Movie fetchMovie(
		long movieId) {
		return getService().fetchMovie(movieId);
	}

	/**
	* Returns the movie matching the UUID and group.
	*
	* @param uuid the movie's UUID
	* @param groupId the primary key of the group
	* @return the matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static com.liferay.training.movies.model.Movie fetchMovieByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchMovieByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the movie with the primary key.
	*
	* @param movieId the primary key of the movie
	* @return the movie
	* @throws PortalException if a movie with the primary key could not be found
	*/
	public static com.liferay.training.movies.model.Movie getMovie(long movieId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMovie(movieId);
	}

	/**
	* Returns the movie matching the UUID and group.
	*
	* @param uuid the movie's UUID
	* @param groupId the primary key of the group
	* @return the matching movie
	* @throws PortalException if a matching movie could not be found
	*/
	public static com.liferay.training.movies.model.Movie getMovieByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMovieByUuidAndGroupId(uuid, groupId);
	}

	public static int getMovieCountByGroupId(long groupId) {
		return getService().getMovieCountByGroupId(groupId);
	}

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
	public static java.util.List<com.liferay.training.movies.model.Movie> getMovies(
		int start, int end) {
		return getService().getMovies(start, end);
	}

	public static java.util.List<com.liferay.training.movies.model.Movie> getMoviesAndAuthors(
		int startPos, int endPost) {
		return getService().getMoviesAndAuthors(startPos, endPost);
	}

	public static java.util.List<com.liferay.training.movies.model.Movie> getMoviesByGroupId(
		Long groupId) {
		return getService().getMoviesByGroupId(groupId);
	}

	public static java.util.List<com.liferay.training.movies.model.Movie> getMoviesByGroupId(
		Long groupId, int start, int end) {
		return getService().getMoviesByGroupId(groupId, start, end);
	}

	/**
	* Returns all the movies matching the UUID and company.
	*
	* @param uuid the UUID of the movies
	* @param companyId the primary key of the company
	* @return the matching movies, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.training.movies.model.Movie> getMoviesByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService().getMoviesByUuidAndCompanyId(uuid, companyId);
	}

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
	public static java.util.List<com.liferay.training.movies.model.Movie> getMoviesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.training.movies.model.Movie> orderByComparator) {
		return getService()
				   .getMoviesByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of movies.
	*
	* @return the number of movies
	*/
	public static int getMoviesCount() {
		return getService().getMoviesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.liferay.training.movies.model.Movie updateMovie(
		Long movieId, String movieName, String description, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateMovie(movieId, movieName, description, rating,
			serviceContext);
	}

	/**
	* Updates the movie in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param movie the movie
	* @return the movie that was updated
	*/
	public static com.liferay.training.movies.model.Movie updateMovie(
		com.liferay.training.movies.model.Movie movie) {
		return getService().updateMovie(movie);
	}

	public static MovieLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MovieLocalService, MovieLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MovieLocalService.class);

		ServiceTracker<MovieLocalService, MovieLocalService> serviceTracker = new ServiceTracker<MovieLocalService, MovieLocalService>(bundle.getBundleContext(),
				MovieLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}