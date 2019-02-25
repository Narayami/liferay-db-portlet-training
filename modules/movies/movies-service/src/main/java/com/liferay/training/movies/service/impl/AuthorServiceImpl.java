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

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.movies.model.Author;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.AuthorLocalService;
import com.liferay.training.movies.service.AuthorServiceUtil;
import com.liferay.training.movies.service.base.AuthorServiceBaseImpl;

/**
 * The implementation of the author remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.movies.service.AuthorService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuthorServiceBaseImpl
 * @see com.liferay.training.movies.service.AuthorServiceUtil
 */
public class AuthorServiceImpl extends AuthorServiceBaseImpl {
	
	public Author addAuthor(long movieId, String authorName, String biography, ServiceContext serviceContext) 
			throws PortalException {
		
		return authorLocalService.addAuthor(movieId, authorName, biography, serviceContext);
	}

	public Author deleteAuthor(long authorId) 
			throws PortalException {
		
		return authorLocalService.deleteAuthor(authorId);
	}
	
	public Author getAuthor(long authorId) throws PortalException {
		Author author = authorLocalService.getAuthor(authorId);
		
		return author;
	}
		
	public List<Author> getAuthorsByGroupId(long groupId, int start, 
			int end) {
		
		return authorLocalService.getAuthorsByGroupId(groupId, start,end);
	} 
	
	public Author updateAuthor(long authorId, String authorName, 
			String biography, ServiceContext serviceContext) throws PortalException {
				
		return authorLocalService.updateAuthor(authorId, authorName, biography, serviceContext);
	}
	
}