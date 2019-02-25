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
 * This class is a wrapper for {@link Author}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Author
 * @generated
 */
@ProviderType
public class AuthorWrapper implements Author, ModelWrapper<Author> {
	public AuthorWrapper(Author author) {
		_author = author;
	}

	@Override
	public Class<?> getModelClass() {
		return Author.class;
	}

	@Override
	public String getModelClassName() {
		return Author.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("authorId", getAuthorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("authorName", getAuthorName());
		attributes.put("biography", getBiography());
		attributes.put("movieId", getMovieId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String authorName = (String)attributes.get("authorName");

		if (authorName != null) {
			setAuthorName(authorName);
		}

		String biography = (String)attributes.get("biography");

		if (biography != null) {
			setBiography(biography);
		}

		Long movieId = (Long)attributes.get("movieId");

		if (movieId != null) {
			setMovieId(movieId);
		}
	}

	@Override
	public Object clone() {
		return new AuthorWrapper((Author)_author.clone());
	}

	@Override
	public int compareTo(Author author) {
		return _author.compareTo(author);
	}

	/**
	* Returns the author ID of this author.
	*
	* @return the author ID of this author
	*/
	@Override
	public long getAuthorId() {
		return _author.getAuthorId();
	}

	/**
	* Returns the author name of this author.
	*
	* @return the author name of this author
	*/
	@Override
	public String getAuthorName() {
		return _author.getAuthorName();
	}

	/**
	* Returns the biography of this author.
	*
	* @return the biography of this author
	*/
	@Override
	public String getBiography() {
		return _author.getBiography();
	}

	/**
	* Returns the company ID of this author.
	*
	* @return the company ID of this author
	*/
	@Override
	public long getCompanyId() {
		return _author.getCompanyId();
	}

	/**
	* Returns the create date of this author.
	*
	* @return the create date of this author
	*/
	@Override
	public Date getCreateDate() {
		return _author.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _author.getExpandoBridge();
	}

	/**
	* Returns the group ID of this author.
	*
	* @return the group ID of this author
	*/
	@Override
	public long getGroupId() {
		return _author.getGroupId();
	}

	/**
	* Returns the modified date of this author.
	*
	* @return the modified date of this author
	*/
	@Override
	public Date getModifiedDate() {
		return _author.getModifiedDate();
	}

	/**
	* Returns the movie ID of this author.
	*
	* @return the movie ID of this author
	*/
	@Override
	public long getMovieId() {
		return _author.getMovieId();
	}

	/**
	* Returns the primary key of this author.
	*
	* @return the primary key of this author
	*/
	@Override
	public long getPrimaryKey() {
		return _author.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _author.getPrimaryKeyObj();
	}

	/**
	* Returns the user ID of this author.
	*
	* @return the user ID of this author
	*/
	@Override
	public long getUserId() {
		return _author.getUserId();
	}

	/**
	* Returns the user name of this author.
	*
	* @return the user name of this author
	*/
	@Override
	public String getUserName() {
		return _author.getUserName();
	}

	/**
	* Returns the user uuid of this author.
	*
	* @return the user uuid of this author
	*/
	@Override
	public String getUserUuid() {
		return _author.getUserUuid();
	}

	/**
	* Returns the uuid of this author.
	*
	* @return the uuid of this author
	*/
	@Override
	public String getUuid() {
		return _author.getUuid();
	}

	@Override
	public int hashCode() {
		return _author.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _author.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _author.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _author.isNew();
	}

	@Override
	public void persist() {
		_author.persist();
	}

	/**
	* Sets the author ID of this author.
	*
	* @param authorId the author ID of this author
	*/
	@Override
	public void setAuthorId(long authorId) {
		_author.setAuthorId(authorId);
	}

	/**
	* Sets the author name of this author.
	*
	* @param authorName the author name of this author
	*/
	@Override
	public void setAuthorName(String authorName) {
		_author.setAuthorName(authorName);
	}

	/**
	* Sets the biography of this author.
	*
	* @param biography the biography of this author
	*/
	@Override
	public void setBiography(String biography) {
		_author.setBiography(biography);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_author.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this author.
	*
	* @param companyId the company ID of this author
	*/
	@Override
	public void setCompanyId(long companyId) {
		_author.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this author.
	*
	* @param createDate the create date of this author
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_author.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_author.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_author.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_author.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this author.
	*
	* @param groupId the group ID of this author
	*/
	@Override
	public void setGroupId(long groupId) {
		_author.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this author.
	*
	* @param modifiedDate the modified date of this author
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_author.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the movie ID of this author.
	*
	* @param movieId the movie ID of this author
	*/
	@Override
	public void setMovieId(long movieId) {
		_author.setMovieId(movieId);
	}

	@Override
	public void setNew(boolean n) {
		_author.setNew(n);
	}

	/**
	* Sets the primary key of this author.
	*
	* @param primaryKey the primary key of this author
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_author.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_author.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this author.
	*
	* @param userId the user ID of this author
	*/
	@Override
	public void setUserId(long userId) {
		_author.setUserId(userId);
	}

	/**
	* Sets the user name of this author.
	*
	* @param userName the user name of this author
	*/
	@Override
	public void setUserName(String userName) {
		_author.setUserName(userName);
	}

	/**
	* Sets the user uuid of this author.
	*
	* @param userUuid the user uuid of this author
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_author.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this author.
	*
	* @param uuid the uuid of this author
	*/
	@Override
	public void setUuid(String uuid) {
		_author.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Author> toCacheModel() {
		return _author.toCacheModel();
	}

	@Override
	public Author toEscapedModel() {
		return new AuthorWrapper(_author.toEscapedModel());
	}

	@Override
	public String toString() {
		return _author.toString();
	}

	@Override
	public Author toUnescapedModel() {
		return new AuthorWrapper(_author.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _author.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthorWrapper)) {
			return false;
		}

		AuthorWrapper authorWrapper = (AuthorWrapper)obj;

		if (Objects.equals(_author, authorWrapper._author)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _author.getStagedModelType();
	}

	@Override
	public Author getWrappedModel() {
		return _author;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _author.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _author.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_author.resetOriginalValues();
	}

	private final Author _author;
}