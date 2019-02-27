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

import com.liferay.training.movies.exception.NoSuchAuthorException;
import com.liferay.training.movies.model.Author;

/**
 * The persistence interface for the author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.movies.service.persistence.impl.AuthorPersistenceImpl
 * @see AuthorUtil
 * @generated
 */
@ProviderType
public interface AuthorPersistence extends BasePersistence<Author> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuthorUtil} to access the author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the authors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching authors
	*/
	public java.util.List<Author> findByUuid(String uuid);

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
	public java.util.List<Author> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Author> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

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
	public java.util.List<Author> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Returns the first author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

	/**
	* Returns the last author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Returns the last author in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

	/**
	* Returns the authors before and after the current author in the ordered set where uuid = &#63;.
	*
	* @param authorId the primary key of the current author
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public Author[] findByUuid_PrevAndNext(long authorId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Removes all the authors where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of authors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching authors
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the author where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchAuthorException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByUUID_G(String uuid, long groupId)
		throws NoSuchAuthorException;

	/**
	* Returns the author where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the author where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the author where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the author that was removed
	*/
	public Author removeByUUID_G(String uuid, long groupId)
		throws NoSuchAuthorException;

	/**
	* Returns the number of authors where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching authors
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the authors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching authors
	*/
	public java.util.List<Author> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Author> findByUuid_C(String uuid, long companyId,
		int start, int end);

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
	public java.util.List<Author> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

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
	public java.util.List<Author> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Returns the first author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

	/**
	* Returns the last author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Returns the last author in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

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
	public Author[] findByUuid_C_PrevAndNext(long authorId, String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Removes all the authors where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of authors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching authors
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Returns all the authors where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching authors
	*/
	public java.util.List<Author> findByGroupId(long groupId);

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
	public java.util.List<Author> findByGroupId(long groupId, int start, int end);

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
	public java.util.List<Author> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

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
	public java.util.List<Author> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Returns the first author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

	/**
	* Returns the last author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Returns the last author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

	/**
	* Returns the authors before and after the current author in the ordered set where groupId = &#63;.
	*
	* @param authorId the primary key of the current author
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public Author[] findByGroupId_PrevAndNext(long authorId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Removes all the authors where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of authors where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching authors
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the authors where authorName = &#63;.
	*
	* @param authorName the author name
	* @return the matching authors
	*/
	public java.util.List<Author> findByAuthorName(String authorName);

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
	public java.util.List<Author> findByAuthorName(String authorName,
		int start, int end);

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
	public java.util.List<Author> findByAuthorName(String authorName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

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
	public java.util.List<Author> findByAuthorName(String authorName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first author in the ordered set where authorName = &#63;.
	*
	* @param authorName the author name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByAuthorName_First(String authorName,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Returns the first author in the ordered set where authorName = &#63;.
	*
	* @param authorName the author name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByAuthorName_First(String authorName,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

	/**
	* Returns the last author in the ordered set where authorName = &#63;.
	*
	* @param authorName the author name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByAuthorName_Last(String authorName,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Returns the last author in the ordered set where authorName = &#63;.
	*
	* @param authorName the author name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByAuthorName_Last(String authorName,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

	/**
	* Returns the authors before and after the current author in the ordered set where authorName = &#63;.
	*
	* @param authorId the primary key of the current author
	* @param authorName the author name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public Author[] findByAuthorName_PrevAndNext(long authorId,
		String authorName,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException;

	/**
	* Removes all the authors where authorName = &#63; from the database.
	*
	* @param authorName the author name
	*/
	public void removeByAuthorName(String authorName);

	/**
	* Returns the number of authors where authorName = &#63;.
	*
	* @param authorName the author name
	* @return the number of matching authors
	*/
	public int countByAuthorName(String authorName);

	/**
	* Returns the author where movieId = &#63; and authorId = &#63; or throws a {@link NoSuchAuthorException} if it could not be found.
	*
	* @param movieId the movie ID
	* @param authorId the author ID
	* @return the matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByMovieIdAuthorId(long movieId, long authorId)
		throws NoSuchAuthorException;

	/**
	* Returns the author where movieId = &#63; and authorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param movieId the movie ID
	* @param authorId the author ID
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByMovieIdAuthorId(long movieId, long authorId);

	/**
	* Returns the author where movieId = &#63; and authorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param movieId the movie ID
	* @param authorId the author ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByMovieIdAuthorId(long movieId, long authorId,
		boolean retrieveFromCache);

	/**
	* Removes the author where movieId = &#63; and authorId = &#63; from the database.
	*
	* @param movieId the movie ID
	* @param authorId the author ID
	* @return the author that was removed
	*/
	public Author removeByMovieIdAuthorId(long movieId, long authorId)
		throws NoSuchAuthorException;

	/**
	* Returns the number of authors where movieId = &#63; and authorId = &#63;.
	*
	* @param movieId the movie ID
	* @param authorId the author ID
	* @return the number of matching authors
	*/
	public int countByMovieIdAuthorId(long movieId, long authorId);

	/**
	* Returns the author where movieId = &#63; or throws a {@link NoSuchAuthorException} if it could not be found.
	*
	* @param movieId the movie ID
	* @return the matching author
	* @throws NoSuchAuthorException if a matching author could not be found
	*/
	public Author findByAuthorByMovieId(long movieId)
		throws NoSuchAuthorException;

	/**
	* Returns the author where movieId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param movieId the movie ID
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByAuthorByMovieId(long movieId);

	/**
	* Returns the author where movieId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param movieId the movie ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching author, or <code>null</code> if a matching author could not be found
	*/
	public Author fetchByAuthorByMovieId(long movieId, boolean retrieveFromCache);

	/**
	* Removes the author where movieId = &#63; from the database.
	*
	* @param movieId the movie ID
	* @return the author that was removed
	*/
	public Author removeByAuthorByMovieId(long movieId)
		throws NoSuchAuthorException;

	/**
	* Returns the number of authors where movieId = &#63;.
	*
	* @param movieId the movie ID
	* @return the number of matching authors
	*/
	public int countByAuthorByMovieId(long movieId);

	/**
	* Caches the author in the entity cache if it is enabled.
	*
	* @param author the author
	*/
	public void cacheResult(Author author);

	/**
	* Caches the authors in the entity cache if it is enabled.
	*
	* @param authors the authors
	*/
	public void cacheResult(java.util.List<Author> authors);

	/**
	* Creates a new author with the primary key. Does not add the author to the database.
	*
	* @param authorId the primary key for the new author
	* @return the new author
	*/
	public Author create(long authorId);

	/**
	* Removes the author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorId the primary key of the author
	* @return the author that was removed
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public Author remove(long authorId) throws NoSuchAuthorException;

	public Author updateImpl(Author author);

	/**
	* Returns the author with the primary key or throws a {@link NoSuchAuthorException} if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author
	* @throws NoSuchAuthorException if a author with the primary key could not be found
	*/
	public Author findByPrimaryKey(long authorId) throws NoSuchAuthorException;

	/**
	* Returns the author with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author, or <code>null</code> if a author with the primary key could not be found
	*/
	public Author fetchByPrimaryKey(long authorId);

	@Override
	public java.util.Map<java.io.Serializable, Author> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the authors.
	*
	* @return the authors
	*/
	public java.util.List<Author> findAll();

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
	public java.util.List<Author> findAll(int start, int end);

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
	public java.util.List<Author> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator);

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
	public java.util.List<Author> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Author> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the authors from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of authors.
	*
	* @return the number of authors
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}