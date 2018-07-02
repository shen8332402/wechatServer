package org.application.article.service.impl;

import java.util.List;

import org.application.article.dao.ArticleDao;
import org.application.article.pojo.Article;
import org.application.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 
 * @author shentt
 * @date 2018年6月6日
 * @className ArticleServiceImpl.java
 * @param 
 * @Description 文章service实现
 */
@Service(value="ArticleServiceImpl")
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	@Qualifier(value="ArticleDaoImpl")
	private ArticleDao articleDao;
	
	public int saveArticle(Article article) {
		return articleDao.saveArticle(article);
	}

	public int delArticleById(Integer article_id) {
		return articleDao.delArticleById(article_id);
	}

	public int upArticle(Article article) {
		return articleDao.upArticle(article);
	}

	public List<Article> qryArticle() {
		return articleDao.qryArticle();
	}

	public Article qryArticleById(Integer article_id) {
		return articleDao.qryArticleById(article_id);
	}

}
