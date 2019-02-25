<%@ include file="/init.jsp"%>

<c:set var="movie" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

<liferay-ui:icon-menu markupView="lexicon">

	<%-- View action. --%>

	<c:if
		test="${moviePermissionChecker.contains(permissionChecker, scopeGroupId, movie.movieId, 'VIEW' )}">
		<portlet:renderURL var="viewMoviesURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.VIEW_MOVIE %>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="movieId" value="${movie.movieId}" />
		</portlet:renderURL>

		<liferay-ui:icon message="view" url="${viewMoviesURL}" />
	</c:if>

	<%-- Edit action. --%>

	<c:if
		test="${moviePermissionChecker.contains(permissionChecker, scopeGroupId, movie.movieId, 'UPDATE' )}">
		<portlet:renderURL var="editMovieURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.EDIT_MOVIE %>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="movieId" value="${movie.movieId}" />
		</portlet:renderURL>

		<liferay-ui:icon message="edit" url="${editMovieURL}" />
	</c:if>
	
	<%-- Permissions action. --%>
	
	<c:if
		test="${moviePermissionChecker.contains(permissionChecker, scopeGroupId, movie.movieId, 'PERMISSIONS')}">

		<liferay-security:permissionsURL
			modelResource="com.liferay.training.movie.model.Movie"
			modelResourceDescription="${movie.getMovieName()}"
			resourcePrimKey="${movie.movieId}" 
			var="moviesURL" 
		/>

		<liferay-ui:icon message="permissions" url="${permissionsURL}" />
	</c:if>
		
	<%-- Delete action. --%>
	
	<c:if
		test="${moviePermissionChecker.contains(permissionChecker, scopeGroupId, movie.movieId, 'DELETE')}">

		<portlet:actionURL name="<%=MVCCommandNames.DELETE_MOVIE %>" var="deleteMovieURL">
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="movieId" value="${movie.movieId}" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="${deleteMovieURL}" />
	</c:if>
</liferay-ui:icon-menu>
