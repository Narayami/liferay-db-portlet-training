package com.liferay.training.movies.web.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.MovieLocalServiceUtil;
import com.liferay.training.movies.service.MovieService;
import com.liferay.training.movies.web.constants.MVCCommandNames;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + MoviesPortletKeys.MOVIES,
			"MVC.command.name=" + MVCCommandNames.UPDATE_MOVIE,
		},
		service = MVCActionCommand.class
	)
public class UpdateMovieMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	MovieService movieService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String movieName = actionRequest.getParameter("movieName");
		String description = actionRequest.getParameter("description");
		int rating = ParamUtil.getInteger(actionRequest, "rating");
		String strMovieId = actionRequest.getParameter("movieId");
		
		long movieId = Long.valueOf(strMovieId);
		 
		//Fetch data from table using pk
		Movie movie = MovieLocalServiceUtil.getMovie(movieId);
		 
		//set update data
		movie.setMovieName(movieName);
		movie.setDescription(description);
		movie.setRating(rating);
		
		// Update method with change data
		MovieLocalServiceUtil.updateMovie(movie);
		
		//Redirect to Search container with update entry
		actionResponse.setRenderParameter("jspPage","/view.jsp");
	}
}
