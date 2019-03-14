package com.liferay.training.movies.web.model.view;

import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.training.movies.model.Author;
import com.liferay.training.movies.service.AuthorLocalServiceUtil;

public class AuthorViewModel {
	
	private String authorName;
	private String biography;
	
	public void updateAuthor(Author author) {
		AuthorLocalServiceUtil.updateAuthor(author);
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getBiography() {
		return biography;
	}
	
	public void setBiography(String biography) {
		this.biography = biography;
	}
}
