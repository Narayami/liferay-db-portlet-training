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

package com.liferay.training.movies.service.impl;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.training.movies.exception.NoSuchAuthorException;
import com.liferay.training.movies.model.Author;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.MovieLocalServiceUtil;
import com.liferay.training.movies.service.base.AuthorLocalServiceBaseImpl;

/**
 * The implementation of the author local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.movies.service.AuthorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuthorLocalServiceBaseImpl
 * @see com.liferay.training.movies.service.AuthorLocalServiceUtil
 */
public class AuthorLocalServiceImpl extends AuthorLocalServiceBaseImpl {
	
	@Indexable(
		type = IndexableType.REINDEX
	)
	public Author addAuthor(long movieId, String authorName, String biography, ServiceContext serviceContext) 
			throws PortalException {
		
		Movie movie = MovieLocalServiceUtil.getMovie(movieId);
		
		long userId = serviceContext.getUserId();
		User user = UserLocalServiceUtil.getUser(userId);
		
		//generate the author pk and create obj author using the pk
		long authorId = counterLocalService.increment(Author.class.getName());
		Author author = authorLocalService.createAuthor(authorId);
		
		author.setCompanyId(movie.getCompanyId());
		author.setGroupId(movie.getGroupId());
		author.setAuthorId(authorId);
		author.setAuthorName(authorName);
		author.setBiography(biography);
		author.setUserName(user.getScreenName());
		author.setMovieId(movieId);
		author.setUserId(userId);
		author.setCreateDate(new Date());
		author.setModifiedDate(new Date());
		
		return super.addAuthor(author);
	}
	
	@Indexable(
		type = IndexableType.REINDEX
	)
	public Author updateAuthor(long authorId, String authorName, String biography, ServiceContext serviceContext)
			throws PortalException{
		
		Author author = authorLocalService.getAuthor(authorId);
		Movie movie = movieLocalService.getMovie(author.getMovieId());
		
		author.setAuthorName(authorName);
		author.setBiography(biography);
		
		return super.updateAuthor(author);
	} 
	
	public List<Author> getAuthorsByGroupId(long groupId) {
		return authorPersistence.findByGroupId(groupId);
	}
	
	public List<Author> getAuthorsByGroupId(long groupId, int start, int end) {
		return authorPersistence.findByGroupId(groupId, start, end);
	}
	 
	public int getAuthorCountByGroupId(long groupId) {
		return authorPersistence.countByGroupId(groupId);
	}

	@Override
	public Author getAuthorByMovieId(long movieId) throws NoSuchAuthorException {
		return authorPersistence.findByAuthorByMovieId(movieId);
	}
	
	//TODO-REMOVE THAT FINDERS
	@Override
	public int getAuthorCountByMovies(long movieId, long authorId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Author getAuthotByMovieId(Long authorId, long movieId) throws NoSuchAuthorException {
		// TODO Auto-generated method stub
		return null;
	}
}

