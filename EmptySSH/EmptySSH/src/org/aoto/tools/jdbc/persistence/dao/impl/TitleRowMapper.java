package org.aoto.tools.jdbc.persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.aoto.tools.jdbc.persistence.dao.IRowMapper;

public class TitleRowMapper implements IRowMapper {
	private List<Object> title = null;

	@Override
	public Object getRow(ResultSet result) {
		title = new ArrayList<>();
		Integer columnCount = 0;
		try {
			ResultSetMetaData metaData = result.getMetaData();
			columnCount = metaData.getColumnCount();

			for (int i = 0; i < columnCount; i++) {
				title.add(metaData.getColumnName(i + 1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return title;
	}

}
