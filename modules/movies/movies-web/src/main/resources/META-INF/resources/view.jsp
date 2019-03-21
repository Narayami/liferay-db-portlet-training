<%@page import="com.liferay.training.movies.web.constants.MVCCommandNames"%>
<%@ include file ="/init.jsp"%>


<portlet:renderURL var="updateMovieURL">
	<portlet:param name="jspPage" value="/update.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="viewMoviesURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_MOVIE %>" />
</portlet:renderURL>

<portlet:renderURL var="viewForumURL">
	<portlet:param name="jspPage" value="/viewForums.jsp" />
</portlet:renderURL>

<portlet:renderURL var="testURL">
	<portlet:param name="jspPage" value="/test_feed.jsp" />
</portlet:renderURL>

<center>
	<img src="<%=request.getContextPath()%>/img/lordOfTheRings.jpeg" style="width:100%"/>
</center>

<aui:button-row align="center">
	<aui:button type="button" value="ADD MOVIE" onClick="<%=updateMovieURL.toString() %>"> </aui:button>
	<aui:button type="button" value="VIEW MOVIES" onClick="<%=viewMoviesURL.toString() %>"> </aui:button>
	<%-- 
	<aui:button type="button" value="FORUM" onClick="<%=viewForumURL.toString() %>"> </aui:button>
	--%>
	<aui:button type="button" value="FORUM" href="http://localhost:8080/web/guest/forum"> </aui:button>
	<aui:button type="button" value="TEST" onClick="<%=testURL.toString()%>"> </aui:button>
	
</aui:button-row>