package org.aoto.tools.excel.base.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.aoto.tools.excel.base.ICreateExcel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.jmx.snmp.Timestamp;

/**
 * 类/接口描述: 通过程序创建Excel2003和Excel2007
 *
 * @author 赵德华
 * @version 1.0
 * 创建时间： 2015年9月15日 下午3:23:41 
 * JDK版本：sun jdk 1.6
 *********************************更新记录******************************
 * 版本：  <版本号>        修改日期：  <日期>        修改人： <修改人姓名>
 * 修改内容：  <修改内容描述>
 **********************************************************************
 */
public class CreateExcel implements ICreateExcel {
	private XSSFWorkbook excelObjectx = null;
	private HSSFWorkbook excelObject = null;
	private XSSFSheet sheetx = null;
	private HSSFSheet sheet = null;
	private FileOutputStream output = null;
	private File excelFile = null;
	private int dataTotal = 0;
	private int cellTotal = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.excel.ICreateExcel#create2003Excel(java.lang.String,
	 * java.lang.String, java.util.List, java.util.List)
	 */
	public void create2003Excel(String sheetName, String excelPath, List<String> cellTitle, Integer fristRow,
			List<List<Object>> data) {
		dataTotal = data.size();
		cellTotal = cellTitle.size();
		if (cellTotal > 0) {
			excelObject = new HSSFWorkbook();
			sheet = excelObject.createSheet(sheetName);
			HSSFRow row1 = sheet.createRow(0);
			for (int i = 0; i < cellTitle.size(); i++) {
				HSSFCell cell = row1.createCell(i);
				cell.setCellValue(cellTitle.get(i));
			}
			if (dataTotal > 0) {
				for (int k = fristRow; k < (dataTotal + fristRow); k++) {
					HSSFRow rows = sheet.createRow(k - 1);
					for (int i = 0; i < cellTotal; i++) {
						HSSFCell cell = rows.createCell(i);
						Object object = data.get(k - fristRow).get(i);
						if (object != null) {
							if (object instanceof String) {
								String str = ((String) object).trim();
								if (str.equals("null")) {
									cell.setCellType(HSSFCell.CELL_TYPE_BLANK);
								} else {
									cell.setCellType(HSSFCell.CELL_TYPE_STRING);
									cell.setCellValue((String) object);
								}
							}
							if (object instanceof Boolean) {
								cell.setCellType(HSSFCell.CELL_TYPE_BOOLEAN);
								cell.setCellValue((boolean) object);
							}
							if (object instanceof Double) {
								cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
								cell.setCellValue((double) object);
							}
							if (object instanceof Float) {
								cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
								cell.setCellValue((Float) object);
							}
							if (object instanceof Long) {
								cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
								cell.setCellValue((Long) object);
							}
							if (object instanceof Integer) {
								cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
								cell.setCellValue((Integer) object);
							}
							if (object instanceof Short) {
								cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
								cell.setCellValue((Short) object);
							}
							if (object instanceof Date) {
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
								String date = fomat.format((Date) object);
								cell.setCellValue(date);
							}
							if (object instanceof Timestamp) {
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
								String date = fomat.format((Timestamp) object);
								cell.setCellValue(date);
							}
						} else {
							cell.setCellType(HSSFCell.CELL_TYPE_BLANK);
						}
					}
				}
			}

			try {
				excelFile = new File(excelPath);
				output = new FileOutputStream(excelFile);
				excelObject.write(output);
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.excel.ICreateExcel#create2007Excel(java.lang.String,
	 * java.lang.String, java.util.List, java.util.List)
	 */
	public void create2007Excel(String sheetName, String excelPath, List<String> cellTitle, Integer fristRow,
			List<List<Object>> data) {
		dataTotal = data.size();
		cellTotal = cellTitle.size();
		if (cellTotal > 0) {
			excelObjectx = new XSSFWorkbook();
			sheetx = excelObjectx.createSheet(sheetName);
			XSSFRow row1 = sheetx.createRow(0);
			for (int i = 0; i < cellTitle.size(); i++) {
				XSSFCell cell = row1.createCell(i);
				cell.setCellValue(cellTitle.get(i));
			}
			if (dataTotal > 0) {
				for (int k = fristRow; k < (dataTotal + fristRow); k++) {
					XSSFRow rows = sheetx.createRow(k - 1);
					for (int i = 0; i < cellTotal; i++) {
						XSSFCell cell = rows.createCell(i);
						Object object = data.get(k - fristRow).get(i);
						if (object != null) {
							if (object instanceof String) {
								String str = ((String) object).trim();
								if (str.equals("null")) {
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								} else {
									cell.setCellType(XSSFCell.CELL_TYPE_STRING);
									cell.setCellValue((String) object);
								}
							}
							if (object instanceof Boolean) {
								cell.setCellType(XSSFCell.CELL_TYPE_BOOLEAN);
								cell.setCellValue((boolean) object);
							}
							if (object instanceof Double) {
								cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
								cell.setCellValue((double) object);
							}
							if (object instanceof Float) {
								cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
								cell.setCellValue((Float) object);
							}
							if (object instanceof Long) {
								cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
								cell.setCellValue((Long) object);
							}
							if (object instanceof Integer) {
								cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
								cell.setCellValue((Integer) object);
							}
							if (object instanceof Short) {
								cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
								cell.setCellValue((Short) object);
							}
							if (object instanceof Date) {
								cell.setCellType(XSSFCell.CELL_TYPE_STRING);
								SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
								String date = fomat.format((Date) object);
								cell.setCellValue(date);
							}
							if (object instanceof Timestamp) {
								cell.setCellType(XSSFCell.CELL_TYPE_STRING);
								SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
								String date = fomat.format((Timestamp) object);
								cell.setCellValue(date);
							}
						} else {
							cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
						}
					}
				}
			}

			try {
				excelFile = new File(excelPath);
				output = new FileOutputStream(excelFile);
				excelObjectx.write(output);
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
