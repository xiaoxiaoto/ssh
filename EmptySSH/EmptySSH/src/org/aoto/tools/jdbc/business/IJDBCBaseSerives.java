package org.aoto.tools.jdbc.business;

import java.util.List;

import org.aoto.tools.jdbc.persistence.dao.IRowMapper;

/**
 * ��/�ӿ�����: jdbc services��ӿ�
 *
 * @author �Ե»�
 * @version 1.0
 * ����ʱ�䣺 2015��9��18�� ����2:29:19 
 * JDK�汾��sun jdk 1.6
 *********************************���¼�¼******************************
 * �汾��  <�汾��>        �޸����ڣ�  <����>        �޸��ˣ� <�޸�������>
 * �޸����ݣ�  <�޸���������>
 **********************************************************************
 */
public interface IJDBCBaseSerives {
	/**
	 * ����������ͨ��sql��ѯ���ֶ���
	 *
	 * @param sql����ѯsql
	 * @param RowMapper����ת����
	 * @return List<Object>����ѯ���
	 */
	public List<Object> queryTitle(String sql, IRowMapper RowMapper);

	/**
	 * ����������������������¼�¼������
	 *
	 * @param sql����ѯsql����ռλ��
	 * @param limits��������ƣ���ռλ��˳����ͬ��
	 * @return Integer�� ��ѯ��� -1�����쳣
	 */
	public Integer queryTotal(String sql, List<Object> limits);

	/**
	 * �����������������������¼�¼������
	 *
	 * @param sql����ѯsql����ռλ��
	 * @param limit����������
	 * @return Integer�� ��ѯ��� -1�����쳣
	 */
	public Integer queryTotal(String sql, Object limit);

	/**
	 * ����������ͨ������ռλ��sql��ѯ��¼������
	 *
	 * @param sql����ѯsql
	 * @return Integer�� ��ѯ��� -1�����쳣
	 */
	public Integer queryTotal(String sql);

	/**
	 * ������������ѯ������������¼�¼
	 *
	 * @param sql����ѯsql����ռλ��
	 * @param RowMapper����ת����
	 * @param limits��������ƣ���ռλ��˳����ͬ��
	 * @return List<Object>����ѯ���
	 */
	public List<Object> queryByLimits(String sql, IRowMapper RowMapper, List<Object> limits);

	/**
	 * ������������ѯ������������¼�¼
	 *
	 * @param sql����ѯsql����ռλ��
	 * @param RowMapper����ת����
	 * @param limits��������ƣ���ռλ��˳����ͬ��
	 * @param pageNumber����ǰ����ҳҳ��
	 * @param count��һҳ��ʾ������
	 * @return List<Object>����ѯ���
	 */
	public List<Object> queryByLimitsAndPaging(String sql, IRowMapper RowMapper, List<Object> limits,
			Integer pageNumber, Integer count);

	/**
	 * �����������������������¼�¼
	 *
	 * @param sql����ѯsql����ռλ��
	 * @param RowMapper����ת����
	 * @param limit����������
	 * @return List<Object>����ѯ���
	 */
	public List<Object> queryByLimit(String sql, IRowMapper RowMapper, Object limit);

	/**
	 * ������������ѯ�������������¼�¼
	 *
	 * @param sql����ѯsql����ռλ��
	 * @param RowMapper����ת����
	 * @param limit����������
	 * @param pageNumber����ǰ����ҳҳ��
	 * @param count��һҳ��ʾ������
	 * @return List<Object>����ѯ���
	 */
	public List<Object> queryByLimitAndPaging(String sql, IRowMapper RowMapper, Object limit, Integer pageNumber,
			Integer count);

	/**
	 * ����������ͨ��������ѯ��¼
	 *
	 * @param sql����ѯsql����ռλ��
	 * @param RowMapper����ת����
	 * @param id������ֵ
	 * @return Object����ѯ���
	 */
	public Object uniqueQuery(String sql, IRowMapper RowMapper, Object id);

	/**
	 * ��������������ռλ����sql��ѯ
	 *
	 * @param sql����ѯsql
	 * @param RowMapper����ת����
	 * @return List<Object>����ѯ���
	 */
	public List<Object> queryAll(String sql, IRowMapper RowMapper);

	/**
	 * ��������������ռλ����sql��ѯ
	 *
	 * @param sql����ѯsql
	 * @param RowMapper����ת����
	 * @param pageNumber����ǰ����ҳҳ��
	 * @param count��һҳ��ʾ������
	 * @return List<Object>����ѯ���
	 */
	public List<Object> queryAllAndPaging(String sql, IRowMapper RowMapper, Integer pageNumber, Integer count);

	/**
	 * ��������������ռλ����sql����
	 *
	 * @param sql������ռλ����sql
	 * @param values��Ҫ���������
	 * @return Integer��Ӱ������ -1�����쳣
	 */
	public Integer save(String sql, List<Object> values);

	/**
	 * ��������������ռλ����sql����
	 *
	 * @param sql����ռλ����sql
	 * @return Integer��Ӱ������ -1�����쳣
	 */
	public Integer save(String sql);

	/**
	 * ����������ͨ�������������ɾ������
	 *
	 * @param sql������ռλ����ɾ��sql
	 * @param limits�����������������ռλ��˳����ͬ��
	 * @return Integer��Ӱ������ -1�����쳣
	 */
	public Integer delete(String sql, List<Object> limits);

	/**
	 * ����������ͨ������������������������ɾ������
	 *
	 * @param sql������ռλ����ɾ��sql
	 * @param limit����������
	 * @return Integer��Ӱ������ -1�����쳣
	 */
	public Integer delete(String sql, Object limit);

	/**
	 * ����������ͨ������ɾ����������
	 *
	 * @param sql������������������ɾ��sql����ռλ��
	 * @param id������ֵ
	 * @return Integer��Ӱ������ -1�����쳣
	 */
	public Integer uniqueDelete(String sql, Object id);

	/**
	 * ��������������ռλ����ɾ��sql
	 *
	 * @param sql������ռλ����ɾ��sql
	 * @return Integer��Ӱ������ -1�����쳣
	 */
	public Integer delete(String sql);

	/**
	 * ��������������ռλ����sql�޸�
	 *
	 * @param sql������ռλ���ĸ���sql
	 * @param limits��Ҫ�޸ĵ�ֵ����������������ռλ��˳����ͬ��
	 * @return Integer����Ӱ������ -1�����쳣
	 */
	public Integer update(String sql, List<Object> limits);

	/**
	 * ��������������ռλ����sql�޸�
	 *
	 * @param sql������ռλ���ĸ���sql
	 * @return Integer����Ӱ������ -1�����쳣
	 */
	public Integer update(String sql);
}
