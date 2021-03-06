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
 * Provides the local service utility for Author. This utility wraps
 * {@link com.liferay.training.movies.service.impl.AuthorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AuthorLocalService
 * @see com.liferay.training.movies.service.base.AuthorLocalServiceBaseImpl
 * @see com.liferay.training.movies.service.impl.AuthorLocalServiceImpl
 * @generated
 */
@ProviderType
public class AuthorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.movies.service.impl.AuthorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the author to the database. Also notifies the appropriate model listeners.
	*
	* @param author the author
	* @return the author that was added
	*/
	public static com.liferay.training.movies.model.Author addAuthor(
		com.liferay.training.movies.model.Author author) {
		return getService().addAuthor(author);
	}

	public static com.liferay.training.movies.model.Author addAuthor(
		long movieId, String authorName, String biography,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addAuthor(movieId, authorName, biography, serviceContext);
	}

	/**
	* Creates a new author with the primary key. Does not add the author to the database.
	*
	* @param authorId the primary key for the new author
	* @return the new author
	*/
	public static com.liferay.training.movies.model.Author createAuthor(
		long authorId) {
		return getService().createAuthor(authorId);
	}

	/**
	* Deletes the author from the database. Also notifies the appropriate model listeners.
	*
	* @param author the author
	* @return the author that was removed
	*/
	public static com.liferay.training.movies.model.Author deleteAuthor(
		com.liferay.training.movies.model.Author author) {
		return getService().deleteAuthor(author);
	}

	/**
	* Deletes the author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorId the primary key of the author
	* @return the author that was removed
	* @throws PortalException if a author with the primary key could not be found
	*/
	public static com.liferay.training.movies.model.Author deleteAuthor(
		long authorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAuthor(authorId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.movies.model.impl.AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.movies.model.impl.AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.training.movies.model.Author fetchAuthor(
		long authorId) {
		return getService().fetchAuthor(authorId);
	}

	/**
	* Returns the author matching the UUID and group.
	*
	* @param uuid the author's UUID
	* @param groupId the primary key of the group
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public static com.liferay.training.movies.model.Author fetchAuthorByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchAuthorByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the author with the primary key.
	*
	* @param authorId the primary key of the author
	* @return the author
	* @throws PortalException if a author with the primary key could not be found
	*/
	public static com.liferay.training.movies.model.Author getAuthor(
		long authorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAuthor(authorId);
	}

	public static com.liferay.training.movies.model.Author getAuthorByMovieId(
		long movieId)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getService().getAuthorByMovieId(movieId);
	}

	/**
	* Returns the author matching the UUID and group.
	*
	* @param uuid the author's UUID
	* @param groupId the primary key of the group
	* @return the matching author
	* @throws PortalException if a matching author could not be found
	*/
	public static com.liferay.training.movies.model.Author getAuthorByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAuthorByUuidAndGroupId(uuid, groupId);
	}

	public static int getAuthorCountByGroupId(long groupId) {
		return getService().getAuthorCountByGroupId(groupId);
	}

	public static int getAuthorCountByMovies(long movieId, long authorId) {
		return getService().getAuthorCountByMovies(movieId, authorId);
	}

	/**
	* Returns a range of all the authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.movies.model.impl.AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of authors
	*/
	public static java.util.List<com.liferay.training.movies.model.Author> getAuthors(
		int start, int end) {
		return getService().getAuthors(start, end);
	}

	public static java.util.List<com.liferay.training.movies.model.Author> getAuthorsByGroupId(
		long groupId) {
		return getService().getAuthorsByGroupId(groupId);
	}

	public static java.util.List<com.liferay.training.movies.model.Author> getAuthorsByGroupId(
		long groupId, int start, int end) {
		return getService().getAuthorsByGroupId(groupId, start, end);
	}

	/**
	* Returns all the authors matching the UUID and company.
	*
	* @param uuid the UUID of the authors
	* @param companyId the primary key of the company
	* @return the matching authors, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.training.movies.model.Author> getAuthorsByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService().getAuthorsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of authors matching the UUID and company.
	*
	* @param uuid the UUID of the authors
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching authors, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.training.movies.model.Author> getAuthorsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.training.movies.model.Author> orderByComparator) {
		return getService()
				   .getAuthorsByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of authors.
	*
	* @return the number of authors
	*/
	public static int getAuthorsCount() {
		return getService().getAuthorsCount();
	}

	public static com.liferay.training.movies.model.Author getAuthotByMovieId(
		Long authorId, long movieId)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getService().getAuthotByMovieId(authorId, movieId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
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

	/**
	* Updates the author in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param author the author
	* @return the author that was updated
	*/
	public static com.liferay.training.movies.model.Author updateAuthor(
		com.liferay.training.movies.model.Author author) {
		return getService().updateAuthor(author);
	}

	public static com.liferay.training.movies.model.Author updateAuthor(
		long authorId, String authorName, String biography,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateAuthor(authorId, authorName, biography, serviceContext);
	}

	public static AuthorLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AuthorLocalService, AuthorLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AuthorLocalService.class);

		ServiceTracker<AuthorLocalService, AuthorLocalService> serviceTracker = new ServiceTracker<AuthorLocalService, AuthorLocalService>(bundle.getBundleContext(),
				AuthorLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}