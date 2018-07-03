package org.frame.paging.service.impl;

import org.frame.paging.service.PageSqlParser;
import org.frame.util.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author shentt
 * @date 2018年7月2日
 * @className OracleOrMysqlPageSqlParser.java
 * @param 
 * @Description 实现mysql及oracle分页
 */
public class OracleOrMysqlPageSqlParser implements PageSqlParser{
	
    private static String ROWNUMFIELD = "rn_0192837465";
    private Logger log = LoggerFactory.getLogger(OracleOrMysqlPageSqlParser.class);

	public String parsePageSQL(String sql, Integer pageSize, Integer totalNum, Integer pageNo) {
		String res_sql = "";
	       String flag = PropertiesUtils.getProperties("system-config.properties").getProperty("DATABASE_CONNECTION");
	       if("MySQL".equals(flag)){
	    	   res_sql = parsePageMySQL(sql,pageSize,totalNum,pageNo);
	       }
	       if("ORACLE".equals(flag)){
	    	   res_sql = parsePageORACLE(sql,pageSize,totalNum,pageNo);
	       }
	       return res_sql;
	}
	/**
	 * 
	 * 
	 * @author shentt
	 * @date 2018年7月2日
	 * @param sql 待格式化sql
	 * @param pageSize 每页多少数据
	 * @param totalNum 总数据数
	 * @param pageNo 当前页数
	 * @Description
	 */
	private String parsePageMySQL(String sql, int pageSize, int totalNum, int pageNo){
        int iBegin = 0;
        int iEnd = 0;
        int pageCount = 0;//算出来的总页数
        if(pageSize > 0 && totalNum > pageSize)
        {
            if(totalNum % pageSize == 0)
                pageCount = totalNum / pageSize;
            else
                pageCount = totalNum / pageSize + 1;
            if(pageNo < 1)
                pageNo = 1;
            if(pageNo > pageCount)
                pageNo = pageCount;
            iBegin = (pageNo - 1) * pageSize;
            iEnd = iBegin + pageSize;
            StringBuffer tmpBuffer = new StringBuffer();
            tmpBuffer.append(sql);
            if(totalNum >=pageSize)
            {
                tmpBuffer.append(" LIMIT ");
                tmpBuffer.append(Long.toString(iBegin) +",");
                tmpBuffer.append(pageSize+"");
            }
            sql = tmpBuffer.toString();
            log.debug(sql);
        }
        System.out.println("OracleOrMysqlPageSqlParser-----"+sql);
        return sql;
	}
	/**
	 * @author shentt
	 * @date 2018年7月2日
	 * @param sql 待格式化sql
	 * @param pageSize 每页多少数据
	 * @param totalNum 总数据数
	 * @param pageNo 当前页数
	 * @Description
	 */
	public String parsePageORACLE(String sql, int pageSize, int totalNum, int pageNo){
        int iBegin = 0;
        int iEnd = 0;
        int pageCount = 0;
        if(pageSize > 0 && totalNum > pageSize)
        {
            if(totalNum % pageSize == 0)
                pageCount = totalNum / pageSize;
            else
                pageCount = totalNum / pageSize + 1;
            if(pageNo < 1)
                pageNo = 1;
            if(pageNo > pageCount)
                pageNo = pageCount;
            iBegin = (pageNo - 1) * pageSize + 1;
            iEnd = iBegin + pageSize;
            StringBuffer tmpBuffer = new StringBuffer();
            tmpBuffer.append("SELECT * FROM (SELECT originTable.*, ROWNUM ");
            tmpBuffer.append(ROWNUMFIELD);
            tmpBuffer.append(" FROM (");
            tmpBuffer.append(sql);
            tmpBuffer.append(")");
            tmpBuffer.append(" originTable ");
            if(iEnd <= totalNum)
            {
                tmpBuffer.append(" WHERE ROWNUM<");
                tmpBuffer.append(Long.toString(iEnd));
            }
            tmpBuffer.append(") WHERE ");
            tmpBuffer.append(ROWNUMFIELD);
            tmpBuffer.append(">=");
            tmpBuffer.append(Long.toString(iBegin));
            if(iEnd <= totalNum)
            {
                tmpBuffer.append(" and ");
                tmpBuffer.append(ROWNUMFIELD);
                tmpBuffer.append("<");
                tmpBuffer.append(Long.toString(iEnd));
            }
            sql = tmpBuffer.toString();
            log.debug(sql);
        }
        System.out.println("OraclePagedSqlParser-----"+sql);
        return sql;
	}
}
