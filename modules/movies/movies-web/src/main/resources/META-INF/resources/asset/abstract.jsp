<%@ include file="/init.jsp"%>
<%-- 
	This is for showing movie abstract in Asset Publisher portlet.  
--%>
<p>
	<%
		AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);
	%>
	<%= HtmlUtil.escape(assetRenderer.getSummary(renderRequest, renderResponse)) %>
</p>
