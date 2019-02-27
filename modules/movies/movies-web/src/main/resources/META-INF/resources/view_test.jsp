<%@page import="com.liferay.training.movies.service.AuthorLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.xmlrpc.Response"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.training.movies.web.constants.MVCCommandNames"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.training.movies.permission.MoviePermissionChecker"%>
<%@page import="javax.portlet.filter.RenderResponseWrapper"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.training.movies.model.Movie"%>
<%@page import="javax.portlet.ActionURL"%>
<%@page import="javax.portlet.RenderURL"%>
<%@page import="com.liferay.training.movies.service.MovieLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.service.PersistedModelLocalService"%>
<%@page import="com.liferay.training.movies.service.persistence.MoviePersistence"%>
<%@page import="com.liferay.training.movies.service.MovieLocalService"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.liferay.training.movies.model.Movie"%>
<%@page import="java.util.*" %>
<%@ include file ="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<h1 align="center">Movies List</h1>

<portlet:actionURL var="goBackURL">
	<param name="jspPage" value="/view.jsp" />
</portlet:actionURL>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<liferay-portlet:param name="jspPage" value="/view_test.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:search-container emptyResultsMessage="there-are-no-movies"
	headerNames="movieName, description, rating, authorName, action"
	iteratorURL="<%=iteratorURL%>"
	delta="10"
	curParam="sc1"
	deltaConfigurable="true">
	
	<liferay-ui:search-container-results>
		<%
			int totalMovies = MovieLocalServiceUtil.getMoviesCount();
			results = MovieLocalServiceUtil.getMovies(searchContainer.getStart(), searchContainer.getEnd());
			searchContainer.setTotal(totalMovies);
			searchContainer.setResults(results);
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="com.liferay.training.movies.model.Movie"
		keyProperty="movieId" modelVar="currentMovie">
		
		<liferay-portlet:renderURL varImpl="rowURL">
			<portlet:param name="backURL" value="<%=currentURL %>"/>
			<portlet:param name="jspPage" value="/view_movie.jsp"/>
			<portlet:param name="movieId" value="<%=String.valueOf(currentMovie.getMovieId()) %>"/>
			<%-- test --%>
			<portlet:param name="authorId" value="<%=String.valueOf(currentMovie.getAuthor().getAuthorId()) %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:search-container-row-parameter name="rowURL" value="<%=rowURL.toString() %>"/>
			<liferay-ui:search-container-column-text href="<%=rowURL %>" name="Name" property="movieName"/>
			<liferay-ui:search-container-column-text href="<%=rowURL %>" name="description" property="description"/>
			<liferay-ui:search-container-column-text href="<%=rowURL %>" name="rating" property="rating"/>
			 
			<liferay-ui:search-container-column-text href="<%=rowURL %>" name="author" value="<%=currentMovie.getAuthor().getAuthorName() %>"/>
			<liferay-ui:search-container-column-text href="<%=rowURL %>" name="biography" value="<%=currentMovie.getAuthor().getBiography() %>"/>
			
			<liferay-ui:search-container-column-jsp align="center" path="/button.jsp"/>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" paginate="<%=true %>"/>
</liferay-ui:search-container>


<aui:button-row>
	<aui:button type="cancel" onClick="<%=goBackURL.toString() %>"></aui:button>
</aui:button-row>
