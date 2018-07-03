package org.application.article.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.application.article.dao.ArticleDao;
import org.application.article.pojo.Article;
import org.frame.paging.model.PagingModel;
import org.frame.paging.service.PageSqlParser;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.test.dao.impl.TestDaoImpl;

/**
 * 
 * @author shentt
 * @date 2018年6月6日
 * @className ArticleDaoImpl.java
 * @param 
 * @Description 文章dao实现
 */
@Repository(value="ArticleDaoImpl")
@Transactional
public class ArticleDaoImpl extends HibernateDaoSupport implements ArticleDao{

	@Autowired
	@Qualifier(value="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier(value="pageSqlParserImpl")
	private PageSqlParser pageSqlParser;
	
	private Logger logger=LoggerFactory.getLogger(TestDaoImpl.class);
	
	@Autowired
	public void setSession(SessionFactory sessionFactory)
	{
	    super.setSessionFactory(sessionFactory);
	}
	
	public int saveArticle(Article article) {
		int flag=0;
		try {
			this.getHibernateTemplate().save(article);
			flag=1;
			logger.info("新增文章成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("操作失败");
		}
		return flag;
	}

	public int delArticleById(Integer article_id) {
		String sql="update ARTICLE set IS_DEL ='1' where ARTICLE_ID ='"+article_id+"'";
		int flag=0;
		try {
			flag=jdbcTemplate.update(sql);
			if (flag==1) {
				logger.info("删除文章成功");
			} else {
				logger.info("删除文章失败");
			}
		} catch (Exception e) {
			logger.error("操作失败");
		}
		return flag;
	}

	public int upArticle(Article article) {
		int flag=0;
		try {
			this.getHibernateTemplate().update(article);
			flag=1;
			logger.info("修改文章成功");
		} catch (Exception e) {
			logger.error("操作失败");
		}
		return flag;
	}

	public PagingModel<Map<String, Object>> qryArticle(Map<String,  String> para) {
		
		PagingModel pagingModel=null;
		//每页数量
		String pageSize1 = para.get("pageSize");
		Integer pageSize=0;
		if (pageSize1 != null && pageSize1.length() > 0) {
			pageSize = Integer.valueOf(pageSize1);
		}
		// 当前页数
		Integer pageNo = 1;
		String pageNo1 = para.get("start");
		if (pageNo1 != null && pageNo1.length() > 0) {
			pageNo = Integer.valueOf(pageNo1) / pageSize + 1;
		}
		// 总数
		String sqlCount = "select count(1) from ARTICLE ";//+ qryListWhere(para);
		logger.info(sqlCount);
		int Total = jdbcTemplate.queryForObject(sqlCount, Integer.class);
		if(Total == 0)
			return new PagingModel();
		String sqlData="select * from ARTICLE";
		String pageSql=pageSqlParser.parsePageSQL(sqlData, pageSize, Total, pageNo);
		List<Map<String, Object>> dataList=jdbcTemplate.queryForList(pageSql);
		Integer totalPage=(Total%pageSize==0)?(Total%pageSize):(Total%pageSize+1);
		pagingModel=new PagingModel<Map<String, Object>>(pageNo, pageSize, Total, dataList,totalPage);
		logger.info("-------------"+pageSql);
		return pagingModel;
	}

	public Article qryArticleById(Integer article_id) {
		Article article=new Article();
		String hql="from Article a where a.IS_DEL='0' and a.ARTICLE_ID=?";
		try {
			article=(Article)this.getHibernateTemplate().find(hql, article_id).get(0);
			logger.info("通过id查询文章成功");
		} catch (Exception e) {
			logger.error("操作失败");
		}
		return article;
	}
	
}
