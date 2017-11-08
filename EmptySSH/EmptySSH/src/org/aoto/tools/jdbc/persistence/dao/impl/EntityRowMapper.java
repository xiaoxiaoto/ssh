package org.aoto.tools.jdbc.persistence.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.aoto.tools.jdbc.persistence.dao.IRowMapper;

import com.sun.jmx.snmp.Timestamp;

/**
 * 类/接口描述:将结果集中的一条记录转换成一个实体
 *
 * @author 赵德华
 * @version 1.0
 * 创建时间： 2015年9月17日 上午10:02:23 
 * JDK版本：sun jdk 1.6
 *********************************更新记录******************************
 * 版本：  <版本号>        修改日期：  <日期>        修改人： <修改人姓名>
 * 修改内容：  <修改内容描述>
 **********************************************************************
 */
public class EntityRowMapper implements IRowMapper {

	private Class clazz;

	public EntityRowMapper(Class clazz) {
		this.clazz = clazz;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aoto.jdbc.dao.IRowMapper#getRow(java.sql.ResultSet)
	 */
	@Override
	public Object getRow(ResultSet result) {
		Object object = null;
		try {
			object = clazz.newInstance();
			Field[] Fields = clazz.getDeclaredFields();
			for (int i = 0; i < Fields.length; i++) {
				String fieldName = Fields[i].toString().substring(Fields[i].toString().lastIndexOf(".") + 1);
				String capitalize = capitalize(fieldName);
				String methodName = "set" + capitalize;
				Method method = null;
				if (Fields[i].getType() == int.class) {
					method = clazz.getDeclaredMethod(methodName, int.class);
					method.invoke(object, result.getInt(i + 1));
				}
				if (Fields[i].getType() == String.class) {
					method = clazz.getDeclaredMethod(methodName, String.class);
					method.invoke(object, result.getString(i + 1));
				}
				if (Fields[i].getType() == double.class) {
					method = clazz.getDeclaredMethod(methodName, double.class);
					method.invoke(object, result.getDouble(i + 1));
				}
				if (Fields[i].getType() == long.class) {
					method = clazz.getDeclaredMethod(methodName, long.class);
					method.invoke(object, result.getLong(i + 1));
				}
				if (Fields[i].getType() == short.class) {
					method = clazz.getDeclaredMethod(methodName, short.class);
					method.invoke(object, result.getShort(i + 1));
				}
				if (Fields[i].getType() == Date.class) {
					method = clazz.getDeclaredMethod(methodName, Date.class);
					method.invoke(object, result.getDate(i + 1));
				}
				if (Fields[i].getType() == Timestamp.class) {
					method = clazz.getDeclaredMethod(methodName, Timestamp.class);
					method.invoke(object, result.getTimestamp(i + 1));
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return object;
	}

	/**
	 * 方法描述：将属性首字母大写
	 *
	 * @param fieldName
	 * @return String
	 */
	public String capitalize(String fieldName) {
		String newfieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
		return newfieldName;
	}

}
