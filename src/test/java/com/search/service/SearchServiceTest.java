package com.search.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.search.service.SearchService;

@RunWith(SpringJUnit4ClassRunner.class)
public class SearchServiceTest {
	protected Logger logger = LoggerFactory.getLogger(SearchServiceTest.class);
	private SearchService searchService = new SearchService();
	@Test
	public void testGetCount(){
		List<String> inputList = new ArrayList();
		inputList.add("Lorem");
		inputList.add("Sed");
		inputList.add("Donec");
		
		assertNotNull(searchService.getWordCount(inputList));
		assertTrue(searchService.getWordCount(inputList).toString().equals("[{Lorem=8}, {Sed=16}, {Donec=8}]"));
	}
	
	@Test
	public void testGetNCount(){
		assertNotNull(searchService.getTopNCount(5));
	}
}