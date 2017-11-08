package org.aoto.tools.excel.base;

import java.util.List;

/**
 * ��/�ӿ�����: ͨ�����򴴽�Excel2003��Excel2007
 *
 * @author �Ե»�
 * @version 1.0
 * ����ʱ�䣺 2015��9��15�� ����3:26:11 
 * JDK�汾��sun jdk 1.6
 *********************************���¼�¼******************************
 * �汾��  <�汾��>        �޸����ڣ�  <����>        �޸��ˣ� <�޸�������>
 * �޸����ݣ�  <�޸���������>
 **********************************************************************
 */
public interface ICreateExcel {

	/**
	 * ��������������Excel2003
	 *
	 * @param sheetName ������������
	 * @param excelPath ������Excel��·��
	 * @param cellTitle��������
	 * @param data ������
	 */
	public void create2003Excel(String sheetName, String excelPath, List<String> cellTitle, Integer fristRow,
			List<List<Object>> data);

	/**
	 * ����������<�������������ã�ע�⣺�ӿ���ֻ�������������ã�ʵ������Ҫ��������ʵ��˼·�������>
	 *
	 * @param sheetName������������
	 * @param excelPath������Excel��·��
	 * @param cellTitle��������
	 * @param data ������
	 */
	public void create2007Excel(String sheetName, String excelPath, List<String> cellTitle, Integer fristRow,
			List<List<Object>> data);
}
