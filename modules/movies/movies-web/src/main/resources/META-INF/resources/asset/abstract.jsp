<%-- 
	This is for showing movie abstract in Asset Publisher portlet.  
--%>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.asset.kernel.model.AssetRenderer"%>
<%@ include file="/init.jsp"%>

<p>
	<%
		AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);
	%>

	<%= HtmlUtil.escape(assetRenderer.getSummary(renderRequest, renderResponse)) %>
</p>
