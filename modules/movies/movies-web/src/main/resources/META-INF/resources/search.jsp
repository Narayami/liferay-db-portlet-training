<%@page import="com.liferay.training.movies.web.search.MovieDisplayTerms"%>
<%@page import="com.liferay.training.movies.web.search.MovieSearchContainer"%>
<%@ include file ="/init.jsp"%>

<%
	MovieSearchContainer searchContainer = (MovieSearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	MovieDisplayTerms displayTerms = (MovieDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle buttonLabel="Movie Search" displayTerms="<%= displayTerms %>" id="toggle_id_movie_search">
	<aui:input label="MovieID" name="movieId" value="<%=displayTerms.getId() %>"/>
	<aui:input label="MovieName" name="movieName" value="<%=displayTerms.getName() %>"/>
</liferay-ui:search-toggle>