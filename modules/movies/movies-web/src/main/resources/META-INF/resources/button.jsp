<%@include file ="/init.jsp"%>
 
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
