package com.laptrinhjavaweb.dao;

import java.sql.Connection;
import java.util.List;

import com.laptrinhjavaweb.mapper.RowMapper;

public interface GenericDAO<T> {
	Connection getConnection();
	<T> List<T> query(String sql,RowMapper<T> row,Object... parameters);
	Long insert (String sql, Object... parameters);
	void update (String sql, Object... parameters);
}
