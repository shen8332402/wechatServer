package org.application.article.dao;

import java.util.List;
import java.util.Map;

import org.application.article.pojo.Article;
import org.frame.paging.model.PagingModel;

/**
 * 
 * @author shentt
 * @date 2018年6月6日
 * @className ArticleDao.java
 * @param 
 * @Description 文章dao接口
 */
public interface ArticleDao {
	public int saveArticle(Article article);
	public int delArticleById(Integer article_id);
	public int upArticle(Article article);
	public PagingModel<Map<String, Object>> qryArticle(Map<String,  String> para);
	public Article qryArticleById(Integer article_id);
}
