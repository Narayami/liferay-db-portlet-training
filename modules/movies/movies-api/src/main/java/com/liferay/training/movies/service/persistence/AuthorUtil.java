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

import com.liferay.training.movies.model.Author;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the author service. This utility wraps {@link com.liferay.training.movies.service.persistence.impl.AuthorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuthorPersistence
 * @see com.liferay.training.movies.service.persistence.impl.AuthorPersistenceImpl
 * @generated
 */
@ProviderType
public class AuthorUtil {
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
	public static void clearCache(Author author) {
		getPersistence().clearCache(author);
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
	public static List<Author> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Author> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Author> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Author> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Author update(Author author) {
		return getPersistence().update(author);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Author update(Author author, ServiceContext serviceContext) {
		return getPersistence().update(author, serviceContext);
	}

	/**
	* Returns all the authors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching authors
	*/
	public static List<Author> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the authors where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of matching authors
	*/
	public static List<Author> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the authors where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching authors
	*/
	public static List<Author> findByUuid(String uuid, int start, int end,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the authors where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching authors
	*/
	public static List<Author> findByUuid(String uuid, int start, int end,
		OrderByComparator<Author> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByUuid_First(String uuid,
		OrderByComparator<Author> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByUuid_First(String uuid,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByUuid_Last(String uuid,
		OrderByComparator<Author> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByUuid_Last(String uuid,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the authors before and after the current author in the ordered set where uuid = &#63;.
	*
	* @param authorId the primary key of the current author
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public static Author[] findByUuid_PrevAndNext(long authorId, String uuid,
		OrderByComparator<Author> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence()
				   .findByUuid_PrevAndNext(authorId, uuid, orderByComparator);
	}

	/**
	* Removes all the authors where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of authors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching authors
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the author where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchAuthorException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByUUID_G(String uuid, long groupId)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the author where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the author where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the author where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the author that was removed
	*/
	public static Author removeByUUID_G(String uuid, long groupId)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of authors where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching authors
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the authors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching authors
	*/
	public static List<Author> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the authors where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of matching authors
	*/
	public static List<Author> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the authors where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching authors
	*/
	public static List<Author> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Author> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the authors where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching authors
	*/
	public static List<Author> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Author> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Author> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Author> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the authors before and after the current author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param authorId the primary key of the current author
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public static Author[] findByUuid_C_PrevAndNext(long authorId, String uuid,
		long companyId, OrderByComparator<Author> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(authorId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the authors where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of authors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching authors
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the authors where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching authors
	*/
	public static List<Author> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the authors where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of matching authors
	*/
	public static List<Author> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the authors where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching authors
	*/
	public static List<Author> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the authors where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching authors
	*/
	public static List<Author> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Author> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByGroupId_First(long groupId,
		OrderByComparator<Author> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByGroupId_First(long groupId,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByGroupId_Last(long groupId,
		OrderByComparator<Author> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByGroupId_Last(long groupId,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the authors before and after the current author in the ordered set where groupId = &#63;.
	*
	* @param authorId the primary key of the current author
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public static Author[] findByGroupId_PrevAndNext(long authorId,
		long groupId, OrderByComparator<Author> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(authorId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the authors where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of authors where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching authors
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the authors where authorName = &#63;.
	*
	* @param authorName the author name
	* @return the matching authors
	*/
	public static List<Author> findByAuthorName(String authorName) {
		return getPersistence().findByAuthorName(authorName);
	}

	/**
	* Returns a range of all the authors where authorName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorName the author name
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of matching authors
	*/
	public static List<Author> findByAuthorName(String authorName, int start,
		int end) {
		return getPersistence().findByAuthorName(authorName, start, end);
	}

	/**
	* Returns an ordered range of all the authors where authorName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorName the author name
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching authors
	*/
	public static List<Author> findByAuthorName(String authorName, int start,
		int end, OrderByComparator<Author> orderByComparator) {
		return getPersistence()
				   .findByAuthorName(authorName, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the authors where authorName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorName the author name
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching authors
	*/
	public static List<Author> findByAuthorName(String authorName, int start,
		int end, OrderByComparator<Author> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByAuthorName(authorName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first author in the ordered set where authorName = &#63;.
	*
	* @param authorName the author name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByAuthorName_First(String authorName,
		OrderByComparator<Author> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence()
				   .findByAuthorName_First(authorName, orderByComparator);
	}

	/**
	* Returns the first author in the ordered set where authorName = &#63;.
	*
	* @param authorName the author name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByAuthorName_First(String authorName,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence()
				   .fetchByAuthorName_First(authorName, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where authorName = &#63;.
	*
	* @param authorName the author name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByAuthorName_Last(String authorName,
		OrderByComparator<Author> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence()
				   .findByAuthorName_Last(authorName, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where authorName = &#63;.
	*
	* @param authorName the author name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByAuthorName_Last(String authorName,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence()
				   .fetchByAuthorName_Last(authorName, orderByComparator);
	}

	/**
	* Returns the authors before and after the current author in the ordered set where authorName = &#63;.
	*
	* @param authorId the primary key of the current author
	* @param authorName the author name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public static Author[] findByAuthorName_PrevAndNext(long authorId,
		String authorName, OrderByComparator<Author> orderByComparator)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence()
				   .findByAuthorName_PrevAndNext(authorId, authorName,
			orderByComparator);
	}

	/**
	* Removes all the authors where authorName = &#63; from the database.
	*
	* @param authorName the author name
	*/
	public static void removeByAuthorName(String authorName) {
		getPersistence().removeByAuthorName(authorName);
	}

	/**
	* Returns the number of authors where authorName = &#63;.
	*
	* @param authorName the author name
	* @return the number of matching authors
	*/
	public static int countByAuthorName(String authorName) {
		return getPersistence().countByAuthorName(authorName);
	}

	/**
	* Returns the author where movieId = &#63; and authorId = &#63; or throws a {@link NoSuchAuthorException} if it could not be found.
	*
	* @param movieId the movie ID
	* @param authorId the author ID
	* @return the matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByMovieIdAuthorId(long movieId, long authorId)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence().findByMovieIdAuthorId(movieId, authorId);
	}

	/**
	* Returns the author where movieId = &#63; and authorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param movieId the movie ID
	* @param authorId the author ID
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByMovieIdAuthorId(long movieId, long authorId) {
		return getPersistence().fetchByMovieIdAuthorId(movieId, authorId);
	}

	/**
	* Returns the author where movieId = &#63; and authorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param movieId the movie ID
	* @param authorId the author ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByMovieIdAuthorId(long movieId, long authorId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByMovieIdAuthorId(movieId, authorId, retrieveFromCache);
	}

	/**
	* Removes the author where movieId = &#63; and authorId = &#63; from the database.
	*
	* @param movieId the movie ID
	* @param authorId the author ID
	* @return the author that was removed
	*/
	public static Author removeByMovieIdAuthorId(long movieId, long authorId)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence().removeByMovieIdAuthorId(movieId, authorId);
	}

	/**
	* Returns the number of authors where movieId = &#63; and authorId = &#63;.
	*
	* @param movieId the movie ID
	* @param authorId the author ID
	* @return the number of matching authors
	*/
	public static int countByMovieIdAuthorId(long movieId, long authorId) {
		return getPersistence().countByMovieIdAuthorId(movieId, authorId);
	}

	/**
	* Returns the author where movieId = &#63; or throws a {@link NoSuchAuthorException} if it could not be found.
	*
	* @param movieId the movie ID
	* @return the matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public static Author findByAuthorByMovieId(long movieId)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence().findByAuthorByMovieId(movieId);
	}

	/**
	* Returns the author where movieId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param movieId the movie ID
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByAuthorByMovieId(long movieId) {
		return getPersistence().fetchByAuthorByMovieId(movieId);
	}

	/**
	* Returns the author where movieId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param movieId the movie ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public static Author fetchByAuthorByMovieId(long movieId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByAuthorByMovieId(movieId, retrieveFromCache);
	}

	/**
	* Removes the author where movieId = &#63; from the database.
	*
	* @param movieId the movie ID
	* @return the author that was removed
	*/
	public static Author removeByAuthorByMovieId(long movieId)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence().removeByAuthorByMovieId(movieId);
	}

	/**
	* Returns the number of authors where movieId = &#63;.
	*
	* @param movieId the movie ID
	* @return the number of matching authors
	*/
	public static int countByAuthorByMovieId(long movieId) {
		return getPersistence().countByAuthorByMovieId(movieId);
	}

	/**
	* Caches the author in the entity cache if it is enabled.
	*
	* @param author the author
	*/
	public static void cacheResult(Author author) {
		getPersistence().cacheResult(author);
	}

	/**
	* Caches the authors in the entity cache if it is enabled.
	*
	* @param authors the authors
	*/
	public static void cacheResult(List<Author> authors) {
		getPersistence().cacheResult(authors);
	}

	/**
	* Creates a new author with the primary key. Does not add the author to the database.
	*
	* @param authorId the primary key for the new author
	* @return the new author
	*/
	public static Author create(long authorId) {
		return getPersistence().create(authorId);
	}

	/**
	* Removes the author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorId the primary key of the author
	* @return the author that was removed
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public static Author remove(long authorId)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence().remove(authorId);
	}

	public static Author updateImpl(Author author) {
		return getPersistence().updateImpl(author);
	}

	/**
	* Returns the author with the primary key or throws a {@link NoSuchAuthorException} if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public static Author findByPrimaryKey(long authorId)
		throws com.liferay.training.movies.exception.NoSuchAuthorException {
		return getPersistence().findByPrimaryKey(authorId);
	}

	/**
	* Returns the author with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author, or <code>null</code> if a author with the primary key could not be found
	*/
	public static Author fetchByPrimaryKey(long authorId) {
		return getPersistence().fetchByPrimaryKey(authorId);
	}

	public static java.util.Map<java.io.Serializable, Author> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the authors.
	*
	* @return the authors
	*/
	public static List<Author> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of authors
	*/
	public static List<Author> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of authors
	*/
	public static List<Author> findAll(int start, int end,
		OrderByComparator<Author> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of authors
	*/
	public static List<Author> findAll(int start, int end,
		OrderByComparator<Author> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the authors from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of authors.
	*
	* @return the number of authors
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AuthorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AuthorPersistence, AuthorPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AuthorPersistence.class);

		ServiceTracker<AuthorPersistence, AuthorPersistence> serviceTracker = new ServiceTracker<AuthorPersistence, AuthorPersistence>(bundle.getBundleContext(),
				AuthorPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}