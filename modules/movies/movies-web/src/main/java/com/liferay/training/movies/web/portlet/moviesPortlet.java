package com.liferay.training.movies.web.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;

/**
 * @author tmachado
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.movies",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MoviesPortletKeys.MOVIES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class moviesPortlet extends MVCPortlet {
	
}