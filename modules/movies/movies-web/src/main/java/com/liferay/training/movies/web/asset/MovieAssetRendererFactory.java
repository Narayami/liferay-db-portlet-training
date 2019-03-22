
package com.liferay.training.movies.web.asset;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactory;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Html;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.MovieLocalService;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;
import com.liferay.training.movies.web.constants.MVCCommandNames;
import com.liferay.training.movies.permission.MoviePermissionChecker;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + MoviesPortletKeys.MOVIES,
	}, 
	service = AssetRendererFactory.class
)
public class MovieAssetRendererFactory extends BaseAssetRendererFactory<Movie> {

	public MovieAssetRendererFactory() {

		setClassName(CLASS_NAME);
		setLinkable(true);
		setPortletId(MoviesPortletKeys.MOVIES);
		setSearchable(true);
	}

	@Override
	public AssetRenderer<Movie> getAssetRenderer(long classPK, int type) throws PortalException {

		Movie movie = _movieLocalService.getMovie(classPK);

		MovieAssetRenderer movieAssetRenderer = new MovieAssetRenderer(movie, this);
		movieAssetRenderer.setAssetRendererType(type);
		
		return movieAssetRenderer;
	}

	@Override
	public String getType() {

		return TYPE;
	}

	@Override
	public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse, 
			long classTypeId) {

		PortletURL portletURL = null;

		long refererGroupId = 0;
		long refererPlid = 0;
		
		ThemeDisplay themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		
		try {
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			portletURL = _portal.getControlPanelPortletURL(liferayPortletRequest, group,
					MoviesPortletKeys.MOVIES, refererGroupId, refererPlid, PortletRequest.RENDER_PHASE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		portletURL.setParameter("mvcRenderCommandName", MVCCommandNames.EDIT_MOVIE);
		portletURL.setParameter("showback", Boolean.FALSE.toString());

		return portletURL;
	}

	public MovieLocalService getMovieLocalService() {

		return _movieLocalService;
	}

	public Portal getPortal() {

		return _portal;
	}

	public MoviePermissionChecker moviePermissionChecker() {

		return _moviePermissionChecker;
	}

	public Html getHtml() {

		return _html;
	}

	public PortletURLFactory getPortletURLFactory() {

		return _portletURLFactory;
	}

	@Override
	public boolean hasAddPermission(PermissionChecker permissionChecker, long groupId, long classTypeId) throws Exception {

		return _moviePermissionChecker.containsTopLevel(permissionChecker, groupId, MoviePermissionChecker.ADD_MOVIE);
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, long classPK, String actionId) throws Exception {

		Movie movie = _movieLocalService.getMovie(classPK);

		return _moviePermissionChecker.contains(permissionChecker, movie.getGroupId(), movie.getMovieId(), actionId);
	}

	@Reference(target = "(osgi.web.symbolicname=com.liferay.training.movies.web)")
	private ServletContext _servletContext;

	@Reference
	private MovieLocalService _movieLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private Html _html;

	@Reference
	private PortletURLFactory _portletURLFactory;

	@Reference
	private MoviePermissionChecker _moviePermissionChecker;

	public static final String CLASS_NAME = Movie.class.getName();
	public static final String TYPE = "movie";

}
