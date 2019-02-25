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
 * Provides the remote service utility for Author. This utility wraps
 * {@link com.liferay.training.movies.service.impl.AuthorServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AuthorService
 * @see com.liferay.training.movies.service.base.AuthorServiceBaseImpl
 * @see com.liferay.training.movies.service.impl.AuthorServiceImpl
 * @generated
 */
@ProviderType
public class AuthorServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.movies.service.impl.AuthorServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.training.movies.model.Author addAuthor(
		long movieId, String authorName, String biography,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addAuthor(movieId, authorName, biography, serviceContext);
	}

	public static com.liferay.training.movies.model.Author deleteAuthor(
		long authorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAuthor(authorId);
	}

	public static com.liferay.training.movies.model.Author getAuthor(
		long authorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAuthor(authorId);
	}

	public static java.util.List<com.liferay.training.movies.model.Author> getAuthorsByGroupId(
		long groupId, int start, int end) {
		return getService().getAuthorsByGroupId(groupId, start, end);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.training.movies.model.Author updateAuthor(
		long authorId, String authorName, String biography,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateAuthor(authorId, authorName, biography, serviceContext);
	}

	public static AuthorService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AuthorService, AuthorService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AuthorService.class);

		ServiceTracker<AuthorService, AuthorService> serviceTracker = new ServiceTracker<AuthorService, AuthorService>(bundle.getBundleContext(),
				AuthorService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}