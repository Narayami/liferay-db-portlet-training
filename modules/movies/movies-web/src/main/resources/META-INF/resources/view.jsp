<%@page import="com.liferay.training.movies.web.constants.MVCCommandNames"%>
<%@ include file ="/init.jsp"%>


<portlet:renderURL var="updateMovieURL">
	<portlet:param name="jspPage" value="/update.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="viewMoviesURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_MOVIE %>" />
</portlet:renderURL>


<center>
	<img src="<%=request.getContextPath()%>/img/lordOfTheRings.jpeg" style="width:100%"/>
</center>
<aui:button-row align="center">
	<aui:button type="button" value="ADD MOVIE" onClick="<%=updateMovieURL.toString() %>"> </aui:button>
	<aui:button type="button" value ="VIEW MOVIES" onClick="<%=viewMoviesURL.toString() %>"> </aui:button>
</aui:button-row>