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
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
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

<jsp:useBean id="edit" type="com.liferay.training.movies.model.Movie" scope="request" />
<jsp:useBean id="editAuth" type="com.liferay.training.movies.model.Author" scope="request" />
 
 
	<portlet:actionURL name="<%=MVCCommandNames.UPDATE_MOVIE %>" var="updateMovieURL"/>
	
	<aui:form action="<%=updateMovieURL.toString() %>" method="post">
		<aui:input name="movieId" value="<%=edit.getPrimaryKey() %>" type="hidden" /> 
		<aui:input name="movieName" label="Movie Name" value="<%=edit.getMovieName() %>" size="45" />
		<aui:input name="description" label="Description" value="<%=edit.getDescription() %>" />
		<aui:input name="rating" label="Rating" value="<%=edit.getRating() %>" />
		<aui:input name="authorId" value="<%=editAuth.getAuthorId() %>" type="hidden" />
		<aui:input name="authorName" label="Author Name" value="<%=editAuth.getAuthorName() %>" />
		<aui:input name="biography" label= "Biography" value="<%=editAuth.getBiography() %>" />
		
		<aui:button type="submit" value="Save"/>
</aui:form> 