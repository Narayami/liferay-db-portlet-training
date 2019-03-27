<%@ include file ="/init.jsp"%>

<h1 align="center">Movies List</h1>

<%
	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");
%>

<portlet:actionURL var="goBackURL">
	<param name="jspPage" value="/view.jsp" />
</portlet:actionURL>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<liferay-portlet:param name="jspPage" value="/view_test.jsp"/>
</liferay-portlet:renderURL>

<%
	PortletURL portletURL = iteratorURL;
	String portletURLString = portletURL.toString();
	MovieSearchContainer movieSearchContainer = new MovieSearchContainer(renderRequest, portletURL);
	DisplayTerms displayTerms = (DisplayTerms)movieSearchContainer.getDisplayTerms();
	
	//sort
	List<Movie> movieList = MovieHelper.getMovie(displayTerms, -1, -1);
	int t = movieList.size();
	
	//get local copy to be sorted in our need
	List<Movie> sortedMovieList = new ArrayList<Movie>(ListUtil.subList(movieList,
		movieSearchContainer.getStart(), movieSearchContainer.getEnd()));
		
	//sort the list based on order and column
	sortedMovieList = MovieComparatorUtil.sortMovies(sortedMovieList, orderByCol, orderByType);
	
	//test
	for (int i = 0 ; i < sortedMovieList.size() ; i ++) {
		if (movieList.get(i).getStatus() == WorkflowConstants.STATUS_PENDING) {
			System.out.println("pending mList");
			t -= 1;
		}
		
		if (sortedMovieList.get(i).getStatus() == WorkflowConstants.STATUS_PENDING) {
			System.out.println("pending sList");
			sortedMovieList.remove(i);
		}
		
	}
	
	//
	movieSearchContainer.setResults(sortedMovieList);
	movieSearchContainer.setTotal(t);
%>

<aui:form action="<%=iteratorURL %>" method="post" name="fm">
	<liferay-ui:search-container iteratorURL="<%=iteratorURL %>" searchContainer= "<%=movieSearchContainer %>">
	
	<liferay-ui:search-form page="/search.jsp" servletContext="<%=application %>" />
	
	<liferay-ui:search-container-results>
	
		
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="com.liferay.training.movies.model.Movie" modelVar="movie" >
		<liferay-portlet:renderURL varImpl="rowURL">
			<portlet:param name="backURL" value="<%=currentURL %>"/>
			<portlet:param name="jspPage" value="/view_movie.jsp"/>
			<portlet:param name="movieId" value="<%=String.valueOf(movie.getMovieId()) %>"/>
			<portlet:param name="authorId" value="<%=String.valueOf(movie.getAuthor().getAuthorId()) %>"/>
		</liferay-portlet:renderURL>
		
	<liferay-ui:search-container-row-parameter name="rowURL" value="<%=rowURL.toString() %>" />
		
		<liferay-ui:search-container-column-text href="<%=rowURL %>"
			name="Movie ID"
			property="movieId"
			align="center"
		/>
		
		<liferay-ui:search-container-column-text href="<%=rowURL %>"
			name="Movie Name"
			property="movieName"
			orderable="true" 
			orderableProperty="movieName"
			align="center" 
		/>
		
		<liferay-ui:search-container-column-text href="<%=rowURL %>"
			name="Rating" 
			property="rating" 
			orderable="true"
			orderableProperty="rating"
			align="center"
		/>
		
		<liferay-ui:search-container-column-text href="<%=rowURL %>"
			name="Description"
			property="description" 
			align="justify"
		/>
		
		<liferay-ui:search-container-column-text href="<%=rowURL %>"
			name="author" 
			orderable="true"
			orderableProperty="authorName"
			value="<%=movie.getAuthor().getAuthorName() %>"
			align="center"
		/>
		
		<liferay-ui:search-container-column-text href="<%=rowURL %>"
			name="biography" 
			value="<%=movie.getAuthor().getBiography() %>"
			align="justify"
		 />
			
		<liferay-ui:search-container-column-status align="center" property="status" />
		
		<liferay-ui:search-container-column-jsp align="center" path="/button.jsp" />
			
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator searchContainer="<%=movieSearchContainer %>" paginate="true" />
	
	</liferay-ui:search-container>
	
</aui:form>

<aui:button-row>
	<aui:button type="cancel" onClick="<%=goBackURL.toString() %>"></aui:button>
</aui:button-row>


