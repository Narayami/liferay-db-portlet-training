<%@ include file="/init.jsp"%>

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
        