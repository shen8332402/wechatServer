package org.test.controller;

import java.util.List;

import javax.annotation.Resource;

import org.application.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.pojo.Test_Table;
import org.test.service.TestService;

@RestController
@Scope("prototype")
@RequestMapping("/test")
public class TestController {
	@Autowired
	@Qualifier(value="TestServiceImpl")
	private TestService testService;
	
	@Autowired
	private  ArticleService articleService;
	
	@Resource(name="TestServiceImpl")
	private TestService test_Table;
	
	@RequestMapping("getTest")
	public List<Test_Table> getTest(){
		return testService.getTestData();
	}
}
