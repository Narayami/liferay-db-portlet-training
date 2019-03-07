<%@page import="com.liferay.training.movies.model.Author"%>
<%@page import="com.liferay.taglib.search.ResultRow"%>

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
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.training.movies.model.Movie"%>
<%@page import="java.util.*" %>
<%@ include file ="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
 
<%
 	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
 	Movie movie = (Movie)row.getObject();
 	String movieId = String.valueOf(movie.getMovieId());
 	String authorId = String.valueOf(movie.getAuthor().getAuthorId());
 	System.out.println("jsp-mov id: " + movieId);
 	System.out.println("jsp-auth id: " + authorId);
%>

<liferay-ui:icon-menu>

       <portlet:actionURL name="<%=MVCCommandNames.EDIT_MOVIE %>" var="editURL">
       		<portlet:param name="movieId" value="<%=movieId%>" />
       		<portlet:param name="authorId" value="<%=authorId%>" />
       </portlet:actionURL>

       <liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" /> 
 
       <portlet:actionURL name="<%=MVCCommandNames.DELETE_MOVIE %>" var="deleteURL">
           <portlet:param name="movieId" value="<%=movieId %>" />
           <portlet:param name="authorId" value="<%=authorId %>" />
       </portlet:actionURL>

         <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
         
</liferay-ui:icon-menu>
