package org.aoto.tools.excel.base;

import java.util.Map;

/**
 * 类/接口描述: 读取Excel2003和Excel2007
 *
 * @author 赵德华
 * @version 1.0
 * 创建时间： 2015年9月15日 下午3:32:07 
 * JDK版本：sun jdk 1.6
 *********************************更新记录******************************
 * 版本：  <版本号>        修改日期：  <日期>        修改人： <修改人姓名>
 * 修改内容：  <修改内容描述>
 **********************************************************************
 */
public interface IReadExcel {

	/**
	 * 方法描述：读取Excel2003
	 *
	 * @param excelPath：Excel所在路径
	 * @param sheetNumber：读取工作簿的索引
	 * @return Map<String,Object>
	 */
	public Map<String, Object> read2003Excel(String excelPath, Integer sheetNumber, Integer firstRow);

	/**
	 * 方法描述：读取Excel2003中指定的行
	 *
	 * @param excelPath：Excel所在路径
	 * @param sheetNumber：读取工作簿的索引
	 * @param startRow：开始行
	 * @param endRow：结束行
	 * @return Map<String,Object>
	 */
	public Map<String, Object> read2003Excel(String excelPath, Integer sheetNumber, Integer startRow, Integer endRow);

	/**
	 * 方法描述：读取Excel2007
	 *
	 * @param excelPath：Excel所在路径
	 * @param sheetNumber：读取工作簿的索引
	 * @return Map<String,Object>
	 */
	public Map<String, Object> read2007Excel(String excelPath, Integer sheetNumber, Integer firstRow);

	/**
	 * 方法描述：读取Excel2007
	 *
	 * @param excelPath：Excel所在路径
	 * @param sheetNumber：读取工作簿的索引
	 * @param startRow：开始行
	 * @param endRow：结束行
	 * @return Map<String,Object>
	 */
	public Map<String, Object> read2007Excel(String excelPath, Integer sheetNumber, Integer startRow, Integer endRow);

}
