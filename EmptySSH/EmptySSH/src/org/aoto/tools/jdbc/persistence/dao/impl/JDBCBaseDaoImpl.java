package org.aoto.tools.jdbc.persistence.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aoto.tools.jdbc.persistence.dao.IJDBCBaseDao;
import org.aoto.tools.jdbc.persistence.dao.IRowMapper;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCBaseDaoImpl implements IJDBCBaseDao {
	private ComboPooledDataSource dataSource;
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet result = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#queryTitle(java.lang.String)
	 */
	@Override
	public List<Object> queryTitle(String sql, IRowMapper RowMapper) {
		List<Object> rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			if (result.next()) {
				rs = (List<Object>) RowMapper.getRow(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#queryTotal(java.lang.String,
	 * java.util.List)
	 */
	@Override
	public Integer queryTotal(String sql, List<Object> limits) {
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			parameterAnalysis(limits);
			result = statement.executeQuery();
			if (result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#queryTotal(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public Integer queryTotal(String sql, Object limit) {
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			addParameter(1, limit);
			result = statement.executeQuery();
			if (result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#queryTotal(java.lang.String)
	 */
	@Override
	public Integer queryTotal(String sql) {
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			if (result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// this.close(connection, statement, result);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#queryByLimits(java.lang.String,
	 * org.aoto.jdbc.dao.IRowMapper, java.util.List)
	 */
	@Override
	public List<Object> queryByLimits(String sql, IRowMapper RowMapper, List<Object> limits) {
		List<Object> rs = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			parameterAnalysis(limits);
			result = statement.executeQuery();
			while (result.next()) {
				Object row = RowMapper.getRow(result);
				rs.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// this.close(connection, statement, result);
		}
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aoto.jdbc.dao.IJDBCBaseDao#queryByLimitsAndPaging(java.lang.String,
	 * org.aoto.jdbc.dao.IRowMapper, java.util.List, java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Object> queryByLimitsAndPaging(String sql, IRowMapper RowMapper, List<Object> limits,
			Integer pageNumber, Integer count) {
		List<Object> results = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			parameterAnalysis(limits);
			result = statement.executeQuery();
			while (result.next()) {
				Object row = RowMapper.getRow(result);
				results.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// this.close(connection, statement, result);
		}
		List<Object> rs = pagination(results, pageNumber, count);
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#queryByLimit(java.lang.String,
	 * org.aoto.jdbc.dao.IRowMapper, java.lang.Object)
	 */
	@Override
	public List<Object> queryByLimit(String sql, IRowMapper RowMapper, Object limit) {
		List<Object> rs = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			addParameter(1, limit);
			result = statement.executeQuery();
			while (result.next()) {
				Object row = RowMapper.getRow(result);
				rs.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// this.close(connection, statement, result);
		}
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.aoto.jdbc.dao.IJDBCBaseDao#queryByLimitAndPaging(java.lang.String,
	 * org.aoto.jdbc.dao.IRowMapper, java.lang.Object, java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Object> queryByLimitAndPaging(String sql, IRowMapper RowMapper, Object limit, Integer pageNumber,
			Integer count) {
		List<Object> results = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			addParameter(1, limit);
			result = statement.executeQuery();
			while (result.next()) {
				Object row = RowMapper.getRow(result);
				results.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// this.close(connection, statement, result);
		}
		List<Object> rs = pagination(results, pageNumber, count);
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#uniqueQuery(java.lang.String,
	 * org.aoto.jdbc.dao.IRowMapper, java.lang.Object)
	 */
	@Override
	public Object uniqueQuery(String sql, IRowMapper RowMapper, Object id) {
		Object rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			addParameter(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				rs = RowMapper.getRow(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// this.close(connection, statement, result);
		}
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#queryAll(java.lang.String,
	 * org.aoto.jdbc.dao.IRowMapper)
	 */
	@Override
	public List<Object> queryAll(String sql, IRowMapper RowMapper) {
		List<Object> rs = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while (result.next()) {
				Object row = RowMapper.getRow(result);
				rs.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, statement, result);
		}
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#queryAllAndPaging(java.lang.String,
	 * org.aoto.jdbc.dao.IRowMapper, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Object> queryAllAndPaging(String sql, IRowMapper RowMapper, Integer pageNumber, Integer count) {
		List<Object> results = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while (result.next()) {
				Object row = RowMapper.getRow(result);
				results.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, statement, result);
		}
		List<Object> rs = pagination(results, pageNumber, count);
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#save(java.lang.String,
	 * java.util.List)
	 */
	@Override
	public Integer save(String sql, List<Object> values) {
		Integer rs = -1;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			parameterAnalysis(values);
			rs = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, statement, result);
		}
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#save(java.lang.String)
	 */
	@Override
	public Integer save(String sql) {
		Integer rs = -1;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			rs = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, statement, result);
		}
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#delete(java.lang.String,
	 * java.util.List)
	 */
	@Override
	public Integer delete(String sql, List<Object> limits) {
		Integer rs = -1;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			parameterAnalysis(limits);
			rs = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, statement, result);
		}
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#delete(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public Integer delete(String sql, Object limit) {
		Integer rs = -1;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			addParameter(1, limit);
			rs = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, statement, result);
		}
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#uniqueDelete(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public Integer uniqueDelete(String sql, Object id) {
		Integer rs = -1;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			addParameter(1, id);
			rs = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, statement, result);
		}
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#delete(java.lang.String)
	 */
	@Override
	public Integer delete(String sql) {
		Integer rs = -1;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			rs = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, statement, result);
		}
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#update(java.lang.String,
	 * java.util.List)
	 */
	@Override
	public Integer update(String sql, List<Object> limits) {
		Integer rs = -1;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			parameterAnalysis(limits);
			rs = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, statement, result);
		}
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IJDBCBaseDao#update(java.lang.String)
	 */
	@Override
	public Integer update(String sql) {
		Integer rs = -1;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			rs = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, statement, result);
		}
		return rs;
	}

	/**
	 * 方法描述：对数据进行分页
	 *
	 * @param results：数据集
	 * @param pageNumber：当前页码
	 * @param count：一页显示数据数
	 * @return List<Object>
	 */
	public List<Object> pagination(List<Object> results, Integer pageNumber, Integer count) {
		List<Object> page = new ArrayList<>();
		int startRow = (pageNumber - 1) * count;
		int endRow = pageNumber * count;
		for (int i = startRow; i < endRow; i++) {
			page.add(results.get(i));
		}
		return page;
	}

	/**
	 * 方法描述：对多参数进行遍历然后对参数类解析为SQL中限制条件赋值
	 *
	 * @param limits
	 * @throws SQLException 
	 */
	private void parameterAnalysis(List<Object> limits) throws SQLException {
		for (int i = 1; i <= limits.size(); i++) {
			Object value = limits.get(i - 1);
			addParameter(i, value);
		}
	}

	/**
	 * 方法描述：通过对参数类解析为SQL中限制条件赋值
	 *
	 * @param i ：SQL中限制条件索引
	 * @param value：参数值
	 * @throws SQLException void
	 */
	private void addParameter(int i, Object value) throws SQLException {
		if (value instanceof String) {
			statement.setString(i, (String) value);
		}
		if (value instanceof Integer) {
			statement.setInt(i, (Integer) value);
		}
		if (value instanceof Short) {
			statement.setShort(i, (Short) value);
		}
		if (value instanceof Double) {
			statement.setDouble(i, (Double) value);
		}
		if (value instanceof Date) {
			SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
			String date = fomat.format(value);
			statement.setString(i, date);
		}
	}

	/**
	 * 方法描述：回收资源包括Connection, Statement,ResultSet
	 *
	 * @param connection
	 * @param statement
	 * @param result 
	 */
	public void close(Connection connection, Statement statement, ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setDataSource(ComboPooledDataSource dataSource) {
		this.dataSource = dataSource;
	}

}
