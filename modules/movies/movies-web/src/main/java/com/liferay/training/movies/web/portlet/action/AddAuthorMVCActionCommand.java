package com.liferay.training.movies.web.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.movies.model.Author;
import com.liferay.training.movies.web.constants.MVCCommandNames;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + MoviesPortletKeys.MOVIES,
			"MVC.command.name=" + MVCCommandNames.ADD_AUTHOR,
		},
		service = MVCActionCommand.class
)
public class AddAuthorMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Author.class.getName(), actionRequest);
		
		
		
	}


}
