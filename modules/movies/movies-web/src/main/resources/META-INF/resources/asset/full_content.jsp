<%@ include file="/init.jsp"%>
<%-- 
	This is for showing movie full content in Asset Publisher portlet.  
--%>
<%
	AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);
					
	String viewEntryURL = assetRenderer.getURLView(liferayPortletResponse, WindowState.MAXIMIZED);
					
	Movie movie = (Movie)request.getAttribute("movie");					
%>

<aui:a cssClass="title-link" href="<%= viewEntryURL %>">
	<h3 class="title"><%= HtmlUtil.escape(movie.getMovieName()) %></h3>
</aui:a>

<div class="autofit-col autofit-col-expand">
	${movie.getDescription()}
</div>
