package org.aoto.tools.excel.base.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.aoto.tools.excel.base.IReadExcel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 类/接口描述: 读取Excel2003和Excel2007
 *
 * @author 赵德华
 * @version 1.0
 * 创建时间： 2015年9月15日 下午3:30:14 
 * JDK版本：sun jdk 1.6
 *********************************更新记录******************************
 * 版本：  <版本号>        修改日期：  <日期>        修改人： <修改人姓名>
 * 修改内容：  <修改内容描述>
 **********************************************************************
 */
public class ReadExcel implements IReadExcel {
	private XSSFWorkbook excelObjectx = null;
	private HSSFWorkbook excelObject = null;
	private XSSFSheet sheetx = null;
	private HSSFSheet sheet = null;
	private FileInputStream input = null;
	private File excelFile = null;
	private int dataTotal = 0;
	private int cellTotal = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.excel.IReadExcel#read2003Excel(java.lang.String, int)
	 */
	public Map<String, Object> read2003Excel(String excelPath, Integer sheetNumber, Integer firstRow) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> excelTitle = new ArrayList<>();
		List<List<Object>> data = new ArrayList<>();
		excelFile = new File(excelPath);
		try {
			input = new FileInputStream(excelFile);
			excelObject = new HSSFWorkbook(input);
			sheet = excelObject.getSheetAt(sheetNumber);
			dataTotal = sheet.getPhysicalNumberOfRows();
			if (dataTotal > 0) {
				HSSFRow row1 = sheet.getRow(0);
				cellTotal = row1.getPhysicalNumberOfCells();
				if (cellTotal > 0) {
					for (int i = 0; i < cellTotal; i++) {
						excelTitle.add(row1.getCell(i).toString());
					}
					result.put("CELLTITLE", excelTitle);
				}
				if (dataTotal > firstRow) {
					for (int k = firstRow; k <= (dataTotal + firstRow); k++) {
						HSSFRow row = sheet.getRow(k - 1);
						if (row != null) {
							List<Object> cellData = new ArrayList<>();
							for (int j = 0; j < cellTotal; j++) {
								HSSFCell cell = row.getCell(j);
								if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
									cellData.add(cell.getBooleanCellValue());
								}
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									Pattern pattern = Pattern.compile("[0-9]{4}[年|\\-|/][0-9]{1,2}[月|\\-|/][0-9]{1,2}");
									Matcher matcher = pattern.matcher(cell.getStringCellValue());
									if (matcher.find()) {
										SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
										try {
											Date date = format.parse(cell.getStringCellValue());
											cellData.add(date);
										} catch (ParseException e) {
											e.printStackTrace();
										}
									} else {
										cellData.add(cell.getStringCellValue());
									}
								}
								if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									cellData.add("");
								}
								if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									cellData.add(cell.getNumericCellValue());
								}
							}
							data.add(cellData);
						}
					}
				}
				result.put("DATA", data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.excel.IReadExcel#read2003Excel(java.lang.String, int, int,
	 * int)
	 */
	public Map<String, Object> read2003Excel(String excelPath, Integer sheetNumber, Integer startRow, Integer endRow) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> excelTitle = new ArrayList<>();
		List<List<Object>> data = new ArrayList<>();
		excelFile = new File(excelPath);
		try {
			input = new FileInputStream(excelFile);
			excelObject = new HSSFWorkbook(input);
			sheet = excelObject.getSheetAt(sheetNumber);
			dataTotal = endRow - startRow;
			if (dataTotal > 0) {
				HSSFRow row1 = sheet.getRow(0);
				cellTotal = row1.getPhysicalNumberOfCells();
				if (cellTotal > 0) {
					for (int i = 0; i < cellTotal; i++) {
						excelTitle.add(i, row1.getCell(i).toString());
					}
					result.put("CELLTITLE", excelTitle);
					for (int k = startRow; k < endRow; k++) {
						HSSFRow row = sheet.getRow(k - 1);
						if (row != null) {
							List<Object> cellData = new ArrayList<>();
							for (int j = 0; j < cellTotal; j++) {
								HSSFCell cell = row.getCell(j);
								if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
									cellData.add(j, cell.getBooleanCellValue());
								}
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									Pattern pattern = Pattern.compile("[0-9]{4}[年|\\-|/][0-9]{1,2}[月|\\-|/][0-9]{1,2}");
									Matcher matcher = pattern.matcher(cell.getStringCellValue());
									if (matcher.find()) {
										SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
										try {
											Date date = format.parse(cell.getStringCellValue());
											cellData.add(date);
										} catch (ParseException e) {
											e.printStackTrace();
										}
									} else {
										cellData.add(cell.getStringCellValue());
									}
								}
								if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									cellData.add(j, "");
								}
								if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									cellData.add(j, cell.getNumericCellValue());
								}
							}
							data.add(cellData);
						}
					}
					result.put("DATA", data);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.excel.IReadExcel#read2007Excel(java.lang.String, int)
	 */
	public Map<String, Object> read2007Excel(String excelPath, Integer sheetNumber, Integer firstRow) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> excelTitle = new ArrayList<>();
		List<List<Object>> data = new ArrayList<>();
		excelFile = new File(excelPath);
		try {
			input = new FileInputStream(excelFile);
			excelObjectx = new XSSFWorkbook(input);
			sheetx = excelObjectx.getSheetAt(sheetNumber);
			dataTotal = sheetx.getPhysicalNumberOfRows();
			if (dataTotal > 0) {
				XSSFRow row1 = sheetx.getRow(0);
				cellTotal = row1.getPhysicalNumberOfCells();
				if (cellTotal > 0) {
					for (int i = 0; i < cellTotal; i++) {
						excelTitle.add(row1.getCell(i).toString());
					}
					result.put("CELLTITLE", excelTitle);
				}
				if (dataTotal > firstRow) {
					for (int k = firstRow; k <= (dataTotal + firstRow); k++) {
						XSSFRow row = sheetx.getRow(k - 1);
						if (row != null) {
							List<Object> cellData = new ArrayList<>();
							for (int j = 0; j < cellTotal; j++) {
								XSSFCell cell = row.getCell(j);
								if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
									cellData.add(cell.getBooleanCellValue());
								}
								if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
									Pattern pattern = Pattern.compile("[0-9]{4}[年|\\-|/][0-9]{1,2}[月|\\-|/][0-9]{1,2}");
									Matcher matcher = pattern.matcher(cell.getStringCellValue());
									if (matcher.find()) {
										SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
										try {
											Date date = format.parse(cell.getStringCellValue());
											cellData.add(date);
										} catch (ParseException e) {
											e.printStackTrace();
										}
									} else {
										cellData.add(cell.getStringCellValue());
									}
								}
								if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
									cellData.add("");
								}
								if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
									cellData.add(cell.getNumericCellValue());
								}
							}
							data.add(cellData);
						}
					}
				}
				result.put("DATA", data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.excel.IReadExcel#read2007Excel(java.lang.String, int, int,
	 * int)
	 */
	public Map<String, Object> read2007Excel(String excelPath, Integer sheetNumber, Integer startRow, Integer endRow) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> excelTitle = new ArrayList<>();
		List<List<Object>> data = new ArrayList<>();
		excelFile = new File(excelPath);
		try {
			input = new FileInputStream(excelFile);
			excelObjectx = new XSSFWorkbook(input);
			sheetx = excelObjectx.getSheetAt(sheetNumber);
			dataTotal = endRow - startRow;
			if (dataTotal > 0) {
				XSSFRow row1 = sheetx.getRow(0);
				cellTotal = row1.getPhysicalNumberOfCells();
				if (cellTotal > 0) {
					for (int i = 0; i < cellTotal; i++) {
						excelTitle.add(i, row1.getCell(i).toString());
					}
					result.put("CELLTITLE", excelTitle);
					for (int k = startRow; k < endRow; k++) {
						XSSFRow row = sheetx.getRow(k - 1);
						if (row != null) {
							List<Object> cellData = new ArrayList<>();
							for (int j = 0; j < cellTotal; j++) {
								XSSFCell cell = row.getCell(j);
								if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
									cellData.add(j, cell.getBooleanCellValue());
								}
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									Pattern pattern = Pattern.compile("[0-9]{4}[年|\\-|/][0-9]{1,2}[月|\\-|/][0-9]{1,2}");
									Matcher matcher = pattern.matcher(cell.getStringCellValue());
									if (matcher.find()) {
										SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
										try {
											Date date = format.parse(cell.getStringCellValue());
											cellData.add(date);
										} catch (ParseException e) {
											e.printStackTrace();
										}
									} else {
										cellData.add(cell.getStringCellValue());
									}
								}
								if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									cellData.add(j, "");
								}
								if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									cellData.add(j, cell.getNumericCellValue());
								}
							}
							data.add(cellData);
						}
					}
					result.put("DATA", data);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
