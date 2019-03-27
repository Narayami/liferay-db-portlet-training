package com.liferay.training.movies.web.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.MovieService;
import com.liferay.training.movies.web.constants.MVCCommandNames;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;
import com.liferay.training.movies.web.model.view.MovieViewModel;

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
	
	MovieViewModel movieViewModel = new MovieViewModel();
	
	public static final Log log = LogFactoryUtil.getLog(Movie.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Movie.class.getName(), actionRequest);
		
		String movieName = ParamUtil.getString(actionRequest, "movie");
		String description = ParamUtil.getString(actionRequest, "description");
		int rating = ParamUtil.getInteger(actionRequest, "rating");
		String authorName = ParamUtil.getString(actionRequest, "author");
		String biography = ParamUtil.getString(actionRequest, "biography");
		
		//MovieLocalServiceUtil.addMovieAndAuthor(themeDisplay.getScopeGroupId(), movieName, description, rating, authorName, biography, serviceContext);
		
		movieViewModel.addMovieAndAuthor(themeDisplay.getScopeGroupId(), movieName, description, rating, 
				authorName, biography, serviceContext);
	}
}
