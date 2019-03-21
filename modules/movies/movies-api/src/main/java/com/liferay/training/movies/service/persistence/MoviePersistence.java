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

package com.liferay.training.movies.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.liferay.training.movies.exception.NoSuchMovieException;
import com.liferay.training.movies.model.Movie;

/**
 * The persistence interface for the movie service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.movies.service.persistence.impl.MoviePersistenceImpl
 * @see MovieUtil
 * @generated
 */
@ProviderType
public interface MoviePersistence extends BasePersistence<Movie> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MovieUtil} to access the movie persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the movies where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching movies
	*/
	public java.util.List<Movie> findByUuid(String uuid);

	/**
	* Returns a range of all the movies where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @return the range of matching movies
	*/
	public java.util.List<Movie> findByUuid(String uuid, int start, int end);

	/**
	* Returns an ordered range of all the movies where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns an ordered range of all the movies where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first movie in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the first movie in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the last movie in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the last movie in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the movies before and after the current movie in the ordered set where uuid = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public Movie[] findByUuid_PrevAndNext(long movieId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Removes all the movies where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of movies where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching movies
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the movie where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchMovieException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByUUID_G(String uuid, long groupId)
		throws NoSuchMovieException;

	/**
	* Returns the movie where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the movie where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the movie where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the movie that was removed
	*/
	public Movie removeByUUID_G(String uuid, long groupId)
		throws NoSuchMovieException;

	/**
	* Returns the number of movies where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching movies
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the movies where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching movies
	*/
	public java.util.List<Movie> findByUuid_C(String uuid, long companyId);

	/**
	* Returns a range of all the movies where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @return the range of matching movies
	*/
	public java.util.List<Movie> findByUuid_C(String uuid, long companyId,
		int start, int end);

	/**
	* Returns an ordered range of all the movies where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns an ordered range of all the movies where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first movie in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the first movie in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the last movie in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the last movie in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the movies before and after the current movie in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public Movie[] findByUuid_C_PrevAndNext(long movieId, String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Removes all the movies where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of movies where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching movies
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Returns all the movies where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching movies
	*/
	public java.util.List<Movie> findByGroupId(long groupId);

	/**
	* Returns a range of all the movies where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @return the range of matching movies
	*/
	public java.util.List<Movie> findByGroupId(long groupId, int start, int end);

	/**
	* Returns an ordered range of all the movies where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns an ordered range of all the movies where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first movie in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the first movie in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the last movie in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the last movie in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the movies before and after the current movie in the ordered set where groupId = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public Movie[] findByGroupId_PrevAndNext(long movieId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns all the movies that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching movies that the user has permission to view
	*/
	public java.util.List<Movie> filterFindByGroupId(long groupId);

	/**
	* Returns a range of all the movies that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @return the range of matching movies that the user has permission to view
	*/
	public java.util.List<Movie> filterFindByGroupId(long groupId, int start,
		int end);

	/**
	* Returns an ordered range of all the movies that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching movies that the user has permission to view
	*/
	public java.util.List<Movie> filterFindByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the movies before and after the current movie in the ordered set of movies that the user has permission to view where groupId = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public Movie[] filterFindByGroupId_PrevAndNext(long movieId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Removes all the movies where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of movies where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching movies
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns the number of movies that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching movies that the user has permission to view
	*/
	public int filterCountByGroupId(long groupId);

	/**
	* Returns all the movies where movieName = &#63;.
	*
	* @param movieName the movie name
	* @return the matching movies
	*/
	public java.util.List<Movie> findByMovieName(String movieName);

	/**
	* Returns a range of all the movies where movieName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param movieName the movie name
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @return the range of matching movies
	*/
	public java.util.List<Movie> findByMovieName(String movieName, int start,
		int end);

	/**
	* Returns an ordered range of all the movies where movieName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param movieName the movie name
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByMovieName(String movieName, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns an ordered range of all the movies where movieName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param movieName the movie name
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByMovieName(String movieName, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first movie in the ordered set where movieName = &#63;.
	*
	* @param movieName the movie name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByMovieName_First(String movieName,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the first movie in the ordered set where movieName = &#63;.
	*
	* @param movieName the movie name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByMovieName_First(String movieName,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the last movie in the ordered set where movieName = &#63;.
	*
	* @param movieName the movie name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByMovieName_Last(String movieName,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the last movie in the ordered set where movieName = &#63;.
	*
	* @param movieName the movie name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByMovieName_Last(String movieName,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the movies before and after the current movie in the ordered set where movieName = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param movieName the movie name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public Movie[] findByMovieName_PrevAndNext(long movieId, String movieName,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Removes all the movies where movieName = &#63; from the database.
	*
	* @param movieName the movie name
	*/
	public void removeByMovieName(String movieName);

	/**
	* Returns the number of movies where movieName = &#63;.
	*
	* @param movieName the movie name
	* @return the number of matching movies
	*/
	public int countByMovieName(String movieName);

	/**
	* Returns all the movies where rating = &#63;.
	*
	* @param rating the rating
	* @return the matching movies
	*/
	public java.util.List<Movie> findByRating(int rating);

	/**
	* Returns a range of all the movies where rating = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rating the rating
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @return the range of matching movies
	*/
	public java.util.List<Movie> findByRating(int rating, int start, int end);

	/**
	* Returns an ordered range of all the movies where rating = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rating the rating
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByRating(int rating, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns an ordered range of all the movies where rating = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rating the rating
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByRating(int rating, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first movie in the ordered set where rating = &#63;.
	*
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByRating_First(int rating,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the first movie in the ordered set where rating = &#63;.
	*
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByRating_First(int rating,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the last movie in the ordered set where rating = &#63;.
	*
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByRating_Last(int rating,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the last movie in the ordered set where rating = &#63;.
	*
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByRating_Last(int rating,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the movies before and after the current movie in the ordered set where rating = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public Movie[] findByRating_PrevAndNext(long movieId, int rating,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Removes all the movies where rating = &#63; from the database.
	*
	* @param rating the rating
	*/
	public void removeByRating(int rating);

	/**
	* Returns the number of movies where rating = &#63;.
	*
	* @param rating the rating
	* @return the number of matching movies
	*/
	public int countByRating(int rating);

	/**
	* Returns all the movies where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @return the matching movies
	*/
	public java.util.List<Movie> findByG_G(long groupId, long movieId);

	/**
	* Returns a range of all the movies where groupId = &#63; and movieId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @return the range of matching movies
	*/
	public java.util.List<Movie> findByG_G(long groupId, long movieId,
		int start, int end);

	/**
	* Returns an ordered range of all the movies where groupId = &#63; and movieId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByG_G(long groupId, long movieId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns an ordered range of all the movies where groupId = &#63; and movieId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByG_G(long groupId, long movieId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first movie in the ordered set where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByG_G_First(long groupId, long movieId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the first movie in the ordered set where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByG_G_First(long groupId, long movieId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the last movie in the ordered set where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByG_G_Last(long groupId, long movieId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the last movie in the ordered set where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByG_G_Last(long groupId, long movieId,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns all the movies that the user has permission to view where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @return the matching movies that the user has permission to view
	*/
	public java.util.List<Movie> filterFindByG_G(long groupId, long movieId);

	/**
	* Returns a range of all the movies that the user has permission to view where groupId = &#63; and movieId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @return the range of matching movies that the user has permission to view
	*/
	public java.util.List<Movie> filterFindByG_G(long groupId, long movieId,
		int start, int end);

	/**
	* Returns an ordered range of all the movies that the user has permissions to view where groupId = &#63; and movieId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching movies that the user has permission to view
	*/
	public java.util.List<Movie> filterFindByG_G(long groupId, long movieId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Removes all the movies where groupId = &#63; and movieId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	*/
	public void removeByG_G(long groupId, long movieId);

	/**
	* Returns the number of movies where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @return the number of matching movies
	*/
	public int countByG_G(long groupId, long movieId);

	/**
	* Returns the number of movies that the user has permission to view where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @return the number of matching movies that the user has permission to view
	*/
	public int filterCountByG_G(long groupId, long movieId);

	/**
	* Returns all the movies where status = &#63;.
	*
	* @param status the status
	* @return the matching movies
	*/
	public java.util.List<Movie> findBystatus(int status);

	/**
	* Returns a range of all the movies where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @return the range of matching movies
	*/
	public java.util.List<Movie> findBystatus(int status, int start, int end);

	/**
	* Returns an ordered range of all the movies where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findBystatus(int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns an ordered range of all the movies where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findBystatus(int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first movie in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findBystatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the first movie in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchBystatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the last movie in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findBystatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the last movie in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchBystatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the movies before and after the current movie in the ordered set where status = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public Movie[] findBystatus_PrevAndNext(long movieId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Removes all the movies where status = &#63; from the database.
	*
	* @param status the status
	*/
	public void removeBystatus(int status);

	/**
	* Returns the number of movies where status = &#63;.
	*
	* @param status the status
	* @return the number of matching movies
	*/
	public int countBystatus(int status);

	/**
	* Returns all the movies where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching movies
	*/
	public java.util.List<Movie> findByG_S(long groupId, int status);

	/**
	* Returns a range of all the movies where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @return the range of matching movies
	*/
	public java.util.List<Movie> findByG_S(long groupId, int status, int start,
		int end);

	/**
	* Returns an ordered range of all the movies where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByG_S(long groupId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns an ordered range of all the movies where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching movies
	*/
	public java.util.List<Movie> findByG_S(long groupId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first movie in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByG_S_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the first movie in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByG_S_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the last movie in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public Movie findByG_S_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns the last movie in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public Movie fetchByG_S_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the movies before and after the current movie in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public Movie[] findByG_S_PrevAndNext(long movieId, long groupId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Returns all the movies that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching movies that the user has permission to view
	*/
	public java.util.List<Movie> filterFindByG_S(long groupId, int status);

	/**
	* Returns a range of all the movies that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @return the range of matching movies that the user has permission to view
	*/
	public java.util.List<Movie> filterFindByG_S(long groupId, int status,
		int start, int end);

	/**
	* Returns an ordered range of all the movies that the user has permissions to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching movies that the user has permission to view
	*/
	public java.util.List<Movie> filterFindByG_S(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns the movies before and after the current movie in the ordered set of movies that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public Movie[] filterFindByG_S_PrevAndNext(long movieId, long groupId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException;

	/**
	* Removes all the movies where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public void removeByG_S(long groupId, int status);

	/**
	* Returns the number of movies where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching movies
	*/
	public int countByG_S(long groupId, int status);

	/**
	* Returns the number of movies that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching movies that the user has permission to view
	*/
	public int filterCountByG_S(long groupId, int status);

	/**
	* Caches the movie in the entity cache if it is enabled.
	*
	* @param movie the movie
	*/
	public void cacheResult(Movie movie);

	/**
	* Caches the movies in the entity cache if it is enabled.
	*
	* @param movies the movies
	*/
	public void cacheResult(java.util.List<Movie> movies);

	/**
	* Creates a new movie with the primary key. Does not add the movie to the database.
	*
	* @param movieId the primary key for the new movie
	* @return the new movie
	*/
	public Movie create(long movieId);

	/**
	* Removes the movie with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param movieId the primary key of the movie
	* @return the movie that was removed
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public Movie remove(long movieId) throws NoSuchMovieException;

	public Movie updateImpl(Movie movie);

	/**
	* Returns the movie with the primary key or throws a {@link NoSuchMovieException} if it could not be found.
	*
	* @param movieId the primary key of the movie
	* @return the movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public Movie findByPrimaryKey(long movieId) throws NoSuchMovieException;

	/**
	* Returns the movie with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param movieId the primary key of the movie
	* @return the movie, or <code>null</code> if a movie with the primary key could not be found
	*/
	public Movie fetchByPrimaryKey(long movieId);

	@Override
	public java.util.Map<java.io.Serializable, Movie> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the movies.
	*
	* @return the movies
	*/
	public java.util.List<Movie> findAll();

	/**
	* Returns a range of all the movies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @return the range of movies
	*/
	public java.util.List<Movie> findAll(int start, int end);

	/**
	* Returns an ordered range of all the movies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of movies
	*/
	public java.util.List<Movie> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator);

	/**
	* Returns an ordered range of all the movies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MovieModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of movies
	* @param end the upper bound of the range of movies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of movies
	*/
	public java.util.List<Movie> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the movies from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of movies.
	*
	* @return the number of movies
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}