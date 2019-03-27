<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>

<%@ taglib prefix="liferay-ddm" uri="http://liferay.com/tld/ddm" %>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
<%@ taglib prefix="liferay-security" uri="http://liferay.com/tld/security" %>

<%@ page import="javax.portlet.WindowState"%>
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="javax.portlet.RenderResponse"%>
<%@ page import="javax.portlet.ActionRequest"%>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.ActionURL"%>
<%@ page import="javax.portlet.RenderURL"%>
<%@ page import="javax.portlet.filter.RenderResponseWrapper"%>

<%@ page import="com.liferay.training.movies.web.model.view.MovieViewModel"%>
<%@ page import="com.liferay.training.movies.web.constants.MVCCommandNames"%>
<%@ page import="com.liferay.training.movies.web.constants.MoviesPortletKeys"%>
<%@ page import="com.liferay.training.movies.web.search.MovieSearchContainer"%>
<%@ page import="com.liferay.training.movies.web.search.MovieHelper"%>
<%@ page import="com.liferay.training.movies.web.comparator.MovieComparatorUtil"%>
<%@ page import="com.liferay.training.movies.service.MovieLocalServiceUtil"%>
<%@ page import="com.liferay.training.movies.service.AuthorLocalServiceUtil"%>
<%@ page import="com.liferay.training.movies.service.persistence.MoviePersistence"%>
<%@ page import="com.liferay.training.movies.service.MovieLocalService"%>
<%@ page import="com.liferay.training.movies.model.Movie"%>
<%@ page import="com.liferay.training.movies.model.Author"%>
<%@ page import="com.liferay.training.movies.permission.MoviePermissionChecker"%>

<%@ page import="com.liferay.portal.kernel.model.Group"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@ page import="com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand"%>
<%@ page import="com.liferay.portal.kernel.servlet.RequestDispatcherUtil"%>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.xmlrpc.Response"%>
<%@ page import="com.liferay.portal.kernel.service.PersistedModelLocalService"%>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.PermissionChecker"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.Indexer" %>
<%@ page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContext" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContextFactory" %>
<%@ page import="com.liferay.portal.kernel.search.Hits" %>
<%@ page import="com.liferay.portal.kernel.search.Document" %>
<%@ page import="com.liferay.portal.kernel.search.Field" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>

<%@ page import="com.liferay.asset.kernel.model.AssetRenderer"%>
<%@ page import="com.liferay.taglib.search.ResultRow"%>

<%@ page import="java.lang.ProcessBuilder.Redirect"%>

<%@ page import="java.util.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Date"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />
<liferay-frontend:defineObjects />





