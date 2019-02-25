
package com.liferay.training.movies.web.portlet.template;

import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.portletdisplaytemplate.PortletDisplayTemplateManager;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.training.movies.model.Movie;
import com.liferay.training.movies.web.constants.MoviesPortletKeys;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + MoviesPortletKeys.MOVIES
	},
	service = TemplateHandler.class
)
public class MoviesPortletDisplayTemplateHandler extends BasePortletDisplayTemplateHandler {

	@Override
	public String getClassName() {

		return Movie.class.getName();
	}

	@Override
	public String getName(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return resourceBundle.getString("application-display-template-type");
	}

	@Override
	public String getResourceName() {

		return MoviesPortletKeys.MOVIES;
	}

	@Override
	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
		long classPK, String language, Locale locale)
		throws Exception {

		Map<String, TemplateVariableGroup> templateVariableGroups =
			super.getTemplateVariableGroups(classPK, language, locale);

		TemplateVariableGroup templateVariableGroup =
			templateVariableGroups.get("fields");

		templateVariableGroup.empty();

		String collectionLabel = "movies";
		String collectionName = PortletDisplayTemplateManager.ENTRIES;
		Class<List> collectionClazz = List.class;

		String itemLabel = "movie";
		Class<Movie> itemClazz = Movie.class;
		String itemName = "currentMovie";
		String itemAccessor = "getMovieName()";

		templateVariableGroup.addCollectionVariable(
			collectionLabel, collectionClazz, collectionName, itemLabel,
			itemClazz, itemName, itemAccessor);

		return templateVariableGroups;
	}
	
	@Override
	protected String getTemplatesConfigPath() {
		return "com/liferay/training/movies/portlet/template/portlet-display-templates.xml";
		
	}
	
	@Reference
	private Portal _portal;
}
