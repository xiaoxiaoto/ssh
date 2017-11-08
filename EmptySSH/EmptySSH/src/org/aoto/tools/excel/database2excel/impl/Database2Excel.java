package org.aoto.tools.excel.database2excel.impl;

import java.util.ArrayList;
import java.util.List;

import org.aoto.tools.excel.base.ICreateExcel;
import org.aoto.tools.excel.database2excel.IDatabase2Excel;
import org.aoto.tools.jdbc.business.IJDBCBaseSerives;
import org.aoto.tools.jdbc.persistence.dao.impl.ListRowMapper;
import org.aoto.tools.jdbc.persistence.dao.impl.TitleRowMapper;

public class Database2Excel implements IDatabase2Excel {

	private IJDBCBaseSerives jdbcBaseSerives;

	private ICreateExcel createExcel;

	public String database2Excel(String sql, String sheetName, String excelPath, Integer firstRow, Integer version) {

		List<Object> titile = jdbcBaseSerives.queryTitle(sql, new TitleRowMapper());
		List<String> titles = new ArrayList<>();
		for (Object o : titile) {
			if (o != null) {
				titles.add(o.toString());
			}
		}
		List<Object> row = jdbcBaseSerives.queryAll(sql, new ListRowMapper());
		List<List<Object>> rows = new ArrayList<>();
		for (Object o : row) {
			if (o != null) {
				rows.add((List<Object>) (o));
			}
		}
		if (version == 2003) {
			createExcel.create2003Excel(sheetName, excelPath, titles, firstRow, rows);
		} else {
			createExcel.create2007Excel(sheetName, excelPath, titles, firstRow, rows);
		}
		return "SUCCESS";
	}

	public IJDBCBaseSerives getJdbcBaseSerives() {
		return jdbcBaseSerives;
	}

	public void setJdbcBaseSerives(IJDBCBaseSerives jdbcBaseSerives) {
		this.jdbcBaseSerives = jdbcBaseSerives;
	}

	public ICreateExcel getCreateExcel() {
		return createExcel;
	}

	public void setCreateExcel(ICreateExcel createExcel) {
		this.createExcel = createExcel;
	}

}
