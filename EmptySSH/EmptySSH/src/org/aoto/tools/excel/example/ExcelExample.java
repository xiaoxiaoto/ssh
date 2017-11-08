package org.aoto.tools.excel.example;

import javax.annotation.Resource;

import org.aoto.tools.excel.database2excel.impl.Database2Excel;
import org.aoto.tools.excel.excel2database.impl.Excel2Database;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/excel")
public class ExcelExample {
	@Resource(name = "database2Excel")
	private Database2Excel database2Excel;
	
	@Resource(name = "excel2Database")
	private Excel2Database excel2Database;
	
	@RequestMapping(value = "/exportToExcel")
	public void exportToExcel() {
		String sql = "select eventid,modelname,modelid from DRAWLINE";
		String sheetName = "¹¤×÷²¾";
		String excelPath = "C:/location.xls";
		Integer firstRow = 2;
		Integer version = 2003;
		String rs = database2Excel.database2Excel(sql, sheetName, excelPath, firstRow, version);
		System.out.println(rs);
	}
	
	@RequestMapping(value = "/importToDataBase")
	public void importToDatabase() {

		String sql = "insert into t_tree(id,text,state,tid) values(?,?,?,?)";
		String excelPath = "C:/tt.xlsx";
		Integer sheetNumber = 0;
		Integer firstRow = 2;
		Integer version = 2007;
		String rs = excel2Database.excel2Database(sql, excelPath, sheetNumber, firstRow, version);
		System.out.println(rs);
	}
}
