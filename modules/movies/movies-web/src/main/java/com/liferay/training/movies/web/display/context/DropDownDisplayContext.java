package com.liferay.training.movies.web.display.context;

import java.util.ArrayList;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;

public class DropDownDisplayContext {
	private ArrayList<NavigationItem> defaultDropDownItems;
	
	public ArrayList<NavigationItem> getDefaultDropdownItems() {
	
		if (defaultDropDownItems != null) {
			return defaultDropDownItems;
		}
		
		defaultDropDownItems = new ArrayList<>();
		
		for (int i = 0 ; i < 4 ; i++) {
			NavigationItem navigationItem = new NavigationItem();
			
			defaultDropDownItems.add(navigationItem);
			
			if (i == 1) {
		        navigationItem.setDisabled(true);
		      }
		    else if (i == 2) {
		        navigationItem.setActive(true);
		      }
			
			navigationItem.setHref("#" + i);
		    navigationItem.setLabel("Option " + i);
			
		}
		
		return defaultDropDownItems;
		
	}
}
