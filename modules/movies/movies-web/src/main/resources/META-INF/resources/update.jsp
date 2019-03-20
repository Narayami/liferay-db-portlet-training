<%@page import="com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand"%>
<%@page import="com.liferay.training.movies.web.constants.MVCCommandNames"%>
<%@page import="com.liferay.training.movies.web.constants.MoviesPortletKeys"%>
<%@ include file="/init.jsp"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.liferay.training.movies.model.Movie"%>
<%@page import="javax.portlet.ActionURL"%>
<%@page import="javax.portlet.RenderURL"%>
<%@page import="com.liferay.training.movies.service.MovieLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.PersistedModelLocalService"%>
<%@page import="com.liferay.training.movies.service.persistence.MoviePersistence"%>
<%@page import="com.liferay.training.movies.service.MovieLocalService"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.training.movies.model.Movie"%>
<%@page import="java.util.*" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:renderURL var="goBackURL">
	<portlet:param name="jspPage" value="/view.jsp"/>
</portlet:renderURL>

<h1 align="center">Add a new Movie</h1>

<portlet:actionURL name='<%=MVCCommandNames.ADD_MOVIE %>' var="addMovieURL"></portlet:actionURL>

        <aui:form action="<%= addMovieURL %>" name="<portlet:namespace />fm">

            <aui:fieldset>

                <aui:input 
                	name="movie"
                	label="Movie Name"
                	required="true"
           			 
                />
                
                <aui:input 
                	name="description" 
                	type="textarea"
                	required="true" 
                />
                
                <aui:input 
                	name="rating" 
                	type="number"
                	max="20"
                	min="0"
                	helpMessage="Rate the movie from 0 to 20"
                	required="true" 
                />
                
                <aui:input 
                	name="author" 
                	required="true" 
                />
                
                <aui:input 
                	name="biography" 
                	type="textarea"
                	required="true" 
                />

            </aui:fieldset>

            <aui:button-row>
                <aui:button type="submit"></aui:button>
                <aui:button type="cancel" onClick="<%= goBackURL.toString() %>"></aui:button>
            </aui:button-row>
        </aui:form>
        