<%@page import="com.liferay.training.movies.model.Author"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
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
<%@ page import="com.liferay.portal.kernel.search.Indexer" %>

<%
	String keywords = ParamUtil.getString(request, "keywords");
	//Long movieId = ParamUtil.getLong(request, "movieId");	
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name = "mvcPath" value="/view_search.jsp" />
</liferay-portlet:renderURL>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view_test.jsp" />
</portlet:renderURL>


<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

<liferay-ui:header backURL="<%= viewURL.toString() %>" title="search" />
    <div class="search-form">
        <span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" 
            size="30" title="search-entries" type="text" />
            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>

<%
	SearchContext searchContext = SearchContextFactory.getInstance(request);
	searchContext.setKeywords(keywords);
	searchContext.setAttribute("paginationType", "more");
	searchContext.setStart(0);
	searchContext.setEnd(10);
	
	Indexer indexer = IndexerRegistryUtil.getIndexer(Movie.class);

	System.out.println("indexerLength " + indexer.search(searchContext).getLength());
	
	Hits hits = indexer.search(searchContext);
	
	List<Movie> movies = new ArrayList<Movie>();
	System.out.println("here");
	
	System.out.println("hitsDocsLength " + hits.getDocs().length);
	
	
	for (int i = 0 ; i < hits.getDocs().length ; i++ ) {
		System.out.println("for");
		
		Document doc = hits.doc(i);
		
		long movieeId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
		
		Movie movie = null;
		
		try {
			movie = MovieLocalServiceUtil.getMovie(movieeId);
			
		} catch (PortalException e) {
			e.getStackTrace();
		} catch (SystemException e) {
			e.getStackTrace();
		}
		
		if (movie == null) {		
			System.out.println("null list");
		} else {
			System.out.println("movieName: " + movie.getMovieName());
		}
		movies.add(movie);
	}
%>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-entries-were-found" total="<%= movies.size() %>">
	<liferay-ui:search-container-results results="<%=movies %>"/>
	
	<liferay-ui:search-container-row className="com.liferay.training.movies.model.Movie"
        keyProperty="entryId" modelVar="entry" escapedModel="<%=true%>">
        <%-- 
	    <liferay-ui:search-container-column-text name="guestbook" value="<%=guestbookMap.get(Long.toString(entry.getGuestbookId()))%>" />
        <liferay-ui:search-container-column-text name="movies" value="<%=movies.get(Long.toString(entry.getMovieId()))%>" />
    	<liferay-ui:search-container-column-text property="rating" />
    	<liferay-ui:search-container-column-jsp path="/button.jsp" align="right" />
    	
        --%>        
 
    	<liferay-ui:search-container-column-text property="movieName" />
	</liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>



