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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.movies.service.http.MovieServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.movies.service.http.MovieServiceSoap
 * @generated
 */
@ProviderType
public class MovieSoap implements Serializable {
	public static MovieSoap toSoapModel(Movie model) {
		MovieSoap soapModel = new MovieSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMovieId(model.getMovieId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMovieName(model.getMovieName());
		soapModel.setDescription(model.getDescription());
		soapModel.setRating(model.getRating());
		soapModel.setUserName(model.getUserName());

		return soapModel;
	}

	public static MovieSoap[] toSoapModels(Movie[] models) {
		MovieSoap[] soapModels = new MovieSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MovieSoap[][] toSoapModels(Movie[][] models) {
		MovieSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MovieSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MovieSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MovieSoap[] toSoapModels(List<Movie> models) {
		List<MovieSoap> soapModels = new ArrayList<MovieSoap>(models.size());

		for (Movie model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MovieSoap[soapModels.size()]);
	}

	public MovieSoap() {
	}

	public long getPrimaryKey() {
		return _movieId;
	}

	public void setPrimaryKey(long pk) {
		setMovieId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMovieId() {
		return _movieId;
	}

	public void setMovieId(long movieId) {
		_movieId = movieId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getMovieName() {
		return _movieName;
	}

	public void setMovieName(String movieName) {
		_movieName = movieName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getRating() {
		return _rating;
	}

	public void setRating(int rating) {
		_rating = rating;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	private String _uuid;
	private long _movieId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _movieName;
	private String _description;
	private int _rating;
	private String _userName;
}