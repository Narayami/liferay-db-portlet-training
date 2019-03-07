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

package com.liferay.training.movies.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.training.movies.exception.NoSuchMovieException;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.model.impl.MovieImpl;
import com.liferay.training.movies.model.impl.MovieModelImpl;
import com.liferay.training.movies.service.persistence.MoviePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the movie service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MoviePersistence
 * @see com.liferay.training.movies.service.persistence.MovieUtil
 * @generated
 */
@ProviderType
public class MoviePersistenceImpl extends BasePersistenceImpl<Movie>
	implements MoviePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MovieUtil} to access the movie persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MovieImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			MovieModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the movies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching movies
	 */
	@Override
	public List<Movie> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Movie> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Movie> findByUuid(String uuid, int start, int end,
		OrderByComparator<Movie> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Movie> findByUuid(String uuid, int start, int end,
		OrderByComparator<Movie> orderByComparator, boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Movie> list = null;

		if (retrieveFromCache) {
			list = (List<Movie>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Movie movie : list) {
					if (!uuid.equals(movie.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MOVIE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MovieModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first movie in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movie
	 * @throws NoSuchMovieException if a matching movie could not be found
	 */
	@Override
	public Movie findByUuid_First(String uuid,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = fetchByUuid_First(uuid, orderByComparator);

		if (movie != null) {
			return movie;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchMovieException(msg.toString());
	}

	/**
	 * Returns the first movie in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByUuid_First(String uuid,
		OrderByComparator<Movie> orderByComparator) {
		List<Movie> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last movie in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movie
	 * @throws NoSuchMovieException if a matching movie could not be found
	 */
	@Override
	public Movie findByUuid_Last(String uuid,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = fetchByUuid_Last(uuid, orderByComparator);

		if (movie != null) {
			return movie;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchMovieException(msg.toString());
	}

	/**
	 * Returns the last movie in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByUuid_Last(String uuid,
		OrderByComparator<Movie> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Movie> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Movie[] findByUuid_PrevAndNext(long movieId, String uuid,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		uuid = Objects.toString(uuid, "");

		Movie movie = findByPrimaryKey(movieId);

		Session session = null;

		try {
			session = openSession();

			Movie[] array = new MovieImpl[3];

			array[0] = getByUuid_PrevAndNext(session, movie, uuid,
					orderByComparator, true);

			array[1] = movie;

			array[2] = getByUuid_PrevAndNext(session, movie, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Movie getByUuid_PrevAndNext(Session session, Movie movie,
		String uuid, OrderByComparator<Movie> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MOVIE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MovieModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(movie);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Movie> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the movies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Movie movie : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(movie);
		}
	}

	/**
	 * Returns the number of movies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching movies
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MOVIE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "movie.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "movie.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(movie.uuid IS NULL OR movie.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			MovieModelImpl.UUID_COLUMN_BITMASK |
			MovieModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the movie where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchMovieException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching movie
	 * @throws NoSuchMovieException if a matching movie could not be found
	 */
	@Override
	public Movie findByUUID_G(String uuid, long groupId)
		throws NoSuchMovieException {
		Movie movie = fetchByUUID_G(uuid, groupId);

		if (movie == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchMovieException(msg.toString());
		}

		return movie;
	}

	/**
	 * Returns the movie where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the movie where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Movie) {
			Movie movie = (Movie)result;

			if (!Objects.equals(uuid, movie.getUuid()) ||
					(groupId != movie.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MOVIE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Movie> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Movie movie = list.get(0);

					result = movie;

					cacheResult(movie);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Movie)result;
		}
	}

	/**
	 * Removes the movie where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the movie that was removed
	 */
	@Override
	public Movie removeByUUID_G(String uuid, long groupId)
		throws NoSuchMovieException {
		Movie movie = findByUUID_G(uuid, groupId);

		return remove(movie);
	}

	/**
	 * Returns the number of movies where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching movies
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MOVIE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "movie.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "movie.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(movie.uuid IS NULL OR movie.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "movie.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			MovieModelImpl.UUID_COLUMN_BITMASK |
			MovieModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the movies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching movies
	 */
	@Override
	public List<Movie> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Movie> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Movie> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Movie> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Movie> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Movie> list = null;

		if (retrieveFromCache) {
			list = (List<Movie>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Movie movie : list) {
					if (!uuid.equals(movie.getUuid()) ||
							(companyId != movie.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_MOVIE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MovieModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Movie findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (movie != null) {
			return movie;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchMovieException(msg.toString());
	}

	/**
	 * Returns the first movie in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Movie> orderByComparator) {
		List<Movie> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Movie findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (movie != null) {
			return movie;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchMovieException(msg.toString());
	}

	/**
	 * Returns the last movie in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Movie> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Movie> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Movie[] findByUuid_C_PrevAndNext(long movieId, String uuid,
		long companyId, OrderByComparator<Movie> orderByComparator)
		throws NoSuchMovieException {
		uuid = Objects.toString(uuid, "");

		Movie movie = findByPrimaryKey(movieId);

		Session session = null;

		try {
			session = openSession();

			Movie[] array = new MovieImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, movie, uuid, companyId,
					orderByComparator, true);

			array[1] = movie;

			array[2] = getByUuid_C_PrevAndNext(session, movie, uuid, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Movie getByUuid_C_PrevAndNext(Session session, Movie movie,
		String uuid, long companyId,
		OrderByComparator<Movie> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_MOVIE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MovieModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(movie);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Movie> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the movies where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Movie movie : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(movie);
		}
	}

	/**
	 * Returns the number of movies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching movies
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MOVIE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "movie.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "movie.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(movie.uuid IS NULL OR movie.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "movie.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			MovieModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the movies where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching movies
	 */
	@Override
	public List<Movie> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Movie> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Movie> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Movie> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Movie> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Movie> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Movie> list = null;

		if (retrieveFromCache) {
			list = (List<Movie>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Movie movie : list) {
					if ((groupId != movie.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MOVIE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MovieModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first movie in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movie
	 * @throws NoSuchMovieException if a matching movie could not be found
	 */
	@Override
	public Movie findByGroupId_First(long groupId,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = fetchByGroupId_First(groupId, orderByComparator);

		if (movie != null) {
			return movie;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchMovieException(msg.toString());
	}

	/**
	 * Returns the first movie in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByGroupId_First(long groupId,
		OrderByComparator<Movie> orderByComparator) {
		List<Movie> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last movie in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movie
	 * @throws NoSuchMovieException if a matching movie could not be found
	 */
	@Override
	public Movie findByGroupId_Last(long groupId,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = fetchByGroupId_Last(groupId, orderByComparator);

		if (movie != null) {
			return movie;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchMovieException(msg.toString());
	}

	/**
	 * Returns the last movie in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByGroupId_Last(long groupId,
		OrderByComparator<Movie> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Movie> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Movie[] findByGroupId_PrevAndNext(long movieId, long groupId,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = findByPrimaryKey(movieId);

		Session session = null;

		try {
			session = openSession();

			Movie[] array = new MovieImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, movie, groupId,
					orderByComparator, true);

			array[1] = movie;

			array[2] = getByGroupId_PrevAndNext(session, movie, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Movie getByGroupId_PrevAndNext(Session session, Movie movie,
		long groupId, OrderByComparator<Movie> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MOVIE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MovieModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(movie);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Movie> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the movies that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching movies that the user has permission to view
	 */
	@Override
	public List<Movie> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Movie> filterFindByGroupId(long groupId, int start, int end) {
		return filterFindByGroupId(groupId, start, end, null);
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
	@Override
	public List<Movie> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator<Movie> orderByComparator) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_MOVIE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_MOVIE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_MOVIE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(MovieModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(MovieModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Movie.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, MovieImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, MovieImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Movie>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public Movie[] filterFindByGroupId_PrevAndNext(long movieId, long groupId,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(movieId, groupId, orderByComparator);
		}

		Movie movie = findByPrimaryKey(movieId);

		Session session = null;

		try {
			session = openSession();

			Movie[] array = new MovieImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, movie, groupId,
					orderByComparator, true);

			array[1] = movie;

			array[2] = filterGetByGroupId_PrevAndNext(session, movie, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Movie filterGetByGroupId_PrevAndNext(Session session,
		Movie movie, long groupId, OrderByComparator<Movie> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_MOVIE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_MOVIE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_MOVIE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(MovieModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(MovieModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Movie.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, MovieImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, MovieImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(movie);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Movie> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the movies where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Movie movie : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(movie);
		}
	}

	/**
	 * Returns the number of movies where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching movies
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MOVIE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of movies that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching movies that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_MOVIE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Movie.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "movie.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MOVIENAME =
		new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMovieName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MOVIENAME =
		new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMovieName",
			new String[] { String.class.getName() },
			MovieModelImpl.MOVIENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MOVIENAME = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMovieName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the movies where movieName = &#63;.
	 *
	 * @param movieName the movie name
	 * @return the matching movies
	 */
	@Override
	public List<Movie> findByMovieName(String movieName) {
		return findByMovieName(movieName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Movie> findByMovieName(String movieName, int start, int end) {
		return findByMovieName(movieName, start, end, null);
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
	@Override
	public List<Movie> findByMovieName(String movieName, int start, int end,
		OrderByComparator<Movie> orderByComparator) {
		return findByMovieName(movieName, start, end, orderByComparator, true);
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
	@Override
	public List<Movie> findByMovieName(String movieName, int start, int end,
		OrderByComparator<Movie> orderByComparator, boolean retrieveFromCache) {
		movieName = Objects.toString(movieName, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MOVIENAME;
			finderArgs = new Object[] { movieName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MOVIENAME;
			finderArgs = new Object[] { movieName, start, end, orderByComparator };
		}

		List<Movie> list = null;

		if (retrieveFromCache) {
			list = (List<Movie>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Movie movie : list) {
					if (!movieName.equals(movie.getMovieName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MOVIE_WHERE);

			boolean bindMovieName = false;

			if (movieName.isEmpty()) {
				query.append(_FINDER_COLUMN_MOVIENAME_MOVIENAME_3);
			}
			else {
				bindMovieName = true;

				query.append(_FINDER_COLUMN_MOVIENAME_MOVIENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MovieModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMovieName) {
					qPos.add(movieName);
				}

				if (!pagination) {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first movie in the ordered set where movieName = &#63;.
	 *
	 * @param movieName the movie name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movie
	 * @throws NoSuchMovieException if a matching movie could not be found
	 */
	@Override
	public Movie findByMovieName_First(String movieName,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = fetchByMovieName_First(movieName, orderByComparator);

		if (movie != null) {
			return movie;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("movieName=");
		msg.append(movieName);

		msg.append("}");

		throw new NoSuchMovieException(msg.toString());
	}

	/**
	 * Returns the first movie in the ordered set where movieName = &#63;.
	 *
	 * @param movieName the movie name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByMovieName_First(String movieName,
		OrderByComparator<Movie> orderByComparator) {
		List<Movie> list = findByMovieName(movieName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last movie in the ordered set where movieName = &#63;.
	 *
	 * @param movieName the movie name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movie
	 * @throws NoSuchMovieException if a matching movie could not be found
	 */
	@Override
	public Movie findByMovieName_Last(String movieName,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = fetchByMovieName_Last(movieName, orderByComparator);

		if (movie != null) {
			return movie;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("movieName=");
		msg.append(movieName);

		msg.append("}");

		throw new NoSuchMovieException(msg.toString());
	}

	/**
	 * Returns the last movie in the ordered set where movieName = &#63;.
	 *
	 * @param movieName the movie name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByMovieName_Last(String movieName,
		OrderByComparator<Movie> orderByComparator) {
		int count = countByMovieName(movieName);

		if (count == 0) {
			return null;
		}

		List<Movie> list = findByMovieName(movieName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Movie[] findByMovieName_PrevAndNext(long movieId, String movieName,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		movieName = Objects.toString(movieName, "");

		Movie movie = findByPrimaryKey(movieId);

		Session session = null;

		try {
			session = openSession();

			Movie[] array = new MovieImpl[3];

			array[0] = getByMovieName_PrevAndNext(session, movie, movieName,
					orderByComparator, true);

			array[1] = movie;

			array[2] = getByMovieName_PrevAndNext(session, movie, movieName,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Movie getByMovieName_PrevAndNext(Session session, Movie movie,
		String movieName, OrderByComparator<Movie> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MOVIE_WHERE);

		boolean bindMovieName = false;

		if (movieName.isEmpty()) {
			query.append(_FINDER_COLUMN_MOVIENAME_MOVIENAME_3);
		}
		else {
			bindMovieName = true;

			query.append(_FINDER_COLUMN_MOVIENAME_MOVIENAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MovieModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindMovieName) {
			qPos.add(movieName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(movie);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Movie> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the movies where movieName = &#63; from the database.
	 *
	 * @param movieName the movie name
	 */
	@Override
	public void removeByMovieName(String movieName) {
		for (Movie movie : findByMovieName(movieName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(movie);
		}
	}

	/**
	 * Returns the number of movies where movieName = &#63;.
	 *
	 * @param movieName the movie name
	 * @return the number of matching movies
	 */
	@Override
	public int countByMovieName(String movieName) {
		movieName = Objects.toString(movieName, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_MOVIENAME;

		Object[] finderArgs = new Object[] { movieName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MOVIE_WHERE);

			boolean bindMovieName = false;

			if (movieName.isEmpty()) {
				query.append(_FINDER_COLUMN_MOVIENAME_MOVIENAME_3);
			}
			else {
				bindMovieName = true;

				query.append(_FINDER_COLUMN_MOVIENAME_MOVIENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMovieName) {
					qPos.add(movieName);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MOVIENAME_MOVIENAME_1 = "movie.movieName IS NULL";
	private static final String _FINDER_COLUMN_MOVIENAME_MOVIENAME_2 = "movie.movieName = ?";
	private static final String _FINDER_COLUMN_MOVIENAME_MOVIENAME_3 = "(movie.movieName IS NULL OR movie.movieName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RATING = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRating",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATING =
		new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRating",
			new String[] { Integer.class.getName() },
			MovieModelImpl.RATING_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RATING = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRating",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the movies where rating = &#63;.
	 *
	 * @param rating the rating
	 * @return the matching movies
	 */
	@Override
	public List<Movie> findByRating(int rating) {
		return findByRating(rating, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Movie> findByRating(int rating, int start, int end) {
		return findByRating(rating, start, end, null);
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
	@Override
	public List<Movie> findByRating(int rating, int start, int end,
		OrderByComparator<Movie> orderByComparator) {
		return findByRating(rating, start, end, orderByComparator, true);
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
	@Override
	public List<Movie> findByRating(int rating, int start, int end,
		OrderByComparator<Movie> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATING;
			finderArgs = new Object[] { rating };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RATING;
			finderArgs = new Object[] { rating, start, end, orderByComparator };
		}

		List<Movie> list = null;

		if (retrieveFromCache) {
			list = (List<Movie>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Movie movie : list) {
					if ((rating != movie.getRating())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MOVIE_WHERE);

			query.append(_FINDER_COLUMN_RATING_RATING_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MovieModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rating);

				if (!pagination) {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first movie in the ordered set where rating = &#63;.
	 *
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movie
	 * @throws NoSuchMovieException if a matching movie could not be found
	 */
	@Override
	public Movie findByRating_First(int rating,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = fetchByRating_First(rating, orderByComparator);

		if (movie != null) {
			return movie;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rating=");
		msg.append(rating);

		msg.append("}");

		throw new NoSuchMovieException(msg.toString());
	}

	/**
	 * Returns the first movie in the ordered set where rating = &#63;.
	 *
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByRating_First(int rating,
		OrderByComparator<Movie> orderByComparator) {
		List<Movie> list = findByRating(rating, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last movie in the ordered set where rating = &#63;.
	 *
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movie
	 * @throws NoSuchMovieException if a matching movie could not be found
	 */
	@Override
	public Movie findByRating_Last(int rating,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = fetchByRating_Last(rating, orderByComparator);

		if (movie != null) {
			return movie;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rating=");
		msg.append(rating);

		msg.append("}");

		throw new NoSuchMovieException(msg.toString());
	}

	/**
	 * Returns the last movie in the ordered set where rating = &#63;.
	 *
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByRating_Last(int rating,
		OrderByComparator<Movie> orderByComparator) {
		int count = countByRating(rating);

		if (count == 0) {
			return null;
		}

		List<Movie> list = findByRating(rating, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Movie[] findByRating_PrevAndNext(long movieId, int rating,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = findByPrimaryKey(movieId);

		Session session = null;

		try {
			session = openSession();

			Movie[] array = new MovieImpl[3];

			array[0] = getByRating_PrevAndNext(session, movie, rating,
					orderByComparator, true);

			array[1] = movie;

			array[2] = getByRating_PrevAndNext(session, movie, rating,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Movie getByRating_PrevAndNext(Session session, Movie movie,
		int rating, OrderByComparator<Movie> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MOVIE_WHERE);

		query.append(_FINDER_COLUMN_RATING_RATING_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MovieModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rating);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(movie);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Movie> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the movies where rating = &#63; from the database.
	 *
	 * @param rating the rating
	 */
	@Override
	public void removeByRating(int rating) {
		for (Movie movie : findByRating(rating, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(movie);
		}
	}

	/**
	 * Returns the number of movies where rating = &#63;.
	 *
	 * @param rating the rating
	 * @return the number of matching movies
	 */
	@Override
	public int countByRating(int rating) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RATING;

		Object[] finderArgs = new Object[] { rating };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MOVIE_WHERE);

			query.append(_FINDER_COLUMN_RATING_RATING_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rating);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_RATING_RATING_2 = "movie.rating = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_G = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_G = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, MovieImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			MovieModelImpl.GROUPID_COLUMN_BITMASK |
			MovieModelImpl.MOVIEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_G = new FinderPath(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the movies where groupId = &#63; and movieId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param movieId the movie ID
	 * @return the matching movies
	 */
	@Override
	public List<Movie> findByG_G(long groupId, long movieId) {
		return findByG_G(groupId, movieId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Movie> findByG_G(long groupId, long movieId, int start, int end) {
		return findByG_G(groupId, movieId, start, end, null);
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
	@Override
	public List<Movie> findByG_G(long groupId, long movieId, int start,
		int end, OrderByComparator<Movie> orderByComparator) {
		return findByG_G(groupId, movieId, start, end, orderByComparator, true);
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
	@Override
	public List<Movie> findByG_G(long groupId, long movieId, int start,
		int end, OrderByComparator<Movie> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_G;
			finderArgs = new Object[] { groupId, movieId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_G;
			finderArgs = new Object[] {
					groupId, movieId,
					
					start, end, orderByComparator
				};
		}

		List<Movie> list = null;

		if (retrieveFromCache) {
			list = (List<Movie>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Movie movie : list) {
					if ((groupId != movie.getGroupId()) ||
							(movieId != movie.getMovieId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_MOVIE_WHERE);

			query.append(_FINDER_COLUMN_G_G_GROUPID_2);

			query.append(_FINDER_COLUMN_G_G_MOVIEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MovieModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(movieId);

				if (!pagination) {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Movie findByG_G_First(long groupId, long movieId,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = fetchByG_G_First(groupId, movieId, orderByComparator);

		if (movie != null) {
			return movie;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", movieId=");
		msg.append(movieId);

		msg.append("}");

		throw new NoSuchMovieException(msg.toString());
	}

	/**
	 * Returns the first movie in the ordered set where groupId = &#63; and movieId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param movieId the movie ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByG_G_First(long groupId, long movieId,
		OrderByComparator<Movie> orderByComparator) {
		List<Movie> list = findByG_G(groupId, movieId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Movie findByG_G_Last(long groupId, long movieId,
		OrderByComparator<Movie> orderByComparator) throws NoSuchMovieException {
		Movie movie = fetchByG_G_Last(groupId, movieId, orderByComparator);

		if (movie != null) {
			return movie;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", movieId=");
		msg.append(movieId);

		msg.append("}");

		throw new NoSuchMovieException(msg.toString());
	}

	/**
	 * Returns the last movie in the ordered set where groupId = &#63; and movieId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param movieId the movie ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching movie, or <code>null</code> if a matching movie could not be found
	 */
	@Override
	public Movie fetchByG_G_Last(long groupId, long movieId,
		OrderByComparator<Movie> orderByComparator) {
		int count = countByG_G(groupId, movieId);

		if (count == 0) {
			return null;
		}

		List<Movie> list = findByG_G(groupId, movieId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns all the movies that the user has permission to view where groupId = &#63; and movieId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param movieId the movie ID
	 * @return the matching movies that the user has permission to view
	 */
	@Override
	public List<Movie> filterFindByG_G(long groupId, long movieId) {
		return filterFindByG_G(groupId, movieId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Movie> filterFindByG_G(long groupId, long movieId, int start,
		int end) {
		return filterFindByG_G(groupId, movieId, start, end, null);
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
	@Override
	public List<Movie> filterFindByG_G(long groupId, long movieId, int start,
		int end, OrderByComparator<Movie> orderByComparator) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_G(groupId, movieId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_MOVIE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_MOVIE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_G_GROUPID_2);

		query.append(_FINDER_COLUMN_G_G_MOVIEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_MOVIE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(MovieModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(MovieModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Movie.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, MovieImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, MovieImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(movieId);

			return (List<Movie>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Removes all the movies where groupId = &#63; and movieId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param movieId the movie ID
	 */
	@Override
	public void removeByG_G(long groupId, long movieId) {
		for (Movie movie : findByG_G(groupId, movieId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(movie);
		}
	}

	/**
	 * Returns the number of movies where groupId = &#63; and movieId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param movieId the movie ID
	 * @return the number of matching movies
	 */
	@Override
	public int countByG_G(long groupId, long movieId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_G;

		Object[] finderArgs = new Object[] { groupId, movieId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MOVIE_WHERE);

			query.append(_FINDER_COLUMN_G_G_GROUPID_2);

			query.append(_FINDER_COLUMN_G_G_MOVIEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(movieId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of movies that the user has permission to view where groupId = &#63; and movieId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param movieId the movie ID
	 * @return the number of matching movies that the user has permission to view
	 */
	@Override
	public int filterCountByG_G(long groupId, long movieId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_G(groupId, movieId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_MOVIE_WHERE);

		query.append(_FINDER_COLUMN_G_G_GROUPID_2);

		query.append(_FINDER_COLUMN_G_G_MOVIEID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Movie.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(movieId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_G_GROUPID_2 = "movie.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_G_MOVIEID_2 = "movie.movieId = ?";

	public MoviePersistenceImpl() {
		setModelClass(Movie.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the movie in the entity cache if it is enabled.
	 *
	 * @param movie the movie
	 */
	@Override
	public void cacheResult(Movie movie) {
		entityCache.putResult(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieImpl.class, movie.getPrimaryKey(), movie);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { movie.getUuid(), movie.getGroupId() }, movie);

		movie.resetOriginalValues();
	}

	/**
	 * Caches the movies in the entity cache if it is enabled.
	 *
	 * @param movies the movies
	 */
	@Override
	public void cacheResult(List<Movie> movies) {
		for (Movie movie : movies) {
			if (entityCache.getResult(MovieModelImpl.ENTITY_CACHE_ENABLED,
						MovieImpl.class, movie.getPrimaryKey()) == null) {
				cacheResult(movie);
			}
			else {
				movie.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all movies.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MovieImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the movie.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Movie movie) {
		entityCache.removeResult(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieImpl.class, movie.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((MovieModelImpl)movie, true);
	}

	@Override
	public void clearCache(List<Movie> movies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Movie movie : movies) {
			entityCache.removeResult(MovieModelImpl.ENTITY_CACHE_ENABLED,
				MovieImpl.class, movie.getPrimaryKey());

			clearUniqueFindersCache((MovieModelImpl)movie, true);
		}
	}

	protected void cacheUniqueFindersCache(MovieModelImpl movieModelImpl) {
		Object[] args = new Object[] {
				movieModelImpl.getUuid(), movieModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			movieModelImpl, false);
	}

	protected void clearUniqueFindersCache(MovieModelImpl movieModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					movieModelImpl.getUuid(), movieModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((movieModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					movieModelImpl.getOriginalUuid(),
					movieModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new movie with the primary key. Does not add the movie to the database.
	 *
	 * @param movieId the primary key for the new movie
	 * @return the new movie
	 */
	@Override
	public Movie create(long movieId) {
		Movie movie = new MovieImpl();

		movie.setNew(true);
		movie.setPrimaryKey(movieId);

		String uuid = PortalUUIDUtil.generate();

		movie.setUuid(uuid);

		movie.setCompanyId(companyProvider.getCompanyId());

		return movie;
	}

	/**
	 * Removes the movie with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param movieId the primary key of the movie
	 * @return the movie that was removed
	 * @throws NoSuchMovieException if a movie with the primary key could not be found
	 */
	@Override
	public Movie remove(long movieId) throws NoSuchMovieException {
		return remove((Serializable)movieId);
	}

	/**
	 * Removes the movie with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the movie
	 * @return the movie that was removed
	 * @throws NoSuchMovieException if a movie with the primary key could not be found
	 */
	@Override
	public Movie remove(Serializable primaryKey) throws NoSuchMovieException {
		Session session = null;

		try {
			session = openSession();

			Movie movie = (Movie)session.get(MovieImpl.class, primaryKey);

			if (movie == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMovieException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(movie);
		}
		catch (NoSuchMovieException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Movie removeImpl(Movie movie) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(movie)) {
				movie = (Movie)session.get(MovieImpl.class,
						movie.getPrimaryKeyObj());
			}

			if (movie != null) {
				session.delete(movie);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (movie != null) {
			clearCache(movie);
		}

		return movie;
	}

	@Override
	public Movie updateImpl(Movie movie) {
		boolean isNew = movie.isNew();

		if (!(movie instanceof MovieModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(movie.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(movie);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in movie proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Movie implementation " +
				movie.getClass());
		}

		MovieModelImpl movieModelImpl = (MovieModelImpl)movie;

		if (Validator.isNull(movie.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			movie.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (movie.getCreateDate() == null)) {
			if (serviceContext == null) {
				movie.setCreateDate(now);
			}
			else {
				movie.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!movieModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				movie.setModifiedDate(now);
			}
			else {
				movie.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (movie.isNew()) {
				session.save(movie);

				movie.setNew(false);
			}
			else {
				movie = (Movie)session.merge(movie);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MovieModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { movieModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					movieModelImpl.getUuid(), movieModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { movieModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			args = new Object[] { movieModelImpl.getMovieName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MOVIENAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MOVIENAME,
				args);

			args = new Object[] { movieModelImpl.getRating() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_RATING, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATING,
				args);

			args = new Object[] {
					movieModelImpl.getGroupId(), movieModelImpl.getMovieId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_G_G, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_G,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((movieModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { movieModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { movieModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((movieModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						movieModelImpl.getOriginalUuid(),
						movieModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						movieModelImpl.getUuid(), movieModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((movieModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { movieModelImpl.getOriginalGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { movieModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((movieModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MOVIENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						movieModelImpl.getOriginalMovieName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MOVIENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MOVIENAME,
					args);

				args = new Object[] { movieModelImpl.getMovieName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MOVIENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MOVIENAME,
					args);
			}

			if ((movieModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATING.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { movieModelImpl.getOriginalRating() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RATING, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATING,
					args);

				args = new Object[] { movieModelImpl.getRating() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RATING, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATING,
					args);
			}

			if ((movieModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						movieModelImpl.getOriginalGroupId(),
						movieModelImpl.getOriginalMovieId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_G, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_G,
					args);

				args = new Object[] {
						movieModelImpl.getGroupId(), movieModelImpl.getMovieId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_G, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_G,
					args);
			}
		}

		entityCache.putResult(MovieModelImpl.ENTITY_CACHE_ENABLED,
			MovieImpl.class, movie.getPrimaryKey(), movie, false);

		clearUniqueFindersCache(movieModelImpl, false);
		cacheUniqueFindersCache(movieModelImpl);

		movie.resetOriginalValues();

		return movie;
	}

	/**
	 * Returns the movie with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the movie
	 * @return the movie
	 * @throws NoSuchMovieException if a movie with the primary key could not be found
	 */
	@Override
	public Movie findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMovieException {
		Movie movie = fetchByPrimaryKey(primaryKey);

		if (movie == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMovieException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return movie;
	}

	/**
	 * Returns the movie with the primary key or throws a {@link NoSuchMovieException} if it could not be found.
	 *
	 * @param movieId the primary key of the movie
	 * @return the movie
	 * @throws NoSuchMovieException if a movie with the primary key could not be found
	 */
	@Override
	public Movie findByPrimaryKey(long movieId) throws NoSuchMovieException {
		return findByPrimaryKey((Serializable)movieId);
	}

	/**
	 * Returns the movie with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the movie
	 * @return the movie, or <code>null</code> if a movie with the primary key could not be found
	 */
	@Override
	public Movie fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MovieModelImpl.ENTITY_CACHE_ENABLED,
				MovieImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Movie movie = (Movie)serializable;

		if (movie == null) {
			Session session = null;

			try {
				session = openSession();

				movie = (Movie)session.get(MovieImpl.class, primaryKey);

				if (movie != null) {
					cacheResult(movie);
				}
				else {
					entityCache.putResult(MovieModelImpl.ENTITY_CACHE_ENABLED,
						MovieImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MovieModelImpl.ENTITY_CACHE_ENABLED,
					MovieImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return movie;
	}

	/**
	 * Returns the movie with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param movieId the primary key of the movie
	 * @return the movie, or <code>null</code> if a movie with the primary key could not be found
	 */
	@Override
	public Movie fetchByPrimaryKey(long movieId) {
		return fetchByPrimaryKey((Serializable)movieId);
	}

	@Override
	public Map<Serializable, Movie> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Movie> map = new HashMap<Serializable, Movie>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Movie movie = fetchByPrimaryKey(primaryKey);

			if (movie != null) {
				map.put(primaryKey, movie);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MovieModelImpl.ENTITY_CACHE_ENABLED,
					MovieImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Movie)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MOVIE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Movie movie : (List<Movie>)q.list()) {
				map.put(movie.getPrimaryKeyObj(), movie);

				cacheResult(movie);

				uncachedPrimaryKeys.remove(movie.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MovieModelImpl.ENTITY_CACHE_ENABLED,
					MovieImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the movies.
	 *
	 * @return the movies
	 */
	@Override
	public List<Movie> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Movie> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Movie> findAll(int start, int end,
		OrderByComparator<Movie> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Movie> findAll(int start, int end,
		OrderByComparator<Movie> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Movie> list = null;

		if (retrieveFromCache) {
			list = (List<Movie>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MOVIE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MOVIE;

				if (pagination) {
					sql = sql.concat(MovieModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Movie>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the movies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Movie movie : findAll()) {
			remove(movie);
		}
	}

	/**
	 * Returns the number of movies.
	 *
	 * @return the number of movies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MOVIE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MovieModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the movie persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MovieImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MOVIE = "SELECT movie FROM Movie movie";
	private static final String _SQL_SELECT_MOVIE_WHERE_PKS_IN = "SELECT movie FROM Movie movie WHERE movieId IN (";
	private static final String _SQL_SELECT_MOVIE_WHERE = "SELECT movie FROM Movie movie WHERE ";
	private static final String _SQL_COUNT_MOVIE = "SELECT COUNT(movie) FROM Movie movie";
	private static final String _SQL_COUNT_MOVIE_WHERE = "SELECT COUNT(movie) FROM Movie movie WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "movie.movieId";
	private static final String _FILTER_SQL_SELECT_MOVIE_WHERE = "SELECT DISTINCT {movie.*} FROM movies_Movie movie WHERE ";
	private static final String _FILTER_SQL_SELECT_MOVIE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {movies_Movie.*} FROM (SELECT DISTINCT movie.movieId FROM movies_Movie movie WHERE ";
	private static final String _FILTER_SQL_SELECT_MOVIE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN movies_Movie ON TEMP_TABLE.movieId = movies_Movie.movieId";
	private static final String _FILTER_SQL_COUNT_MOVIE_WHERE = "SELECT COUNT(DISTINCT movie.movieId) AS COUNT_VALUE FROM movies_Movie movie WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "movie";
	private static final String _FILTER_ENTITY_TABLE = "movies_Movie";
	private static final String _ORDER_BY_ENTITY_ALIAS = "movie.";
	private static final String _ORDER_BY_ENTITY_TABLE = "movies_Movie.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Movie exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Movie exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MoviePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}