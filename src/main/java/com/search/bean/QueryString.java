package com.search.bean;

import java.util.List;

public class QueryString {
	private List<String> searchText;
	
	public QueryString(){
		
	}

	public List<String> getSearchText() {
		return searchText;
	}

	public void setSearchText(List<String> searchText) {
		this.searchText = searchText;
	}
	
}
