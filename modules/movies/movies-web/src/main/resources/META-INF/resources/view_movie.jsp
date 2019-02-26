<%@page import="com.liferay.training.movies.service.MovieLocalServiceUtil"%>
<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.training.movies.model.Movie"%>


<%
	String redirect = ParamUtil.getString(request, "backURL");
	long movieId = ParamUtil.getLong(request, "movieId");
	
	Movie selectedMovieObject = null;
	if (movieId > 0) {
		selectedMovieObject = MovieLocalServiceUtil.getMovie(movieId);
	}
%>

<a href="<%=redirect %>">Back</a>

<br/><br/>
<%
	if(selectedMovieObject != null){
%>
		<h3>The following are the selected Movie Information</h3><br/>
		Movie Name:<%=selectedMovieObject.getMovieName()+"&nbsp;"+
		selectedMovieObject.getMovieName()%>
		<br/>
		Movie Description:
		<%=selectedMovieObject.getDescription() %><br/>
		Movie Rating:
		<%=selectedMovieObject.getRating()%>
		<br/>
<%
	}
%>