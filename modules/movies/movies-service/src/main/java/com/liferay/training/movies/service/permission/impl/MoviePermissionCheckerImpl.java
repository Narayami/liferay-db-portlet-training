package com.liferay.training.movies.service.permission.impl;


import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.training.movies.permission.MoviePermissionChecker;


@Component(
		immediate = true,
		property = {
				"model.class.name=com.liferay.training.movies.model.Movie"
		},
		service = MoviePermissionChecker.class
)
public class MoviePermissionCheckerImpl implements MoviePermissionChecker {

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, 
			long primaryKey, String actionId) throws PortalException {
		check(permissionChecker, groupId, primaryKey, actionId);
	}
	
	@Override
	public void check(PermissionChecker permissionChecker, long groupId, 
			long movieId, String actionId) throws AuthException {
		if (!contains(permissionChecker, groupId, movieId, actionId)) {
			throw new AuthException();
		}
	}

	@Override
	public void checkTopLevel(PermissionChecker permissionChecker, long groupId, 
			String actionId) throws AuthException {
		if (!containsTopLevel(permissionChecker, groupId, actionId)) {
			throw new AuthException();
		}
	}

	@Override
	public boolean contains(PermissionChecker permissionChecker, long groupId, 
			long movieId, String actionId) {
		
		return permissionChecker.hasPermission(groupId, RESOURCE_NAME, movieId, actionId);
	}

	@Override
	public boolean containsTopLevel(PermissionChecker permissionChecker, 
			long groupId, String actionId) {
		return permissionChecker.hasPermission(groupId, TOP_LEVEL_RESOURCE, groupId, actionId);
	}

	
}
