<%@ include file ="/init.jsp"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="jspPage" value="/view.jsp"/>
</portlet:renderURL>


<jsp:useBean id="edit" type="com.liferay.training.movies.model.Movie" scope="request" />
<jsp:useBean id="editAuth" type="com.liferay.training.movies.model.Author" scope="request" />
 	
	<portlet:actionURL name="<%=MVCCommandNames.UPDATE_MOVIE %>" var="updateMovieURL"/>
	
	<aui:form action="<%=updateMovieURL.toString() %>" method="post">
	
		<aui:input 
			name="movieId" 
			value="<%=edit.getPrimaryKey() %>" type="hidden" 
		/> 
		
		<aui:input 
			name="movieName" 
			label="Movie Name"
			required="true" 
			value="<%=edit.getMovieName() %>" size="45" 
		/>
		
		<aui:input 
			name="description" 
			type="textarea"	
			label="Description"
			required="true" 
			value="<%=edit.getDescription() %>" 
		/>
		
		<aui:input 
			name="rating"
			type="number"
			label="Rating"
			required="true"
			max="20"
			min="0"
			helpMessage="Rate the movie from 0 to 20"
			value="<%=edit.getRating() %>" 
		/>
		
		<aui:input 
			name="authorId" 
			value="<%=editAuth.getAuthorId() %>" 
			type="hidden" 
		/>
		
		<aui:input 
			name="authorName" 
			label="Author Name"
			required="true" 
			value="<%=editAuth.getAuthorName() %>" 
		/>
		
		<aui:input 
			name="biography" 
			type="textarea"
			label= "Biography" 
			required="true"
			value="<%=editAuth.getBiography() %>" 
		/>
		
		<aui:button type="submit" value="Save"> </aui:button>		
		<aui:button type="button" value="CANCEL" onClick="<%=viewURL.toString() %>"> </aui:button>
		
</aui:form> 
		