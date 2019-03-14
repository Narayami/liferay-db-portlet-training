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

package com.liferay.training.movies.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Movie}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Movie
 * @generated
 */
@ProviderType
public class MovieWrapper implements Movie, ModelWrapper<Movie> {
	public MovieWrapper(Movie movie) {
		_movie = movie;
	}

	@Override
	public Class<?> getModelClass() {
		return Movie.class;
	}

	@Override
	public String getModelClassName() {
		return Movie.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("movieId", getMovieId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("movieName", getMovieName());
		attributes.put("description", getDescription());
		attributes.put("rating", getRating());
		attributes.put("userName", getUserName());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long movieId = (Long)attributes.get("movieId");

		if (movieId != null) {
			setMovieId(movieId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String movieName = (String)attributes.get("movieName");

		if (movieName != null) {
			setMovieName(movieName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer rating = (Integer)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Object clone() {
		return new MovieWrapper((Movie)_movie.clone());
	}

	@Override
	public int compareTo(Movie movie) {
		return _movie.compareTo(movie);
	}

	@Override
	public Author getAuthor() {
		return _movie.getAuthor();
	}

	/**
	* Returns the company ID of this movie.
	*
	* @return the company ID of this movie
	*/
	@Override
	public long getCompanyId() {
		return _movie.getCompanyId();
	}

	/**
	* Returns the create date of this movie.
	*
	* @return the create date of this movie
	*/
	@Override
	public Date getCreateDate() {
		return _movie.getCreateDate();
	}

	/**
	* Returns the description of this movie.
	*
	* @return the description of this movie
	*/
	@Override
	public String getDescription() {
		return _movie.getDescription();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _movie.getExpandoBridge();
	}

	/**
	* Returns the group ID of this movie.
	*
	* @return the group ID of this movie
	*/
	@Override
	public long getGroupId() {
		return _movie.getGroupId();
	}

	/**
	* Returns the modified date of this movie.
	*
	* @return the modified date of this movie
	*/
	@Override
	public Date getModifiedDate() {
		return _movie.getModifiedDate();
	}

	/**
	* Returns the movie ID of this movie.
	*
	* @return the movie ID of this movie
	*/
	@Override
	public long getMovieId() {
		return _movie.getMovieId();
	}

	/**
	* Returns the movie name of this movie.
	*
	* @return the movie name of this movie
	*/
	@Override
	public String getMovieName() {
		return _movie.getMovieName();
	}

	/**
	* Returns the primary key of this movie.
	*
	* @return the primary key of this movie
	*/
	@Override
	public long getPrimaryKey() {
		return _movie.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _movie.getPrimaryKeyObj();
	}

	/**
	* Returns the rating of this movie.
	*
	* @return the rating of this movie
	*/
	@Override
	public int getRating() {
		return _movie.getRating();
	}

	/**
	* Returns the status of this movie.
	*
	* @return the status of this movie
	*/
	@Override
	public int getStatus() {
		return _movie.getStatus();
	}

	/**
	* Returns the user ID of this movie.
	*
	* @return the user ID of this movie
	*/
	@Override
	public long getUserId() {
		return _movie.getUserId();
	}

	/**
	* Returns the user name of this movie.
	*
	* @return the user name of this movie
	*/
	@Override
	public String getUserName() {
		return _movie.getUserName();
	}

	/**
	* Returns the user uuid of this movie.
	*
	* @return the user uuid of this movie
	*/
	@Override
	public String getUserUuid() {
		return _movie.getUserUuid();
	}

	/**
	* Returns the uuid of this movie.
	*
	* @return the uuid of this movie
	*/
	@Override
	public String getUuid() {
		return _movie.getUuid();
	}

	@Override
	public int hashCode() {
		return _movie.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _movie.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _movie.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _movie.isNew();
	}

	@Override
	public void persist() {
		_movie.persist();
	}

	@Override
	public void setAuthor(Author author) {
		_movie.setAuthor(author);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_movie.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this movie.
	*
	* @param companyId the company ID of this movie
	*/
	@Override
	public void setCompanyId(long companyId) {
		_movie.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this movie.
	*
	* @param createDate the create date of this movie
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_movie.setCreateDate(createDate);
	}

	/**
	* Sets the description of this movie.
	*
	* @param description the description of this movie
	*/
	@Override
	public void setDescription(String description) {
		_movie.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_movie.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_movie.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_movie.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this movie.
	*
	* @param groupId the group ID of this movie
	*/
	@Override
	public void setGroupId(long groupId) {
		_movie.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this movie.
	*
	* @param modifiedDate the modified date of this movie
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_movie.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the movie ID of this movie.
	*
	* @param movieId the movie ID of this movie
	*/
	@Override
	public void setMovieId(long movieId) {
		_movie.setMovieId(movieId);
	}

	/**
	* Sets the movie name of this movie.
	*
	* @param movieName the movie name of this movie
	*/
	@Override
	public void setMovieName(String movieName) {
		_movie.setMovieName(movieName);
	}

	@Override
	public void setNew(boolean n) {
		_movie.setNew(n);
	}

	/**
	* Sets the primary key of this movie.
	*
	* @param primaryKey the primary key of this movie
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_movie.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_movie.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the rating of this movie.
	*
	* @param rating the rating of this movie
	*/
	@Override
	public void setRating(int rating) {
		_movie.setRating(rating);
	}

	/**
	* Sets the status of this movie.
	*
	* @param status the status of this movie
	*/
	@Override
	public void setStatus(int status) {
		_movie.setStatus(status);
	}

	/**
	* Sets the user ID of this movie.
	*
	* @param userId the user ID of this movie
	*/
	@Override
	public void setUserId(long userId) {
		_movie.setUserId(userId);
	}

	/**
	* Sets the user name of this movie.
	*
	* @param userName the user name of this movie
	*/
	@Override
	public void setUserName(String userName) {
		_movie.setUserName(userName);
	}

	/**
	* Sets the user uuid of this movie.
	*
	* @param userUuid the user uuid of this movie
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_movie.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this movie.
	*
	* @param uuid the uuid of this movie
	*/
	@Override
	public void setUuid(String uuid) {
		_movie.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Movie> toCacheModel() {
		return _movie.toCacheModel();
	}

	@Override
	public Movie toEscapedModel() {
		return new MovieWrapper(_movie.toEscapedModel());
	}

	@Override
	public String toString() {
		return _movie.toString();
	}

	@Override
	public Movie toUnescapedModel() {
		return new MovieWrapper(_movie.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _movie.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MovieWrapper)) {
			return false;
		}

		MovieWrapper movieWrapper = (MovieWrapper)obj;

		if (Objects.equals(_movie, movieWrapper._movie)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _movie.getStagedModelType();
	}

	@Override
	public Movie getWrappedModel() {
		return _movie;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _movie.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _movie.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_movie.resetOriginalValues();
	}

	private final Movie _movie;
}