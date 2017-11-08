package org.aoto.tools.excel.database2excel;


public interface IDatabase2Excel {
	public String database2Excel(String sql, String sheetName, String excelPath, Integer firstRow, Integer version);

}
