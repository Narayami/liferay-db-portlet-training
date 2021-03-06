package com.liferay.training.movies.web.portlet.action;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import com.liferay.training.movies.web.constants.MVCCommandNames;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;


@Component(
	immediate=true,
	property = {
		"javax.portlet.name=" + MoviesPortletKeys.MOVIES,
		"MVC.command.name=" + MVCCommandNames.VIEW_MOVIE,
	},
	service = MVCRenderCommand.class
)
public class ViewMoviesMVCRenderCommand implements MVCRenderCommand {
		
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {  
				
		orderColumnsByAscDesc(renderRequest, renderResponse);
		
		return "/view_test.jsp";
		
	}

	private void orderColumnsByAscDesc(RenderRequest renderRequest, RenderResponse renderResponse) {
		
		//toggle asc/desc logic
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol"); 
		String orderByType = ParamUtil.getString(renderRequest, "orderByType"); 
		
		if(orderByCol == null || orderByCol.equals("") || orderByCol.isEmpty()) { 
		   orderByCol="movieName"; 	
		   renderRequest.setAttribute("orderByCol", orderByCol);
		}
		
		if(orderByType == null || orderByType.equals("") || orderByType.isEmpty()) { 
		   orderByType = "asc";         
		   renderRequest.setAttribute("orderByType", orderByType); 
		}
		
		//Logic for toggle asc and desc on rendering the page 
		if(orderByType.equals("desc")){     
		   orderByType = "desc";
		} 
		else {
		   orderByType = "asc";
		}
	}
}
