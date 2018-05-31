package org.test.dao.impl;

import org.hibernate.SessionFactory;
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
	
	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory)
	{
	    super.setSessionFactory(sessionFactory);
	}

	public Test_Table getTestData() {
		String hql="from Test_Table a ";
		Test_Table test_Table=(Test_Table)this.getHibernateTemplate().find(hql).get(0);
		return test_Table;
	}

}
