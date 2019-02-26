package com.liferay.training.movies.web.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.MovieLocalServiceUtil;
import com.liferay.training.movies.service.MovieService;
import com.liferay.training.movies.web.constants.MVCCommandNames;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;
import com.liferay.training.movies.web.portlet.moviesPortlet;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + MoviesPortletKeys.MOVIES,
			"MVC.command.name=" + MVCCommandNames.EDIT_MOVIE,
		},
		service = MVCActionCommand.class
)
public class EditMovieMVCActionRequest extends BaseMVCActionCommand {
	@Reference
	MovieService movieService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String strMovieId = actionRequest.getParameter("movieId");
        long movieId = Long.valueOf(strMovieId);
         System.out.print("ENTROU NO EDIT");
        //Retriev table data using Primary key
        
        Movie movie = MovieLocalServiceUtil.getMovie(movieId);
                                    
//Set Attribute which has all values of specified pk.
        actionRequest.setAttribute("edit", movie);

// Redirect to Jsp page which has Update form.
        actionResponse.setRenderParameter("jspPage","/edit.jsp");
                                    
	}	
}