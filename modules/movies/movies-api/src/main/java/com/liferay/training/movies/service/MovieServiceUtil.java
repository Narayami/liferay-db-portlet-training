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
 * Provides the remote service utility for Movie. This utility wraps
 * {@link com.liferay.training.movies.service.impl.MovieServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MovieService
 * @see com.liferay.training.movies.service.base.MovieServiceBaseImpl
 * @see com.liferay.training.movies.service.impl.MovieServiceImpl
 * @generated
 */
@ProviderType
public class MovieServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.movies.service.impl.MovieServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.training.movies.model.Movie addMovie(
		long groupId, String movieName, String description, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addMovie(groupId, movieName, description, rating,
			serviceContext);
	}

	public static com.liferay.training.movies.model.Movie deleteMovie(
		long movieId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMovie(movieId);
	}

	public static com.liferay.training.movies.model.Movie getMovie(long movieId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMovie(movieId);
	}

	public static java.util.List<com.liferay.training.movies.model.Movie> getMoviesByGroupId(
		long groupId, int start, int end) {
		return getService().getMoviesByGroupId(groupId, start, end);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.training.movies.model.Movie updateMovie(
		long movieId, String movieName, String description, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateMovie(movieId, movieName, description, rating,
			serviceContext);
	}

	public static MovieService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MovieService, MovieService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MovieService.class);

		ServiceTracker<MovieService, MovieService> serviceTracker = new ServiceTracker<MovieService, MovieService>(bundle.getBundleContext(),
				MovieService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}