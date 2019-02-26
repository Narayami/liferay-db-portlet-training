package com.liferay.training.movies.web.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.AuthorLocalService;
import com.liferay.training.movies.service.AuthorLocalServiceUtil;
import com.liferay.training.movies.service.MovieLocalServiceUtil;
import com.liferay.training.movies.service.MovieService;
import com.liferay.training.movies.web.constants.MVCCommandNames;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + MoviesPortletKeys.MOVIES,
			"MVC.command.name=" + MVCCommandNames.DELETE_MOVIE,
		},
		service = MVCActionCommand.class
)
public class DeleteMovieActionCommand extends BaseMVCActionCommand {

	@Reference
	MovieService movieService;
	public static final Log log = LogFactoryUtil.getLog(Movie.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String string = actionRequest.getParameter("movieId");
		long movieId = Long.valueOf(string);
		
		
		
		System.out.println("id:" + movieId);
		

		try {

			MovieLocalServiceUtil.deleteMovie(movieId);
			AuthorLocalServiceUtil.deleteAuthor(authorId);

		}
		catch (PortalException e) {
			log.error(e);
		}

		actionResponse.setRenderParameter("jspPage", "/view.jsp");
		
	}
}
