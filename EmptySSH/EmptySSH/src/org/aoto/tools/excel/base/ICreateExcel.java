package org.aoto.tools.excel.base;

import java.util.List;

/**
 * 类/接口描述: 通过程序创建Excel2003和Excel2007
 *
 * @author 赵德华
 * @version 1.0
 * 创建时间： 2015年9月15日 下午3:26:11 
 * JDK版本：sun jdk 1.6
 *********************************更新记录******************************
 * 版本：  <版本号>        修改日期：  <日期>        修改人： <修改人姓名>
 * 修改内容：  <修改内容描述>
 **********************************************************************
 */
public interface ICreateExcel {

	/**
	 * 方法描述：创建Excel2003
	 *
	 * @param sheetName ：工作簿名称
	 * @param excelPath ：生成Excel的路径
	 * @param cellTitle：列名称
	 * @param data ：数据
	 */
	public void create2003Excel(String sheetName, String excelPath, List<String> cellTitle, Integer fristRow,
			List<List<Object>> data);

	/**
	 * 方法描述：<描述方法的作用，注意：接口中只描述方法的作用，实现类中要将方法是实现思路描述清楚>
	 *
	 * @param sheetName：工作簿名称
	 * @param excelPath：生成Excel的路径
	 * @param cellTitle：列名称
	 * @param data ：数据
	 */
	public void create2007Excel(String sheetName, String excelPath, List<String> cellTitle, Integer fristRow,
			List<List<Object>> data);
}
