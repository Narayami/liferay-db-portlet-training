package com.liferay.training.movies.web.portlet.action;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.transaction.NewTransactionLifecycleListener;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.permission.MoviePermissionChecker;
import com.liferay.training.movies.service.MovieService;
import com.liferay.training.movies.web.constants.MVCCommandNames;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;
import com.liferay.training.movies.web.model.view.MovieViewModel;
import com.liferay.training.movies.web.portlet.moviesPortlet;

@Component(
		immediate=true,
		property = {
			"javax.portlet.name=" + MoviesPortletKeys.MOVIES,
			"MVC.command.name=" + MVCCommandNames.VIEW_MOVIE,
		},
		service = MVCRenderCommand.class
)
public class ViewMoviesMVCRenderCommand implements MVCRenderCommand {
	
	private MovieViewModel movieViewModel = new MovieViewModel();
	
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {    
		
		int totalMovies = movieViewModel.getMoviesCount();
		List<Movie> movies = movieViewModel.getMoviesAndAuthors(0, totalMovies);
		renderRequest.setAttribute("moviesAndAuthors", movies);
		
		return "/view_test.jsp";
	}
}
