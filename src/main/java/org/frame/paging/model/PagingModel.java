package org.frame.paging.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author shentt
 * @date 2018年7月2日
 * @className PagingModel.java
 * @param 
 * @Description 分页类
 */
public class PagingModel<E> {
	private List<E> list=new ArrayList<E>();//封装数据
	private Integer pageNo;//当前页  
    private Integer pageSize;//每页数量
    private Integer totalNum;//数据总数  
    private Integer totalPage;//总页数
    public PagingModel() {
	}
    /**
     * 
     * @param pageNo 当前页  
     * @param pageSize 每页数量
     * @param totalNum 数据总数  
     * @param list 封装数据
     * @param totalPage 总页数
     */
    public PagingModel(Integer pageNo,Integer pageSize,Integer totalNum,List<E> list,Integer totalPage) {
    	this.pageNo=pageNo;
    	this.pageSize=pageSize;
    	this.totalNum=totalNum;
    	this.list=list;
    	this.totalPage=totalPage;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
		//设置总页数
        setTotalPage((getTotalNum() % pageSize) == 0 ? (getTotalNum() / pageSize)  
                : (getTotalNum() / pageSize + 1)); 
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	// 获取第一页  
    public Integer getFirstPage() {  
        return 1;  
    }  
  
    // 获取最后页  
    public Integer getLastPage() {  
        return totalPage;  
    }  
  
    // 获取前页  
    public Integer getPrePage() {  
        if (pageNo > 1)  
            return pageNo - 1;  
        return 1;  
    }  
  
    // 获取后页  
    public Integer getBackPage() {  
        if (pageNo < totalPage)  
            return pageNo + 1;  
        return totalPage;  
    }  
  
    // 判断'首页'及‘前页’是否可用  
    public String isPreable() {  
        if (pageNo == 1)  
            return "disabled";  
        return "";  
    }  
  
    // 判断'尾页'及‘下页’是否可用  
    public String isBackable() {  
        if (pageNo == totalPage)  
            return "disabled";  
        return "";  
    }  
}
