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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.training.movies.model.Movie;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the movie service. This utility wraps {@link com.liferay.training.movies.service.persistence.impl.MoviePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MoviePersistence
 * @see com.liferay.training.movies.service.persistence.impl.MoviePersistenceImpl
 * @generated
 */
@ProviderType
public class MovieUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Movie movie) {
		getPersistence().clearCache(movie);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Movie> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Movie> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Movie> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Movie update(Movie movie) {
		return getPersistence().update(movie);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Movie update(Movie movie, ServiceContext serviceContext) {
		return getPersistence().update(movie, serviceContext);
	}

	/**
	* Returns all the movies where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching movies
	*/
	public static List<Movie> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Movie> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Movie> findByUuid(String uuid, int start, int end,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Movie> findByUuid(String uuid, int start, int end,
		OrderByComparator<Movie> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first movie in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public static Movie findByUuid_First(String uuid,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first movie in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByUuid_First(String uuid,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last movie in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public static Movie findByUuid_Last(String uuid,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last movie in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByUuid_Last(String uuid,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the movies before and after the current movie in the ordered set where uuid = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public static Movie[] findByUuid_PrevAndNext(long movieId, String uuid,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence()
				   .findByUuid_PrevAndNext(movieId, uuid, orderByComparator);
	}

	/**
	* Removes all the movies where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of movies where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching movies
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the movie where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchMovieException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public static Movie findByUUID_G(String uuid, long groupId)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the movie where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the movie where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the movie where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the movie that was removed
	*/
	public static Movie removeByUUID_G(String uuid, long groupId)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of movies where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching movies
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the movies where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching movies
	*/
	public static List<Movie> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Movie> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Movie> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Movie> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first movie in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public static Movie findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first movie in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last movie in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public static Movie findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last movie in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static Movie[] findByUuid_C_PrevAndNext(long movieId, String uuid,
		long companyId, OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(movieId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the movies where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of movies where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching movies
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the movies where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching movies
	*/
	public static List<Movie> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<Movie> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<Movie> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static List<Movie> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Movie> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first movie in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public static Movie findByGroupId_First(long groupId,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first movie in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByGroupId_First(long groupId,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last movie in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public static Movie findByGroupId_Last(long groupId,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last movie in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByGroupId_Last(long groupId,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the movies before and after the current movie in the ordered set where groupId = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public static Movie[] findByGroupId_PrevAndNext(long movieId, long groupId,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(movieId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the movies that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching movies that the user has permission to view
	*/
	public static List<Movie> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

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
	public static List<Movie> filterFindByGroupId(long groupId, int start,
		int end) {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

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
	public static List<Movie> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the movies before and after the current movie in the ordered set of movies that the user has permission to view where groupId = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public static Movie[] filterFindByGroupId_PrevAndNext(long movieId,
		long groupId, OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(movieId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the movies where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of movies where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching movies
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of movies that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching movies that the user has permission to view
	*/
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the movies where movieName = &#63;.
	*
	* @param movieName the movie name
	* @return the matching movies
	*/
	public static List<Movie> findByMovieName(String movieName) {
		return getPersistence().findByMovieName(movieName);
	}

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
	public static List<Movie> findByMovieName(String movieName, int start,
		int end) {
		return getPersistence().findByMovieName(movieName, start, end);
	}

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
	public static List<Movie> findByMovieName(String movieName, int start,
		int end, OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .findByMovieName(movieName, start, end, orderByComparator);
	}

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
	public static List<Movie> findByMovieName(String movieName, int start,
		int end, OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMovieName(movieName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first movie in the ordered set where movieName = &#63;.
	*
	* @param movieName the movie name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public static Movie findByMovieName_First(String movieName,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence()
				   .findByMovieName_First(movieName, orderByComparator);
	}

	/**
	* Returns the first movie in the ordered set where movieName = &#63;.
	*
	* @param movieName the movie name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByMovieName_First(String movieName,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .fetchByMovieName_First(movieName, orderByComparator);
	}

	/**
	* Returns the last movie in the ordered set where movieName = &#63;.
	*
	* @param movieName the movie name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public static Movie findByMovieName_Last(String movieName,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence()
				   .findByMovieName_Last(movieName, orderByComparator);
	}

	/**
	* Returns the last movie in the ordered set where movieName = &#63;.
	*
	* @param movieName the movie name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByMovieName_Last(String movieName,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .fetchByMovieName_Last(movieName, orderByComparator);
	}

	/**
	* Returns the movies before and after the current movie in the ordered set where movieName = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param movieName the movie name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public static Movie[] findByMovieName_PrevAndNext(long movieId,
		String movieName, OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence()
				   .findByMovieName_PrevAndNext(movieId, movieName,
			orderByComparator);
	}

	/**
	* Removes all the movies where movieName = &#63; from the database.
	*
	* @param movieName the movie name
	*/
	public static void removeByMovieName(String movieName) {
		getPersistence().removeByMovieName(movieName);
	}

	/**
	* Returns the number of movies where movieName = &#63;.
	*
	* @param movieName the movie name
	* @return the number of matching movies
	*/
	public static int countByMovieName(String movieName) {
		return getPersistence().countByMovieName(movieName);
	}

	/**
	* Returns all the movies where rating = &#63;.
	*
	* @param rating the rating
	* @return the matching movies
	*/
	public static List<Movie> findByRating(int rating) {
		return getPersistence().findByRating(rating);
	}

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
	public static List<Movie> findByRating(int rating, int start, int end) {
		return getPersistence().findByRating(rating, start, end);
	}

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
	public static List<Movie> findByRating(int rating, int start, int end,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .findByRating(rating, start, end, orderByComparator);
	}

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
	public static List<Movie> findByRating(int rating, int start, int end,
		OrderByComparator<Movie> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByRating(rating, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first movie in the ordered set where rating = &#63;.
	*
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public static Movie findByRating_First(int rating,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence().findByRating_First(rating, orderByComparator);
	}

	/**
	* Returns the first movie in the ordered set where rating = &#63;.
	*
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByRating_First(int rating,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence().fetchByRating_First(rating, orderByComparator);
	}

	/**
	* Returns the last movie in the ordered set where rating = &#63;.
	*
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public static Movie findByRating_Last(int rating,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence().findByRating_Last(rating, orderByComparator);
	}

	/**
	* Returns the last movie in the ordered set where rating = &#63;.
	*
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByRating_Last(int rating,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence().fetchByRating_Last(rating, orderByComparator);
	}

	/**
	* Returns the movies before and after the current movie in the ordered set where rating = &#63;.
	*
	* @param movieId the primary key of the current movie
	* @param rating the rating
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public static Movie[] findByRating_PrevAndNext(long movieId, int rating,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence()
				   .findByRating_PrevAndNext(movieId, rating, orderByComparator);
	}

	/**
	* Removes all the movies where rating = &#63; from the database.
	*
	* @param rating the rating
	*/
	public static void removeByRating(int rating) {
		getPersistence().removeByRating(rating);
	}

	/**
	* Returns the number of movies where rating = &#63;.
	*
	* @param rating the rating
	* @return the number of matching movies
	*/
	public static int countByRating(int rating) {
		return getPersistence().countByRating(rating);
	}

	/**
	* Returns all the movies where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @return the matching movies
	*/
	public static List<Movie> findByG_G(long groupId, long movieId) {
		return getPersistence().findByG_G(groupId, movieId);
	}

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
	public static List<Movie> findByG_G(long groupId, long movieId, int start,
		int end) {
		return getPersistence().findByG_G(groupId, movieId, start, end);
	}

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
	public static List<Movie> findByG_G(long groupId, long movieId, int start,
		int end, OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .findByG_G(groupId, movieId, start, end, orderByComparator);
	}

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
	public static List<Movie> findByG_G(long groupId, long movieId, int start,
		int end, OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_G(groupId, movieId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first movie in the ordered set where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public static Movie findByG_G_First(long groupId, long movieId,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence()
				   .findByG_G_First(groupId, movieId, orderByComparator);
	}

	/**
	* Returns the first movie in the ordered set where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByG_G_First(long groupId, long movieId,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .fetchByG_G_First(groupId, movieId, orderByComparator);
	}

	/**
	* Returns the last movie in the ordered set where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie
	* @throws NoSuchMovieException if a matching movie could not be found
	*/
	public static Movie findByG_G_Last(long groupId, long movieId,
		OrderByComparator<Movie> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence()
				   .findByG_G_Last(groupId, movieId, orderByComparator);
	}

	/**
	* Returns the last movie in the ordered set where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching movie, or <code>null</code> if a matching movie could not be found
	*/
	public static Movie fetchByG_G_Last(long groupId, long movieId,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .fetchByG_G_Last(groupId, movieId, orderByComparator);
	}

	/**
	* Returns all the movies that the user has permission to view where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @return the matching movies that the user has permission to view
	*/
	public static List<Movie> filterFindByG_G(long groupId, long movieId) {
		return getPersistence().filterFindByG_G(groupId, movieId);
	}

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
	public static List<Movie> filterFindByG_G(long groupId, long movieId,
		int start, int end) {
		return getPersistence().filterFindByG_G(groupId, movieId, start, end);
	}

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
	public static List<Movie> filterFindByG_G(long groupId, long movieId,
		int start, int end, OrderByComparator<Movie> orderByComparator) {
		return getPersistence()
				   .filterFindByG_G(groupId, movieId, start, end,
			orderByComparator);
	}

	/**
	* Removes all the movies where groupId = &#63; and movieId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	*/
	public static void removeByG_G(long groupId, long movieId) {
		getPersistence().removeByG_G(groupId, movieId);
	}

	/**
	* Returns the number of movies where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @return the number of matching movies
	*/
	public static int countByG_G(long groupId, long movieId) {
		return getPersistence().countByG_G(groupId, movieId);
	}

	/**
	* Returns the number of movies that the user has permission to view where groupId = &#63; and movieId = &#63;.
	*
	* @param groupId the group ID
	* @param movieId the movie ID
	* @return the number of matching movies that the user has permission to view
	*/
	public static int filterCountByG_G(long groupId, long movieId) {
		return getPersistence().filterCountByG_G(groupId, movieId);
	}

	/**
	* Caches the movie in the entity cache if it is enabled.
	*
	* @param movie the movie
	*/
	public static void cacheResult(Movie movie) {
		getPersistence().cacheResult(movie);
	}

	/**
	* Caches the movies in the entity cache if it is enabled.
	*
	* @param movies the movies
	*/
	public static void cacheResult(List<Movie> movies) {
		getPersistence().cacheResult(movies);
	}

	/**
	* Creates a new movie with the primary key. Does not add the movie to the database.
	*
	* @param movieId the primary key for the new movie
	* @return the new movie
	*/
	public static Movie create(long movieId) {
		return getPersistence().create(movieId);
	}

	/**
	* Removes the movie with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param movieId the primary key of the movie
	* @return the movie that was removed
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public static Movie remove(long movieId)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence().remove(movieId);
	}

	public static Movie updateImpl(Movie movie) {
		return getPersistence().updateImpl(movie);
	}

	/**
	* Returns the movie with the primary key or throws a {@link NoSuchMovieException} if it could not be found.
	*
	* @param movieId the primary key of the movie
	* @return the movie
	* @throws NoSuchMovieException if a movie with the primary key could not be found
	*/
	public static Movie findByPrimaryKey(long movieId)
		throws com.liferay.training.movies.exception.NoSuchMovieException {
		return getPersistence().findByPrimaryKey(movieId);
	}

	/**
	* Returns the movie with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param movieId the primary key of the movie
	* @return the movie, or <code>null</code> if a movie with the primary key could not be found
	*/
	public static Movie fetchByPrimaryKey(long movieId) {
		return getPersistence().fetchByPrimaryKey(movieId);
	}

	public static java.util.Map<java.io.Serializable, Movie> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the movies.
	*
	* @return the movies
	*/
	public static List<Movie> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Movie> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Movie> findAll(int start, int end,
		OrderByComparator<Movie> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Movie> findAll(int start, int end,
		OrderByComparator<Movie> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the movies from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of movies.
	*
	* @return the number of movies
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static MoviePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MoviePersistence, MoviePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MoviePersistence.class);

		ServiceTracker<MoviePersistence, MoviePersistence> serviceTracker = new ServiceTracker<MoviePersistence, MoviePersistence>(bundle.getBundleContext(),
				MoviePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}