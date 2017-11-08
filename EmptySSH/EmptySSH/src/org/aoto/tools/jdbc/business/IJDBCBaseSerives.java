package org.aoto.tools.jdbc.business;

import java.util.List;

import org.aoto.tools.jdbc.persistence.dao.IRowMapper;

/**
 * 类/接口描述: jdbc services层接口
 *
 * @author 赵德华
 * @version 1.0
 * 创建时间： 2015年9月18日 下午2:29:19 
 * JDK版本：sun jdk 1.6
 *********************************更新记录******************************
 * 版本：  <版本号>        修改日期：  <日期>        修改人： <修改人姓名>
 * 修改内容：  <修改内容描述>
 **********************************************************************
 */
public interface IJDBCBaseSerives {
	/**
	 * 方法描述：通过sql查询出字段名
	 *
	 * @param sql：查询sql
	 * @param RowMapper：行转换器
	 * @return List<Object>：查询结果
	 */
	public List<Object> queryTitle(String sql, IRowMapper RowMapper);

	/**
	 * 方法描述：多个限制条件下记录的总数
	 *
	 * @param sql：查询sql带有占位符
	 * @param limits：多个限制（与占位符顺序相同）
	 * @return Integer： 查询结果 -1：出异常
	 */
	public Integer queryTotal(String sql, List<Object> limits);

	/**
	 * 方法描述：单个限制条件下记录的总数
	 *
	 * @param sql：查询sql带有占位符
	 * @param limit：限制条件
	 * @return Integer： 查询结果 -1：出异常
	 */
	public Integer queryTotal(String sql, Object limit);

	/**
	 * 方法描述：通过不带占位符sql查询记录的总数
	 *
	 * @param sql：查询sql
	 * @return Integer： 查询结果 -1：出异常
	 */
	public Integer queryTotal(String sql);

	/**
	 * 方法描述：查询多个限制条件下记录
	 *
	 * @param sql：查询sql带有占位符
	 * @param RowMapper：行转换器
	 * @param limits：多个限制（与占位符顺序相同）
	 * @return List<Object>：查询结果
	 */
	public List<Object> queryByLimits(String sql, IRowMapper RowMapper, List<Object> limits);

	/**
	 * 方法描述：查询多个限制条件下记录
	 *
	 * @param sql：查询sql带有占位符
	 * @param RowMapper：行转换器
	 * @param limits：多个限制（与占位符顺序相同）
	 * @param pageNumber：当前所在页页码
	 * @param count：一页显示数据数
	 * @return List<Object>：查询结果
	 */
	public List<Object> queryByLimitsAndPaging(String sql, IRowMapper RowMapper, List<Object> limits,
			Integer pageNumber, Integer count);

	/**
	 * 方法描述：单个限制条件下记录
	 *
	 * @param sql：查询sql带有占位符
	 * @param RowMapper：行转换器
	 * @param limit：限制条件
	 * @return List<Object>：查询结果
	 */
	public List<Object> queryByLimit(String sql, IRowMapper RowMapper, Object limit);

	/**
	 * 方法描述：查询单个限制条件下记录
	 *
	 * @param sql：查询sql带有占位符
	 * @param RowMapper：行转换器
	 * @param limit：限制条件
	 * @param pageNumber：当前所在页页码
	 * @param count：一页显示数据数
	 * @return List<Object>：查询结果
	 */
	public List<Object> queryByLimitAndPaging(String sql, IRowMapper RowMapper, Object limit, Integer pageNumber,
			Integer count);

	/**
	 * 方法描述：通过主键查询记录
	 *
	 * @param sql：查询sql带有占位符
	 * @param RowMapper：行转换器
	 * @param id：主键值
	 * @return Object：查询结果
	 */
	public Object uniqueQuery(String sql, IRowMapper RowMapper, Object id);

	/**
	 * 方法描述：不带占位符的sql查询
	 *
	 * @param sql：查询sql
	 * @param RowMapper：行转换器
	 * @return List<Object>：查询结果
	 */
	public List<Object> queryAll(String sql, IRowMapper RowMapper);

	/**
	 * 方法描述：不带占位符的sql查询
	 *
	 * @param sql：查询sql
	 * @param RowMapper：行转换器
	 * @param pageNumber：当前所在页页码
	 * @param count：一页显示数据数
	 * @return List<Object>：查询结果
	 */
	public List<Object> queryAllAndPaging(String sql, IRowMapper RowMapper, Integer pageNumber, Integer count);

	/**
	 * 方法描述：带有占位符的sql保存
	 *
	 * @param sql：带有占位符的sql
	 * @param values：要保存的数据
	 * @return Integer：影响行数 -1：出异常
	 */
	public Integer save(String sql, List<Object> values);

	/**
	 * 方法描述：不带占位符的sql保存
	 *
	 * @param sql不带占位符的sql
	 * @return Integer：影响行数 -1：出异常
	 */
	public Integer save(String sql);

	/**
	 * 方法描述：通过多个限制条件删除数据
	 *
	 * @param sql：带有占位符的删除sql
	 * @param limits：多个限制条件（与占位符顺序相同）
	 * @return Integer：影响行数 -1：出异常
	 */
	public Integer delete(String sql, List<Object> limits);

	/**
	 * 方法描述：通过单个限制条件（非主键）删除数据
	 *
	 * @param sql：带有占位符的删除sql
	 * @param limit：限制条件
	 * @return Integer：影响行数 -1：出异常
	 */
	public Integer delete(String sql, Object limit);

	/**
	 * 方法描述：通过主键删除单行数据
	 *
	 * @param sql：限制条件是主键的删除sql带有占位符
	 * @param id：主键值
	 * @return Integer：影响行数 -1：出异常
	 */
	public Integer uniqueDelete(String sql, Object id);

	/**
	 * 方法描述：不带占位符的删除sql
	 *
	 * @param sql：不带占位符的删除sql
	 * @return Integer：影响行数 -1：出异常
	 */
	public Integer delete(String sql);

	/**
	 * 方法描述：带有占位符的sql修改
	 *
	 * @param sql：带有占位符的更新sql
	 * @param limits：要修改的值，和限制条件（与占位符顺序相同）
	 * @return Integer：：影响行数 -1：出异常
	 */
	public Integer update(String sql, List<Object> limits);

	/**
	 * 方法描述：不带占位符的sql修改
	 *
	 * @param sql：不带占位符的更新sql
	 * @return Integer：：影响行数 -1：出异常
	 */
	public Integer update(String sql);
}
