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

package com.liferay.training.movies.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.liferay.training.movies.model.Movie;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Movie in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Movie
 * @generated
 */
@ProviderType
public class MovieCacheModel implements CacheModel<Movie>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MovieCacheModel)) {
			return false;
		}

		MovieCacheModel movieCacheModel = (MovieCacheModel)obj;

		if (movieId == movieCacheModel.movieId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, movieId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", movieId=");
		sb.append(movieId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", movieName=");
		sb.append(movieName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", rating=");
		sb.append(rating);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Movie toEntityModel() {
		MovieImpl movieImpl = new MovieImpl();

		if (uuid == null) {
			movieImpl.setUuid("");
		}
		else {
			movieImpl.setUuid(uuid);
		}

		movieImpl.setMovieId(movieId);
		movieImpl.setGroupId(groupId);
		movieImpl.setCompanyId(companyId);
		movieImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			movieImpl.setCreateDate(null);
		}
		else {
			movieImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			movieImpl.setModifiedDate(null);
		}
		else {
			movieImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (movieName == null) {
			movieImpl.setMovieName("");
		}
		else {
			movieImpl.setMovieName(movieName);
		}

		if (description == null) {
			movieImpl.setDescription("");
		}
		else {
			movieImpl.setDescription(description);
		}

		movieImpl.setRating(rating);

		if (userName == null) {
			movieImpl.setUserName("");
		}
		else {
			movieImpl.setUserName(userName);
		}

		movieImpl.setStatus(status);
		movieImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			movieImpl.setStatusByUserName("");
		}
		else {
			movieImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			movieImpl.setStatusDate(null);
		}
		else {
			movieImpl.setStatusDate(new Date(statusDate));
		}

		movieImpl.resetOriginalValues();

		return movieImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		movieId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		movieName = objectInput.readUTF();
		description = objectInput.readUTF();

		rating = objectInput.readInt();
		userName = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(movieId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (movieName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(movieName);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(rating);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long movieId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String movieName;
	public String description;
	public int rating;
	public String userName;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}