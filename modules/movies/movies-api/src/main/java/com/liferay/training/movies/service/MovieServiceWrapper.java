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
 * Provides a wrapper for {@link MovieService}.
 *
 * @author Brian Wing Shun Chan
 * @see MovieService
 * @generated
 */
@ProviderType
public class MovieServiceWrapper implements MovieService,
	ServiceWrapper<MovieService> {
	public MovieServiceWrapper(MovieService movieService) {
		_movieService = movieService;
	}

	@Override
	public com.liferay.training.movies.model.Movie addMovie(long groupId,
		String movieName, String description, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _movieService.addMovie(groupId, movieName, description, rating,
			serviceContext);
	}

	@Override
	public com.liferay.training.movies.model.Movie deleteMovie(long movieId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _movieService.deleteMovie(movieId);
	}

	@Override
	public com.liferay.training.movies.model.Movie getMovie(long movieId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _movieService.getMovie(movieId);
	}

	@Override
	public java.util.List<com.liferay.training.movies.model.Movie> getMoviesByGroupId(
		long groupId, int start, int end) {
		return _movieService.getMoviesByGroupId(groupId, start, end);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _movieService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.training.movies.model.Movie updateMovie(long movieId,
		String movieName, String description, int rating,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _movieService.updateMovie(movieId, movieName, description,
			rating, serviceContext);
	}

	@Override
	public MovieService getWrappedService() {
		return _movieService;
	}

	@Override
	public void setWrappedService(MovieService movieService) {
		_movieService = movieService;
	}

	private MovieService _movieService;
}