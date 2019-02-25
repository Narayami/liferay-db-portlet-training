package com.liferay.training.movies.web.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.search.suggest.SuggesterResult.Entry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.movies.exception.MovieValidationException;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.MovieService;
import com.liferay.training.movies.service.MovieServiceUtil;
import com.liferay.training.movies.web.constants.MVCCommandNames;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + MoviesPortletKeys.MOVIES,
			"MVC.command.name=" + MVCCommandNames.ADD_MOVIE,
		},	
		service = MVCActionCommand.class
)
public class AddMovieMVCActionCommand extends BaseMVCActionCommand {
	@Reference
	MovieService movieService;
	
	public static final Log log = LogFactoryUtil.getLog(Movie.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Movie.class.getName(), actionRequest);
		
		String movieName = ParamUtil.getString(actionRequest, "movie");
		String description = ParamUtil.getString(actionRequest, "description");
		int rating = ParamUtil.getInteger(actionRequest, "rating");
		
		
		try {
			
			//MovieServiceUtil.addMovie(themeDisplay.getScopeGroupId(), movieName, description, rating, serviceContext);
			MovieServiceUtil.addMovie(themeDisplay.getScopeGroupId(), movieName, description, rating, serviceContext);
			SessionMessages.add(actionRequest, "movie-addded");
			hideDefaultSuccessMessage(actionRequest);
			
			sendRedirect(actionRequest, actionResponse);
			
		}catch (MovieValidationException e){
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.EDIT_MOVIE);
		}catch (PortalException e){
			log.error(e);
			SessionErrors.add(actionRequest, MVCCommandNames.EDIT_MOVIE);
		}
		
	}
}
