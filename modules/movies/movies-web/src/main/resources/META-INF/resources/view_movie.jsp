<%@page import="com.liferay.training.movies.service.AuthorLocalServiceUtil"%>
<%@page import="com.liferay.training.movies.service.MovieLocalServiceUtil"%>
<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.training.movies.model.Movie"%>
<%@page import="com.liferay.training.movies.model.Author"%>



<%
	String redirect = ParamUtil.getString(request, "backURL");
	long movieId = ParamUtil.getLong(request, "movieId");
	
	Movie selectedMovieObject = null;
	Author selAuth = null;
	if (movieId > 0) {
		selectedMovieObject = MovieLocalServiceUtil.getMovie(movieId);
		//todo-fix
		selAuth = AuthorLocalServiceUtil.getAuthor(selectedMovieObject.getAuthor().getAuthorId());
	}
%>

<a href="<%=redirect %>">Back</a>

<br/><br/>
<%
	if(selectedMovieObject != null) {
%>
		<h3>The following are the selected Movie Information</h3><br/>
		Movie Name:<%=selectedMovieObject.getMovieName()+"&nbsp;"+
		selectedMovieObject.getMovieName()%>
		<br/>
		Movie Description:
		<%=selectedMovieObject.getDescription() %><br/>
		Movie Rating:
		<%=selectedMovieObject.getRating()%> <br/>
		<%-- todo fix --%>
		Author Name:
		<%=selAuth.getAuthorName() %> <br/>
<%
	}
%>