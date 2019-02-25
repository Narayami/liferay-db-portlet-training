
package com.liferay.training.movies.web.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.SafeConsumer;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.movies.permission.MoviePermissionChecker;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;
import com.liferay.training.movies.web.constants.MVCCommandNames;

import java.util.List;
import java.util.Objects;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class MoviesManagementToolbarDisplayContext {

	public MoviesManagementToolbarDisplayContext(
		LiferayPortletRequest liferayPortletRequest, 
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest request, 
		MoviePermissionChecker assignmentPermissionChecker) {
		
		_moviePermissionChecker = assignmentPermissionChecker;
		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_request = request;
		_currentURLObj = PortletURLUtil.getCurrent(
			liferayPortletRequest, _liferayPortletResponse);

		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
			liferayPortletRequest);
	}

	
	//Returns the creation menu for the toolbar (plus sign on the management toolbar.
	public CreationMenu getCreationMenu() {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);

		// Check if user has permissions to add movies.
		
		if (!_moviePermissionChecker.containsTopLevel(
			themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(),
			"ADD_MOVIE")) {
			
			return null;
		}
		
		// Create the menu.
		
		CreationMenu creationMenu = new CreationMenu();
		
		creationMenu.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(
				_liferayPortletResponse.createRenderURL(),
				"mvcRenderCommandName", MVCCommandNames.EDIT_MOVIE,
				"redirect", _currentURLObj.toString());
			dropdownItem.setLabel(LanguageUtil.get(_request, "ADD-MOVIE"));
		});

		return creationMenu;
	}


	public String getDisplayStyle() {

		String displayStyle = ParamUtil.getString(_request, "displayStyle");

		if (Validator.isNull(displayStyle)) {
			displayStyle = _portalPreferences.getValue(
				MoviesPortletKeys.MOVIES, "movies-display-style",
				"icon");
		}
		else {
			_portalPreferences.setValue(
				MoviesPortletKeys.MOVIES, "movies-display-style",
				displayStyle);

			_request.setAttribute(
				WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
		}

		return displayStyle;
	}

	/**
	 * Returns the filter menu options.
	 * 
	 * @return menu options list
	 */
	public List<DropdownItem> getFilterDropdownItems() {

		return new DropdownItemList() {

			{
				addGroup(dropdownGroupItem -> {
					dropdownGroupItem.setDropdownItems(
						_getOrderByDropdownItems());
					dropdownGroupItem.setLabel(
						LanguageUtil.get(_request, "order-by"));
				});
			}
		};
	}

	/**
	 * Returns the sort order column.
	 * 
	 * @return sort column
	 */
	public String getOrderByCol() {

		return ParamUtil.getString(_request, "orderByCol", "movieName");
	}

	/**
	 * Returns the sort type (ascending / descending).
	 * 
	 * @return sort type
	 */
	public String getOrderByType() {

		return ParamUtil.getString(_request, "orderByType", "desc");
	}

	/**
	 * Returns the action URL for the search.
	 * 
	 * @return search action URL
	 */
	public String getSearchActionURL() {

		PortletURL searchURL = _liferayPortletResponse.createRenderURL();

		searchURL.setProperty(
			"mvcRenderCommandName", MVCCommandNames.VIEW_MOVIE);

		searchURL.setParameter("orderByCol", getOrderByCol());
		searchURL.setParameter("orderByType", getOrderByType());

		return searchURL.toString();
	}

	/**
	 * Returns sorting URL.
	 * 
	 * @return sorting URL
	 * @throws PortletException
	 */
	public PortletURL getSortingURL()
		throws PortletException {

		PortletURL sortingURL = _getCurrentSortingURL();

		sortingURL.setParameter(
			"orderByType",
			Objects.equals(getOrderByType(), "asc") ? "desc" : "asc");

		return sortingURL;
	}

	/**
	 * Returns the view type options (card, list, table).
	 * 
	 * @return list of view types
	 */
	public ViewTypeItemList getViewTypes() {

		// Create portlet URL and set parameters.

		PortletURL portletURL = _liferayPortletResponse.createRenderURL();

		portletURL.setParameter(
			"mvcRenderCommandName", MVCCommandNames.VIEW_MOVIE);

		int delta =
			ParamUtil.getInteger(_request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (delta > 0) {
			portletURL.setParameter("delta", String.valueOf(delta));
		}

		String orderByCol =
			ParamUtil.getString(_request, "orderByCol", "movieName");
		String orderByType =
			ParamUtil.getString(_request, "orderByType", "asc");

		portletURL.setParameter("orderBycol", orderByCol);
		portletURL.setParameter("orderByType", orderByType);

		int cur =
			ParamUtil.getInteger(_request, SearchContainer.DEFAULT_CUR_PARAM);

		if (cur > 0) {
			portletURL.setParameter("cur", String.valueOf(cur));
		}

		return new ViewTypeItemList(portletURL, getDisplayStyle()) {

			{
				addCardViewTypeItem();

				addListViewTypeItem();

				addTableViewTypeItem();
			}

		};
	}

	/**
	 * Returns the current sorting URL.
	 * 
	 * @return current sorting portlet URL
	 * 
	 * @throws PortletException
	 */
	private PortletURL _getCurrentSortingURL()
		throws PortletException {

		PortletURL sortingURL =
			PortletURLUtil.clone(_currentURLObj, _liferayPortletResponse);

		sortingURL.setParameter(
			"mvcRenderCommandName", MVCCommandNames.VIEW_MOVIE);

		// Reset current page.
		
		sortingURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");
		
		return sortingURL;
	}

	/**
	 * Return the option items for the sort column menu.
	 * 
	 * @return options list for the sort column menu
	 */
	private List<DropdownItem> _getOrderByDropdownItems() {

		return new DropdownItemList() {

			{
				add(SafeConsumer.ignore(dropdownItem -> {
					dropdownItem.setActive("movieName".equals(getOrderByCol()));
					dropdownItem.setHref(
						_getCurrentSortingURL(), "orderByCol", "movieName");
					dropdownItem.setLabel(LanguageUtil.get(_request, "movieName"));
				}));

				add(SafeConsumer.ignore(dropdownItem -> {
					dropdownItem.setActive(
						"createDate".equals(getOrderByCol()));
					dropdownItem.setHref(
						_getCurrentSortingURL(), "orderByCol", "createDate");
					dropdownItem.setLabel(
						LanguageUtil.get(_request, "create-date"));
				}));
			}
		};
	}

	private final MoviePermissionChecker _moviePermissionChecker;
	private final PortletURL _currentURLObj;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;
	private final HttpServletRequest _request;
}
