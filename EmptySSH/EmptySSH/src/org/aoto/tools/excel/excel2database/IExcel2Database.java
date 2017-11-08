package org.aoto.tools.excel.excel2database;

public interface IExcel2Database {
	public String excel2Database(String sql, String excelPath, Integer sheetNumber, Integer firstRow, Integer version);

}
