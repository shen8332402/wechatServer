package org.application.article.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.application.article.dao.ArticleDao;
import org.application.article.pojo.Article;
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

	public List<Article> qryArticle() {
		String hql="from Article a where a.is_del=? and a.article_is_use=? ";
		List<Article> articles=new ArrayList<Article>();
		try {
			articles=(List<Article>) this.getHibernateTemplate().find(hql,"0","1");
			logger.info("查询文章列表成功");
		} catch (Exception e) {
			logger.error("操作失败");
		}
		return articles;
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
