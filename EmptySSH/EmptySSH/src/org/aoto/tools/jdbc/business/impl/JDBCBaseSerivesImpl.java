package org.aoto.tools.jdbc.business.impl;

import java.util.List;

import org.aoto.tools.jdbc.business.IJDBCBaseSerives;
import org.aoto.tools.jdbc.persistence.dao.IJDBCBaseDao;
import org.aoto.tools.jdbc.persistence.dao.IRowMapper;

/**
 * ��/�ӿ�����: jdbc services��ʵ����
 *
 * @author �Ե»�
 * @version 1.0
 * ����ʱ�䣺 2015��9��18�� ����2:30:35 
 * JDK�汾��sun jdk 1.6
 *********************************���¼�¼******************************
 * �汾��  <�汾��>        �޸����ڣ�  <����>        �޸��ˣ� <�޸�������>
 * �޸����ݣ�  <�޸���������>
 **********************************************************************
 */
public class JDBCBaseSerivesImpl implements IJDBCBaseSerives {
	private IJDBCBaseDao jdbcBaseDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.services.IJDBCBaseSerives#queryTitle(java.lang.String,
	 * org.aoto.jdbc.dao.IRowMapper)
	 */
	@Override
	public List<Object> queryTitle(String sql, IRowMapper RowMapper) {
		return jdbcBaseDao.queryTitle(sql, RowMapper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.services.IJDBCBaseSerives#queryTotal(java.lang.String,
	 * java.util.List)
	 */
	@Override
	public Integer queryTotal(String sql, List<Object> limits) {
		return jdbcBaseDao.queryTotal(sql, limits);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.services.IJDBCBaseSerives#queryTotal(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public Integer queryTotal(String sql, Object limit) {
		return jdbcBaseDao.queryTotal(sql, limit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.services.IJDBCBaseSerives#queryTotal(java.lang.String)
	 */
	@Override
	public Integer queryTotal(String sql) {
		return jdbcBaseDao.queryTotal(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aoto.jdbc.services.IJDBCBaseSerives#queryByLimits(java.lang.String,
	 * org.aoto.jdbc.dao.IRowMapper, java.util.List)
	 */
	@Override
	public List<Object> queryByLimits(String sql, IRowMapper RowMapper, List<Object> limits) {
		return jdbcBaseDao.queryByLimits(sql, RowMapper, limits);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aoto.jdbc.services.IJDBCBaseSerives#queryByLimitsAndPaging(java.lang
	 * .String, org.aoto.jdbc.dao.IRowMapper, java.util.List, java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Object> queryByLimitsAndPaging(String sql, IRowMapper RowMapper, List<Object> limits,
			Integer pageNumber, Integer count) {
		return jdbcBaseDao.queryByLimitsAndPaging(sql, RowMapper, limits, pageNumber, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aoto.jdbc.services.IJDBCBaseSerives#queryByLimit(java.lang.String,
	 * org.aoto.jdbc.dao.IRowMapper, java.lang.Object)
	 */
	@Override
	public List<Object> queryByLimit(String sql, IRowMapper RowMapper, Object limit) {
		return jdbcBaseDao.queryByLimit(sql, RowMapper, limit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aoto.jdbc.services.IJDBCBaseSerives#queryByLimitAndPaging(java.lang
	 * .String, org.aoto.jdbc.dao.IRowMapper, java.lang.Object,
	 * java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Object> queryByLimitAndPaging(String sql, IRowMapper RowMapper, Object limit, Integer pageNumber,
			Integer count) {
		return jdbcBaseDao.queryByLimitAndPaging(sql, RowMapper, limit, pageNumber, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aoto.jdbc.services.IJDBCBaseSerives#uniqueQuery(java.lang.String,
	 * org.aoto.jdbc.dao.IRowMapper, java.lang.Object)
	 */
	@Override
	public Object uniqueQuery(String sql, IRowMapper RowMapper, Object id) {
		return jdbcBaseDao.uniqueQuery(sql, RowMapper, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.services.IJDBCBaseSerives#queryAll(java.lang.String,
	 * org.aoto.jdbc.dao.IRowMapper)
	 */
	@Override
	public List<Object> queryAll(String sql, IRowMapper RowMapper) {
		return jdbcBaseDao.queryAll(sql, RowMapper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aoto.jdbc.services.IJDBCBaseSerives#queryAllAndPaging(java.lang.String
	 * , org.aoto.jdbc.dao.IRowMapper, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Object> queryAllAndPaging(String sql, IRowMapper RowMapper, Integer pageNumber, Integer count) {
		return jdbcBaseDao.queryAllAndPaging(sql, RowMapper, pageNumber, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.services.IJDBCBaseSerives#save(java.lang.String,
	 * java.util.List)
	 */
	@Override
	public Integer save(String sql, List<Object> values) {
		return jdbcBaseDao.save(sql, values);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.services.IJDBCBaseSerives#save(java.lang.String)
	 */
	@Override
	public Integer save(String sql) {
		return jdbcBaseDao.save(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.services.IJDBCBaseSerives#delete(java.lang.String,
	 * java.util.List)
	 */
	@Override
	public Integer delete(String sql, List<Object> limits) {
		return jdbcBaseDao.delete(sql, limits);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.services.IJDBCBaseSerives#delete(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public Integer delete(String sql, Object limit) {
		return jdbcBaseDao.delete(sql, limit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aoto.jdbc.services.IJDBCBaseSerives#uniqueDelete(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public Integer uniqueDelete(String sql, Object id) {
		return jdbcBaseDao.uniqueDelete(sql, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.services.IJDBCBaseSerives#delete(java.lang.String)
	 */
	@Override
	public Integer delete(String sql) {
		return jdbcBaseDao.delete(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.services.IJDBCBaseSerives#update(java.lang.String,
	 * java.util.List)
	 */
	@Override
	public Integer update(String sql, List<Object> limits) {
		return jdbcBaseDao.update(sql, limits);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.services.IJDBCBaseSerives#update(java.lang.String)
	 */
	@Override
	public Integer update(String sql) {
		return jdbcBaseDao.update(sql);
	}

	public IJDBCBaseDao getJdbcBaseDao() {
		return jdbcBaseDao;
	}

	public void setJdbcBaseDao(IJDBCBaseDao jdbcBaseDao) {
		this.jdbcBaseDao = jdbcBaseDao;
	}

}
