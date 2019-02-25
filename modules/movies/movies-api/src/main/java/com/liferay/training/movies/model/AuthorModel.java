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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Author service. Represents a row in the &quot;movies_Author&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.training.movies.model.impl.AuthorModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.training.movies.model.impl.AuthorImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Author
 * @see com.liferay.training.movies.model.impl.AuthorImpl
 * @see com.liferay.training.movies.model.impl.AuthorModelImpl
 * @generated
 */
@ProviderType
public interface AuthorModel extends BaseModel<Author>, GroupedModel,
	ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a author model instance should use the {@link Author} interface instead.
	 */

	/**
	 * Returns the primary key of this author.
	 *
	 * @return the primary key of this author
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this author.
	 *
	 * @param primaryKey the primary key of this author
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this author.
	 *
	 * @return the uuid of this author
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this author.
	 *
	 * @param uuid the uuid of this author
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the author ID of this author.
	 *
	 * @return the author ID of this author
	 */
	public long getAuthorId();

	/**
	 * Sets the author ID of this author.
	 *
	 * @param authorId the author ID of this author
	 */
	public void setAuthorId(long authorId);

	/**
	 * Returns the group ID of this author.
	 *
	 * @return the group ID of this author
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this author.
	 *
	 * @param groupId the group ID of this author
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this author.
	 *
	 * @return the company ID of this author
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this author.
	 *
	 * @param companyId the company ID of this author
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this author.
	 *
	 * @return the user ID of this author
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this author.
	 *
	 * @param userId the user ID of this author
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this author.
	 *
	 * @return the user uuid of this author
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this author.
	 *
	 * @param userUuid the user uuid of this author
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this author.
	 *
	 * @return the user name of this author
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this author.
	 *
	 * @param userName the user name of this author
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this author.
	 *
	 * @return the create date of this author
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this author.
	 *
	 * @param createDate the create date of this author
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this author.
	 *
	 * @return the modified date of this author
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this author.
	 *
	 * @param modifiedDate the modified date of this author
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the author name of this author.
	 *
	 * @return the author name of this author
	 */
	@AutoEscape
	public String getAuthorName();

	/**
	 * Sets the author name of this author.
	 *
	 * @param authorName the author name of this author
	 */
	public void setAuthorName(String authorName);

	/**
	 * Returns the biography of this author.
	 *
	 * @return the biography of this author
	 */
	@AutoEscape
	public String getBiography();

	/**
	 * Sets the biography of this author.
	 *
	 * @param biography the biography of this author
	 */
	public void setBiography(String biography);

	/**
	 * Returns the movie ID of this author.
	 *
	 * @return the movie ID of this author
	 */
	public long getMovieId();

	/**
	 * Sets the movie ID of this author.
	 *
	 * @param movieId the movie ID of this author
	 */
	public void setMovieId(long movieId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Author author);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Author> toCacheModel();

	@Override
	public Author toEscapedModel();

	@Override
	public Author toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}