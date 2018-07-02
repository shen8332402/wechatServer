package org.application.article.pojo;

import java.util.Date;
/**
 * 
 * 
 * @author shentt
 * @date 2018年6月6日
 * @className Artcle.java
 * @param 
 * @Description 文章pojo
 */
public class Article {
	private Integer article_id;//文章id
	private String article_content;//文章内容
	private String article_title;//文章标题
	private String article_author;//文章作者
	private Integer article_creator;//文章创建者
	private Date article_cre_time;//文章创建时间
	private String article_is_use;//文章是否通过发表(1通过0未通过)
	private String article_abstract;//文章摘要
	private String article_cover_pic;//文章封面图片
	private String article_content_pic;//文章内容图片
	private Integer article_alter_num;//文章修改次数
	private Integer article_look_num;//文章查看次数
	private String is_del;//文章是否删除(0未删除1已删除)
	private Date update_time;//文章修改时间
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_author() {
		return article_author;
	}
	public void setArticle_author(String article_author) {
		this.article_author = article_author;
	}
	public Integer getArticle_creator() {
		return article_creator;
	}
	public void setArticle_creator(Integer article_creator) {
		this.article_creator = article_creator;
	}
	public Date getArticle_cre_time() {
		return article_cre_time;
	}
	public void setArticle_cre_time(Date article_cre_time) {
		this.article_cre_time = article_cre_time;
	}
	public String getArticle_is_use() {
		return article_is_use;
	}
	public void setArticle_is_use(String article_is_use) {
		this.article_is_use = article_is_use;
	}
	public String getArticle_abstract() {
		return article_abstract;
	}
	public void setArticle_abstract(String article_abstract) {
		this.article_abstract = article_abstract;
	}
	public String getArticle_cover_pic() {
		return article_cover_pic;
	}
	public void setArticle_cover_pic(String article_cover_pic) {
		this.article_cover_pic = article_cover_pic;
	}
	public String getArticle_content_pic() {
		return article_content_pic;
	}
	public void setArticle_content_pic(String article_content_pic) {
		this.article_content_pic = article_content_pic;
	}
	public Integer getArticle_alter_num() {
		return article_alter_num;
	}
	public void setArticle_alter_num(Integer article_alter_num) {
		this.article_alter_num = article_alter_num;
	}
	public Integer getArticle_look_num() {
		return article_look_num;
	}
	public void setArticle_look_num(Integer article_look_num) {
		this.article_look_num = article_look_num;
	}
	public String getIs_del() {
		return is_del;
	}
	public void setIs_del(String is_del) {
		this.is_del = is_del;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
}
