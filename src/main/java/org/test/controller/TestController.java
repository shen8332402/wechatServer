package org.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("getTest")
	public Test_Table getTest(){
		return testService.getTestData();
	}
}
