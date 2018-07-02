package org.test.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Entity;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.test.dao.TestDao;
import org.test.pojo.Test_Table;

@Repository(value="TestDaoImpl")
public class TestDaoImpl extends HibernateDaoSupport implements TestDao {

	@Autowired
	@Qualifier(value="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	private Logger logger=LoggerFactory.getLogger(TestDaoImpl.class);
	
	@Autowired
	public void setSession(SessionFactory sessionFactory)
	{
	    super.setSessionFactory(sessionFactory);
	}

	public List<Test_Table> getTestData() {
		List<Test_Table> list=new ArrayList<Test_Table>();
		String hql="from Test_Table a ";
		list=(List<Test_Table>) this.getHibernateTemplate().find(hql);
		logger.info("/testDaoImpl","查询test信息成功");
		return list;
	}

}
