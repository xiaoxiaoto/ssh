package org.aoto.tools.jdbc.persistence.dao;

import java.sql.ResultSet;

public interface IRowMapper {
	public Object getRow(ResultSet result);
}
