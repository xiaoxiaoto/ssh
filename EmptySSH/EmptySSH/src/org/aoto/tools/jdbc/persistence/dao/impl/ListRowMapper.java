package org.aoto.tools.jdbc.persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.aoto.tools.jdbc.persistence.dao.IRowMapper;

public class ListRowMapper implements IRowMapper {
	private List<Object> row = null;

	@Override
	public Object getRow(ResultSet result) {
		row = new ArrayList<>();
		Integer columnCount = 0;
		try {
			ResultSetMetaData metaData = result.getMetaData();
			columnCount = metaData.getColumnCount();

			for (int i = 0; i < columnCount; i++) {
				int columnType = metaData.getColumnType(i + 1);
				if (columnType == Types.VARCHAR) {
					row.add(result.getString(i + 1));
				}
				if (columnType == Types.DOUBLE) {
					row.add(result.getDouble(i + 1));
				}
				if (columnType == Types.FLOAT) {
					row.add(result.getFloat(i + 1));
				}
				if (columnType == Types.INTEGER) {
					row.add(result.getInt(i + 1));
				}
				if (columnType == Types.NUMERIC) {
					row.add(result.getDouble(i + 1));
				}
				if (columnType == Types.DATE) {
					row.add(result.getDate(i + 1));
				}
				if (columnType == Types.TIMESTAMP) {
					row.add(result.getTimestamp(i + 1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

}
