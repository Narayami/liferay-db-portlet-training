package com.liferay.training.movies.rest.service.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyService;
import com.liferay.portal.kernel.service.CompanyServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.service.MovieLocalServiceUtil;

/**
 * @author tmachado
 */
@Component(
		immediate = true, 
		property = { 
				"liferay.auth.verifier=false",
				"liferay.oauth2=false",	
				JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/movies-rest",
				JaxrsWhiteboardConstants.JAX_RS_NAME + "=Movies.Rest" 
		}, 
		service = Application.class)
public class MovieRestApplication extends Application {
	
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Path("/movies")
	@Produces({
		MediaType.APPLICATION_JSON
	})
	public String getMovies() {
		
		Company company;
		List<Movie> movieList = new ArrayList<Movie>();

		try {
			
			company = CompanyServiceUtil.getCompanyById(PortalUtil.getDefaultCompanyId());
			List<Group> groups = GroupLocalServiceUtil.getGroups(company.getCompanyId(), 0, true);
			
			for (Group group : groups) {
				movieList.addAll(MovieLocalServiceUtil.getMoviesByGroupId(group.getGroupId()));
			}
			
			return JSONFactoryUtil.serialize(movieList);
			
		} catch (Exception e){
			e.getStackTrace();
			return "{}";
		}
	}
	
	@GET
	@Path("/movies/{movieid}")
	@Produces({
		MediaType.APPLICATION_JSON
	})
	public String getMovie(@PathParam("movieid") long movieId) {
		
		try {
			return JSONFactoryUtil.serialize(MovieLocalServiceUtil.getMovie(movieId));
		}catch (Exception e) {
			e.printStackTrace();
			return "{}";
		}
	} 
}