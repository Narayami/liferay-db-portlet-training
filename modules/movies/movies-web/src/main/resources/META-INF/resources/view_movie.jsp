<%@ include file="/init.jsp"%>

<%
	String redirect = ParamUtil.getString(request, "backURL");
	long movieId = ParamUtil.getLong(request, "movieId");
	Movie selectedMovieObject = null;
	if (movieId > 0) {
		selectedMovieObject = MovieLocalServiceUtil.getMovie(movieId);
	}
%>
<%
	long authorId = ParamUtil.getLong(request, "authorId");
	Author selectedAuthor = null;
	if (authorId > 0) {
		selectedAuthor = AuthorLocalServiceUtil.getAuthor(authorId);
	}
%>

<%
	if(selectedMovieObject != null) {
%>
		<h3>The following are the selected Movie Information</h3>
		
		<br>
		<strong>Movie Name:</strong><br>
		<%=selectedMovieObject.getMovieName() %>
		
		<br>
		<strong>Movie Description:</strong><br>
		<%=selectedMovieObject.getDescription() %>
		
		<br>
		<strong>Movie Rating:</strong><br>
		<%=selectedMovieObject.getRating()%>
		
		<br>
		<strong>Author Name:</strong><br>
		<%=selectedAuthor.getAuthorName() %>
		
		<br>
		<strong>Author Biography:</strong><br>
		<%=selectedAuthor.getBiography() %>
<%
	}
%>
<aui:button-row>
	<aui:button type="button" value="Back" onClick="<%=redirect %>"> </aui:button>
</aui:button-row>
