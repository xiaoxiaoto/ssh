package org.aoto.tools.excel.excel2database.impl;

import java.util.List;
import java.util.Map;

import org.aoto.tools.excel.base.IReadExcel;
import org.aoto.tools.excel.excel2database.IExcel2Database;
import org.aoto.tools.jdbc.business.IJDBCBaseSerives;

public class Excel2Database implements IExcel2Database{
	private IJDBCBaseSerives jdbcBaseSerives;
	private IReadExcel readExcel;

	public String excel2Database(String sql, String excelPath, Integer sheetNumber, Integer firstRow, Integer version) {

		Map<String, Object> Excel = null;
		if (version == 2003) {
			Excel = readExcel.read2003Excel(excelPath, sheetNumber, firstRow);
		} else {
			Excel = readExcel.read2007Excel(excelPath, sheetNumber, firstRow);
		}
		if (Excel != null) {
			List<List<Object>> rows = (List<List<Object>>) Excel.get("DATA");
			for (List<Object> row : rows) {
				if (row != null) {
					jdbcBaseSerives.save(sql, row);
				}
			}
			return "SUCCESS";
		}
		return "FAILURE";
	}

	public IJDBCBaseSerives getJdbcBaseSerives() {
		return jdbcBaseSerives;
	}

	public void setJdbcBaseSerives(IJDBCBaseSerives jdbcBaseSerives) {
		this.jdbcBaseSerives = jdbcBaseSerives;
	}

	public IReadExcel getReadExcel() {
		return readExcel;
	}

	public void setReadExcel(IReadExcel readExcel) {
		this.readExcel = readExcel;
	}

}
