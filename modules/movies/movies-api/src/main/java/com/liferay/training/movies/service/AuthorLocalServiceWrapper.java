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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AuthorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuthorLocalService
 * @generated
 */
@ProviderType
public class AuthorLocalServiceWrapper implements AuthorLocalService,
	ServiceWrapper<AuthorLocalService> {
	public AuthorLocalServiceWrapper(AuthorLocalService authorLocalService) {
		_authorLocalService = authorLocalService;
	}

	/**
	* Adds the author to the database. Also notifies the appropriate model listeners.
	*
	* @param author the author
	* @return the author that was added
	*/
	@Override
	public com.liferay.training.movies.model.Author addAuthor(
		com.liferay.training.movies.model.Author author) {
		return _authorLocalService.addAuthor(author);
	}

	@Override
	public com.liferay.training.movies.model.Author addAuthor(long movieId,
		String authorName, String biography,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _authorLocalService.addAuthor(movieId, authorName, biography,
			serviceContext);
	}

	/**
	* Creates a new author with the primary key. Does not add the author to the database.
	*
	* @param authorId the primary key for the new author
	* @return the new author
	*/
	@Override
	public com.liferay.training.movies.model.Author createAuthor(long authorId) {
		return _authorLocalService.createAuthor(authorId);
	}

	/**
	* Deletes the author from the database. Also notifies the appropriate model listeners.
	*
	* @param author the author
	* @return the author that was removed
	*/
	@Override
	public com.liferay.training.movies.model.Author deleteAuthor(
		com.liferay.training.movies.model.Author author) {
		return _authorLocalService.deleteAuthor(author);
	}

	/**
	* Deletes the author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorId the primary key of the author
	* @return the author that was removed
	* @throws PortalException if a author with the primary key could not be found
	*/
	@Override
	public com.liferay.training.movies.model.Author deleteAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _authorLocalService.deleteAuthor(authorId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _authorLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _authorLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _authorLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _authorLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _authorLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _authorLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _authorLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.training.movies.model.Author fetchAuthor(long authorId) {
		return _authorLocalService.fetchAuthor(authorId);
	}

	/**
	* Returns the author matching the UUID and group.
	*
	* @param uuid the author's UUID
	* @param groupId the primary key of the group
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	@Override
	public com.liferay.training.movies.model.Author fetchAuthorByUuidAndGroupId(
		String uuid, long groupId) {
		return _authorLocalService.fetchAuthorByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _authorLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the author with the primary key.
	*
	* @param authorId the primary key of the author
	* @return the author
	* @throws PortalException if a author with the primary key could not be found
	*/
	@Override
	public com.liferay.training.movies.model.Author getAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _authorLocalService.getAuthor(authorId);
	}

	@Override
	public com.liferay.training.movies.model.Author getAuthorByMovieId(
		long movieId)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return _authorLocalService.getAuthorByMovieId(movieId);
	}

	/**
	* Returns the author matching the UUID and group.
	*
	* @param uuid the author's UUID
	* @param groupId the primary key of the group
	* @return the matching author
	* @throws PortalException if a matching author could not be found
	*/
	@Override
	public com.liferay.training.movies.model.Author getAuthorByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _authorLocalService.getAuthorByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public int getAuthorCountByGroupId(long groupId) {
		return _authorLocalService.getAuthorCountByGroupId(groupId);
	}

	@Override
	public int getAuthorCountByMovies(long movieId, long authorId) {
		return _authorLocalService.getAuthorCountByMovies(movieId, authorId);
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
	@Override
	public java.util.List<com.liferay.training.movies.model.Author> getAuthors(
		int start, int end) {
		return _authorLocalService.getAuthors(start, end);
	}

	@Override
	public java.util.List<com.liferay.training.movies.model.Author> getAuthorsByGroupId(
		long groupId) {
		return _authorLocalService.getAuthorsByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.training.movies.model.Author> getAuthorsByGroupId(
		long groupId, int start, int end) {
		return _authorLocalService.getAuthorsByGroupId(groupId, start, end);
	}

	/**
	* Returns all the authors matching the UUID and company.
	*
	* @param uuid the UUID of the authors
	* @param companyId the primary key of the company
	* @return the matching authors, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.training.movies.model.Author> getAuthorsByUuidAndCompanyId(
		String uuid, long companyId) {
		return _authorLocalService.getAuthorsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.liferay.training.movies.model.Author> getAuthorsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.training.movies.model.Author> orderByComparator) {
		return _authorLocalService.getAuthorsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of authors.
	*
	* @return the number of authors
	*/
	@Override
	public int getAuthorsCount() {
		return _authorLocalService.getAuthorsCount();
	}

	@Override
	public com.liferay.training.movies.model.Author getAuthotByMovieId(
		Long authorId, long movieId)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return _authorLocalService.getAuthotByMovieId(authorId, movieId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _authorLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _authorLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _authorLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _authorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the author in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param author the author
	* @return the author that was updated
	*/
	@Override
	public com.liferay.training.movies.model.Author updateAuthor(
		com.liferay.training.movies.model.Author author) {
		return _authorLocalService.updateAuthor(author);
	}

	@Override
	public com.liferay.training.movies.model.Author updateAuthor(
		long authorId, String authorName, String biography,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _authorLocalService.updateAuthor(authorId, authorName,
			biography, serviceContext);
	}

	@Override
	public AuthorLocalService getWrappedService() {
		return _authorLocalService;
	}

	@Override
	public void setWrappedService(AuthorLocalService authorLocalService) {
		_authorLocalService = authorLocalService;
	}

	private AuthorLocalService _authorLocalService;
}