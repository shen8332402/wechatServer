package org.frame.officeutil;

import java.io.Serializable;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;

/**
 * 
 * @author shentt
 * @date 2018年4月19日
 * @className ExcelBean.java
 * @param 
 * @Description excel数据的封装
 */
public class ExcelBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String headTextName; //列头（标题）名  
    private String propertyName; //对应字段名  
    private Integer cols; //合并单元格数  
    private XSSFCellStyle cellStyle;  
    public ExcelBean(){  
    }  
    public ExcelBean(String headTextName, String propertyName){  
        this.headTextName = headTextName;  
        this.propertyName = propertyName;  
    }  
    public ExcelBean(String headTextName, String propertyName, Integer cols) {  
        super();  
        this.headTextName = headTextName;  
        this.propertyName = propertyName;  
        this.cols = cols;  
    }
	public String getHeadTextName() {
		return headTextName;
	}
	public void setHeadTextName(String headTextName) {
		this.headTextName = headTextName;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public Integer getCols() {
		return cols;
	}
	public void setCols(Integer cols) {
		this.cols = cols;
	}
	public XSSFCellStyle getCellStyle() {
		return cellStyle;
	}
	public void setCellStyle(XSSFCellStyle cellStyle) {
		this.cellStyle = cellStyle;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}  
    
}
