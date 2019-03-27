package com.liferay.training.movies.web.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import com.liferay.training.movies.model.Author;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.AuthorLocalServiceUtil;
import com.liferay.training.movies.service.MovieLocalServiceUtil;
import com.liferay.training.movies.service.MovieService;
import com.liferay.training.movies.web.constants.MVCCommandNames;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;
import com.liferay.training.movies.web.model.view.AuthorViewModel;
import com.liferay.training.movies.web.model.view.MovieViewModel;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + MoviesPortletKeys.MOVIES,
		"MVC.command.name=" + MVCCommandNames.UPDATE_MOVIE,
	},
	service = MVCActionCommand.class
)
public class UpdateMovieMVCActionCommand extends BaseMVCActionCommand {

	private AuthorViewModel authorViewModel = new AuthorViewModel();
	private MovieViewModel movieViewModel = new MovieViewModel();
	
	@Reference
	MovieService movieService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String movieName = actionRequest.getParameter("movieName");
		String description = actionRequest.getParameter("description");
		int rating = ParamUtil.getInteger(actionRequest, "rating");
		String strMovieId = actionRequest.getParameter("movieId");
		long movieId = Long.valueOf(strMovieId);
		
		String authorName = actionRequest.getParameter("authorName");
		String biography = actionRequest.getParameter("biography");
		String strAuthorId = actionRequest.getParameter("authorId");
		long authorId = Long.valueOf(strAuthorId);
		
		//Fetch data from table using pk
		Movie movie = MovieLocalServiceUtil.getMovie(movieId);
		Author author = AuthorLocalServiceUtil.getAuthor(authorId);
		
		//set update data
		movie.setMovieName(movieName);
		movie.setDescription(description);
		movie.setRating(rating);
		
		author.setAuthorName(authorName);
		author.setBiography(biography);
		
		// Update method with changed data
		movieViewModel.updateMovie(movie);
		authorViewModel.updateAuthor(author);
		
		actionResponse.setRenderParameter("jspPage","/view.jsp");
	}
}
