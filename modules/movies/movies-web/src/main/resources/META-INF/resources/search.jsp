<%@ include file ="/init.jsp"%>

<%
	MovieSearchContainer searchContainer = (MovieSearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = (DisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle buttonLabel="Movie Search" displayTerms="<%= displayTerms %>" id="toggle_id_movie_search">
	
	<aui:input label="MovieName" name="movieName" value="<%=displayTerms.getKeywords() %>"/>
	<%--
	<aui:input label="rating" name="rating" value="<%=displayTerms.getKeywords() %>"/>
	<aui:input label="authorName" name="authorName" value="<%=displayTerms.getAuthorName() %>"/>
	--%>
	
</liferay-ui:search-toggle>