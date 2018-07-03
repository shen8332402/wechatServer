package org.frame.paging.service;
/**
 * 
 * @author shentt
 * @date 2018年7月2日
 * @className PageSqlParser.java
 * @param 
 * @Description 分页工具service
 */
public interface PageSqlParser {
	/**
	 * 
	 * 
	 * @author shentt
	 * @date 2018年7月2日
	 * @param sql 待格式化sql
	 * @param pageSize 每页多少行
	 * @param totalNum 总数据数
	 * @param pageNo 当前页数
	 * @Description
	 */
	public String parsePageSQL(String sql,Integer pageSize,Integer totalNum,Integer pageNo);
}
