package com.search.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.search.bean.QueryString;
import com.search.service.SearchService;

@RestController
@RequestMapping("/counter-api")
public class SearchController {
	private static Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping(method=RequestMethod.POST,value="/search")
	public Map getCount(@RequestBody QueryString strings){
		logger.info("/search request called");
		Map<String, List> countResult = new HashMap<String, List>();
		countResult.put("counts", searchService.getWordCount(strings.getSearchText()));
		logger.info("/search request completed on counter-api");
		return countResult ;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/top/{count}")
	public String getTopNCount(@PathVariable int count, HttpServletResponse response){
		logger.info("/search request called on counter-api");
		response.setContentType("text/csv");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                "CounterTopNResult.txt");
        response.setHeader(headerKey, headerValue);
		logger.info("/search request completed on counter-api");
		return searchService.getTopNCount(count);
	}
	
	public SearchService getCounterService() {
		return searchService;
	}

	public void setCounterService(SearchService counterService) {
		this.searchService = counterService;
	}

}
