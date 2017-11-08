package org.aoto.tools.excel.base;

import java.util.Map;

/**
 * ��/�ӿ�����: ��ȡExcel2003��Excel2007
 *
 * @author �Ե»�
 * @version 1.0
 * ����ʱ�䣺 2015��9��15�� ����3:32:07 
 * JDK�汾��sun jdk 1.6
 *********************************���¼�¼******************************
 * �汾��  <�汾��>        �޸����ڣ�  <����>        �޸��ˣ� <�޸�������>
 * �޸����ݣ�  <�޸���������>
 **********************************************************************
 */
public interface IReadExcel {

	/**
	 * ������������ȡExcel2003
	 *
	 * @param excelPath��Excel����·��
	 * @param sheetNumber����ȡ������������
	 * @return Map<String,Object>
	 */
	public Map<String, Object> read2003Excel(String excelPath, Integer sheetNumber, Integer firstRow);

	/**
	 * ������������ȡExcel2003��ָ������
	 *
	 * @param excelPath��Excel����·��
	 * @param sheetNumber����ȡ������������
	 * @param startRow����ʼ��
	 * @param endRow��������
	 * @return Map<String,Object>
	 */
	public Map<String, Object> read2003Excel(String excelPath, Integer sheetNumber, Integer startRow, Integer endRow);

	/**
	 * ������������ȡExcel2007
	 *
	 * @param excelPath��Excel����·��
	 * @param sheetNumber����ȡ������������
	 * @return Map<String,Object>
	 */
	public Map<String, Object> read2007Excel(String excelPath, Integer sheetNumber, Integer firstRow);

	/**
	 * ������������ȡExcel2007
	 *
	 * @param excelPath��Excel����·��
	 * @param sheetNumber����ȡ������������
	 * @param startRow����ʼ��
	 * @param endRow��������
	 * @return Map<String,Object>
	 */
	public Map<String, Object> read2007Excel(String excelPath, Integer sheetNumber, Integer startRow, Integer endRow);

}
