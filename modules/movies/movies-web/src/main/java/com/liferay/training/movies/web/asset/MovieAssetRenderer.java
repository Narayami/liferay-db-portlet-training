package com.liferay.training.movies.web.asset;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.asset.util.AssetHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;
import com.liferay.training.movies.web.constants.MVCCommandNames;

public class MovieAssetRenderer extends BaseJSPAssetRenderer<Movie> {

	public MovieAssetRenderer(Movie movie, MovieAssetRendererFactory movieAssetRendererFactory) {
		_movie = movie;
		_movieAssetRendererFactory = movieAssetRendererFactory;
	}

	@Override
	public Movie getAssetObject() {

		return _movie;
	}

	@Override
	public String getClassName() {

		return Movie.class.getName();
	}

	@Override
	public long getClassPK() {

		return _movie.getMovieId();
	}

	@Override
	public long getGroupId() {

		return _movie.getGroupId();
	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {

		return "/asset/" + template + ".jsp";
	}

	@Override
	public int getStatus() {

		return _movie.getStatus();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {

		int abstractLength = AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH;

		if (portletRequest != null) {
			abstractLength = GetterUtil.getInteger(portletRequest.getAttribute(WebKeys.ASSET_ENTRY_ABSTRACT_LENGTH), 
					AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH);
		}

		String summary = HtmlUtil.stripHtml(StringUtil.shorten(_movie.getDescription(), abstractLength));

		return summary;
	}

	/*
	@Override
	public String getTitle(Locale locale) {

		return _movie.getTitle(locale);
	}
	 */
	
	//test
	public String getMovieName() {

		return _movie.getMovieName();
	}
	
	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws Exception {

		Group group = (Group) liferayPortletRequest.getAttribute(
			WebKeys.ASSET_RENDERER_FACTORY);
		
		//WebKeys.ASSET_RENDERER_FACTORY_GROUP

		PortletURL portletURL =_movieAssetRendererFactory.getPortal().getControlPanelPortletURL(liferayPortletRequest, 
				group, MoviesPortletKeys.MOVIES, 0, 0, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcRenderCommandName", MVCCommandNames.EDIT_MOVIE);
		portletURL.setParameter("movieId", String.valueOf(_movie.getMovieId()));
		portletURL.setParameter("showback", Boolean.FALSE.toString());

		return portletURL;
	}

	@Override
	public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {

		return super.getURLView(liferayPortletResponse, windowState);
	}

	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {

		try {
			long plid = _movieAssetRendererFactory.getPortal().getPlidFromPortletId(_movie.getGroupId(), 
					MoviesPortletKeys.MOVIES);

			PortletURL portletURL;
			if (plid == LayoutConstants.DEFAULT_PLID) {
				portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
						MoviesPortletKeys.MOVIES, PortletRequest.RENDER_PHASE);
			}
			else {
				portletURL =_movieAssetRendererFactory.getPortletURLFactory().create(liferayPortletRequest, 
						MoviesPortletKeys.MOVIES, plid, PortletRequest.RENDER_PHASE);
			}

			portletURL.setParameter("mvcRenderCommandName", MVCCommandNames.VIEW_MOVIE);
			portletURL.setParameter("movieId", String.valueOf(_movie.getMovieId()));

			String currentUrl = _movieAssetRendererFactory.getPortal().getCurrentURL(liferayPortletRequest);

			portletURL.setParameter("redirect", currentUrl);

			return portletURL.toString();

		}
		catch (PortalException e) {

		}
		catch (SystemException e) {
		}
		return null;
	}

	@Override
	public long getUserId() {

		return _movie.getUserId();
	}

	@Override
	public String getUserName() {

		return _movie.getUserName();
	}

	@Override
	public String getUuid() {

		return _movie.getUuid();
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) throws PortalException {

		return _movieAssetRendererFactory.moviePermissionChecker().contains(permissionChecker, _movie.getGroupId(),
				_movie.getMovieId(), ActionKeys.UPDATE);
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) throws PortalException {

		return _movieAssetRendererFactory.moviePermissionChecker().contains(permissionChecker, _movie.getGroupId(),
			_movie.getMovieId(), ActionKeys.VIEW);
	}

	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {

		request.setAttribute("movie", _movie);

		return super.include(request, response, template);
	}

	private Movie _movie;
	private MovieAssetRendererFactory _movieAssetRendererFactory;
	
	//?
	@Override
	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return _movie.getMovieName();
	}
}
