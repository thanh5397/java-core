package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		try {
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.setId(rs.getLong("id"));
			categoryModel.setName(rs.getString("name"));
			categoryModel.setCode(rs.getString("code"));
			categoryModel.setCreateddate(rs.getTimestamp("createddate"));
			categoryModel.setModifieddate(rs.getTimestamp("modifieddate"));
			categoryModel.setCreatedby(rs.getString("createdby"));
			categoryModel.setModifiedby(rs.getString("modifiedby"));
			return categoryModel;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
