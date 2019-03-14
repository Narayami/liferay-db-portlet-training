<%@page import="com.liferay.training.movies.web.search.MovieHelper"%>
<%@page import="com.liferay.training.movies.web.search.MovieDisplayTerms"%>
<%@page import="com.liferay.training.movies.web.search.MovieSearchContainer"%>
<%@page import="com.liferay.portal.kernel.servlet.RequestDispatcherUtil"%>
<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="com.liferay.training.movies.web.comparator.MovieComparatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.training.movies.web.model.view.MovieViewModel"%>
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

<%-- 
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/view_search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL %>" method="get" name="fm" >
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	
	<div class="search-form" >
		<span class="aui-search-bar" >
			<aui:input inlineField="true" label="" name="keywords" size="5" title="search-entries" type="text"/>
			<aui:button type="submit" value="search" />
		</span>
	</div>
	
</aui:form>


<portlet:actionURL var="goBackURL">
	<param name="jspPage" value="/view.jsp" />
</portlet:actionURL>


<liferay-portlet:renderURL varImpl="iteratorURL">
	<liferay-portlet:param name="jspPage" value="/view_test.jsp"/>
</liferay-portlet:renderURL>

<%
	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");
%>

<liferay-ui:search-container delta="15" deltaConfigurable="true" iteratorURL="<%=iteratorURL %>">
	
	<liferay-ui:search-container-results >
		<%
			List<Movie> movieList = MovieLocalServiceUtil.getMoviesAndAuthors(-1, -1);
			
			//get local copy to be sorted in our need
			List<Movie> sortedMovieList = new ArrayList<Movie>(ListUtil.subList(movieList,
					searchContainer.getStart(), searchContainer.getEnd()));
			
			//sort the list based on order and column
			sortedMovieList = MovieComparatorUtil.sortMovies(sortedMovieList, orderByCol, orderByType);
			
			searchContainer.setResults(sortedMovieList);
			searchContainer.setTotal(movieList.size());
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="com.liferay.training.movies.model.Movie"
		keyProperty="movieId" modelVar="currentMovie">
		
		<liferay-portlet:renderURL varImpl="rowURL">
			<portlet:param name="backURL" value="<%=currentURL %>"/>
			<portlet:param name="jspPage" value="/view_movie.jsp"/>
			<portlet:param name="movieId" value="<%=String.valueOf(currentMovie.getMovieId()) %>"/>
			<portlet:param name="authorId" value="<%=String.valueOf(currentMovie.getAuthor().getAuthorId()) %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:search-container-row-parameter name="rowURL" value="<%=rowURL.toString() %>"/>
			<liferay-ui:search-container-column-text href="<%=rowURL %>"
				name="Name"
				property="movieName"
				orderableProperty="movieName"
				orderable="true"/>
			<liferay-ui:search-container-column-text href="<%=rowURL %>"
				name="description" 
				property="description" />
			<liferay-ui:search-container-column-text href="<%=rowURL %>"
				name="rating" 
				property="rating"
				orderableProperty="rating"
				orderable="true"/>
			 <liferay-ui:search-container-column-text href="<%=rowURL %>"
				name="author" 
				orderableProperty="authorName"
				orderable="true"
				value="<%=currentMovie.getAuthor().getAuthorName() %>"/>
			<liferay-ui:search-container-column-text href="<%=rowURL %>" 
				name="biography" 
				value="<%=currentMovie.getAuthor().getBiography() %>"/>
			
			<liferay-ui:search-container-column-jsp align="center" path="/button.jsp"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" paginate="true"/>
</liferay-ui:search-container>

<aui:button-row>
	<aui:button type="cancel" onClick="<%=goBackURL.toString() %>"></aui:button>
</aui:button-row>
--%>


<%-- TEST --%>

<liferay-portlet:renderURL varImpl="iteratorURL">
   <portlet:param name="mvcPath" value="/view_test.jsp" />
</liferay-portlet:renderURL>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	String portletURLString = portletURL.toString();
	MovieSearchContainer movieSearchContainer = new MovieSearchContainer(renderRequest, portletURL);
	MovieDisplayTerms displayTerms = (MovieDisplayTerms)movieSearchContainer.getDisplayTerms();
%>

<aui:form action="<%=iteratorURL %>" method="post" name="fm">

	<liferay-ui:search-container total="<%= MovieHelper.getTotalMovieCount(displayTerms, movieSearchContainer.getStart(), movieSearchContainer.getEnd()) %>"
		searchContainer="<%= movieSearchContainer %>" >

	<liferay-ui:search-form page="/search.jsp" servletContext="<%=application %>" />
	
	<liferay-ui:search-container-results results="<%=MovieHelper.getMovie(displayTerms,movieSearchContainer.getStart(), movieSearchContainer.getEnd()) %>" />
	
	<liferay-ui:search-container-row className="com.liferay.training.movies.model.Movie" modelVar="movie" >
		
		<liferay-ui:search-container-column-text property="movieId" />
		<liferay-ui:search-container-column-text property="movieName" />
		<liferay-ui:search-container-column-text property="rating" />
		<liferay-ui:search-container-column-text property="description" />
		
		
		<liferay-ui:search-container-column-text name="author" value="<%=movie.getAuthor().getAuthorName() %>" />
		
		
		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
	
	</liferay-ui:search-container>
	
</aui:form>


