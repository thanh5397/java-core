package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel>{

	@Override
	public NewModel mapRow(ResultSet rs) {
		try {
			NewModel newModel = new NewModel();
			newModel.setId(rs.getLong("id"));
			newModel.setTitle(rs.getString("title"));
			newModel.setThumbnail(rs.getString("thumbnail"));
			newModel.setShortdescription(rs.getString("shortdescription"));
			newModel.setContent(rs.getString("content"));
			newModel.setCategoryid(rs.getLong("categoryid"));
			newModel.setCreateddate(rs.getTimestamp("createddate"));
			newModel.setModifieddate(rs.getTimestamp("modifieddate"));
			newModel.setCreatedby(rs.getString("createdby"));
			newModel.setModifiedby(rs.getString("modifiedby"));
			return newModel;
		} catch (SQLException e) {
			return null;
		}
	}
}
