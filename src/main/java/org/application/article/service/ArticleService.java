package org.application.article.service;

import java.util.List;

import org.application.article.pojo.Article;
/**
 * @author shentt
 * @date 2018年6月6日
 * @className ArticleService.java
 * @param 
 * @Description 文章service接口
 */
public interface ArticleService {
	public int saveArticle(Article article);
	public int delArticleById(Integer article_id);
	public int upArticle(Article article);
	public List<Article> qryArticle();
	public Article qryArticleById(Integer article_id);
}
