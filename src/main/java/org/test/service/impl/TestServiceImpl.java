package org.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.test.dao.TestDao;
import org.test.pojo.Test_Table;
import org.test.service.TestService;

@Service(value="TestServiceImpl")
public class TestServiceImpl implements TestService {

	@Autowired
	@Qualifier(value="TestDaoImpl")
	private TestDao testDao;
	public Test_Table getTestData() {
		return testDao.getTestData();
	}

}
