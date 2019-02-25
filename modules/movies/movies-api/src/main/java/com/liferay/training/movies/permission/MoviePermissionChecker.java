package com.liferay.training.movies.permission;

import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.training.movies.model.Movie;

public interface MoviePermissionChecker extends BaseModelPermissionChecker {
	
	public static final String ADD_MOVIE = "ADD_MOVIE";
	public static final String RESOURCE_NAME = Movie.class.getName();
	public static final String TOP_LEVEL_RESOURCE = Movie.class.getName()
			.substring(0, Movie.class.getName().lastIndexOf("."));
	
	public void check(PermissionChecker permissionChecker, long groupId, 
			long movieId, String actionId) throws AuthException; 
	
	public void checkTopLevel(PermissionChecker permissionChecker, 
			long groupId, String actionId) throws AuthException;
	
	public boolean contains(PermissionChecker permissionChecker, long groupId,
			long movieId, String actionId);
	
	public boolean containsTopLevel(PermissionChecker permissionChecker,
			long groupId, String actionId);
	
}
