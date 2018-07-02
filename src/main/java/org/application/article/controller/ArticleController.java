package org.application.article.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.application.article.pojo.Article;
import org.application.article.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author shentt
 * @date 2018年6月6日
 * @className ArticleController.java
 * @param 
 * @Description 文章controller
 */
@RestController
@Scope("prototype")
@RequestMapping(value="ArticleController")
public class ArticleController {
	@Autowired
	@Qualifier(value="ArticleServiceImpl")
	private ArticleService articleService;
	
	@Resource(name="ArticleServiceImpl")
	private ArticleService articleService1;
	
	@Autowired
	private ArticleService articleService2; 
	
	private Logger logger=LoggerFactory.getLogger(ArticleController.class);
	@PostMapping(value="saveArticle")
	public int saveArticle(Article article){
		article.setArticle_is_use("0");
		article.setIs_del("0");
		article.setArticle_cre_time(new Date());
		return articleService.saveArticle(article);
	}
	@GetMapping(value="delArticleById")
	public int delArticleById(Integer article_id){
		return articleService.delArticleById(article_id);
	}

	public int upArticle(Article article){
		Article article2=articleService.qryArticleById(article.getArticle_id());
		//todo
		return articleService.upArticle(article);
	}
	@GetMapping(value="qryArticle")
	public List<Article> qryArticle(){
		return articleService.qryArticle();
	}
	@GetMapping(value="qryArticleById")
	public Article qryArticleById(Integer article_id){
		return articleService.qryArticleById(article_id);
	}
}
