<%-- 
	movie editing view.
--%>

<%@ include file="/init.jsp"%>

<%-- Generate add / edit action URL and set movie. --%>

<c:choose>
	<c:when test="${not empty movie}">
		<portlet:actionURL var="movieActionURL" name="<%=MVCCommandNames.EDIT_MOVIE%>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editMovieName" value="edit-movie"/>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="movieActionURL" name="<%=MVCCommandNames.ADD_MOVIE%>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>
		
		<c:set var="editMovieName" value="add-movie"/>
	</c:otherwise>
</c:choose>

<%-- Error messages. --%>

<liferay-ui:error key="error.movie-service-error" message="error.assignment-service-error" />
<liferay-ui:error key="error.movie-movieName-empty" message="error.assignment-movieName-empty" />
<liferay-ui:error key="error.movie-description-empty" message="error.assignment-description-empty" />
<liferay-ui:error key="error.movie-rating-empty" message="error.assignment-rating-empty" />

<div class="container-fluid-1280 edit-movie">

	<h1><liferay-ui:message key="${editMovieName}" /></h1>

	<aui:model-context bean="${movie}" model="${movieClass}" />

	<aui:form action="${movieActionURL}" name="fm" onSubmit="event.preventDefault();">

		<aui:input name="movieId" field="movieId" type="hidden" />
		
		<aui:fieldset-group markupView="lexicon">
		
			<aui:fieldset>
			
				<%-- name field. --%>
				
				<aui:input name="movieName">
				
					<aui:validator name="required" />
					
					<%-- Custom AUI validator. --%>
					
					<aui:validator errorMessage="error.movie-movieName-format" name="custom">
						function(val, fieldNode, ruleValue) {
							var wordExpression = 
								new RegExp("^[^\\[\\]\\^$<>]*$");
							
							return wordExpression.test(val);
						}
					</aui:validator>
				</aui:input>

				<%-- Description field. --%>
				
				<aui:field-wrapper 
					cssClass="entry-content form-group movie-description" 
					label="description" 
					required="true">

					<liferay-ui:input-editor 
						contents="${movie.description}"
						editorName='alloyeditor' 
						name="descriptionEditor"
						placeholder="description">
						
						<aui:validator name="required" />
						
					</liferay-ui:input-editor>
					<aui:input name="description" type="hidden" />
				</aui:field-wrapper>

				<%-- Due date field. --%>
				  
				<aui:input name="rating">
					<aui:validator name="required" />
				</aui:input>
				
			</aui:fieldset>
		</aui:fieldset-group>
		
		<%--Buttons. --%>
		
		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>

</div>


<aui:script>

	/**
	* Handle form submit. Set editor value to the hidden field 
	* which transports the value to the backend.
	*/
	AUI().ready(function() {
		
		$('#<portlet:namespace />fm').on('submit', function() {

			var editorValue = window['<portlet:namespace />descriptionEditor'].getHTML();
			
			if (editorValue.length == 0) {
				return false;
			}
			
			window['<portlet:namespace />description'].value = editorValue;

			submitForm(document.<portlet:namespace />fm);
		});
	});

</aui:script>
