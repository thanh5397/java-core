/**
 * Copyright(C) 2020 Luvina Software
 * MstGroupImpl.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.dao.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.MstGroupDao;
import manageuser.entities.MstGroupEntity;
import manageuser.utils.Constant;

/**
 * Mô tả: Implement MstGroupDao để thao tác với DB bảng mst_group
 * @author Nguyễn Mạnh Quân
 */
public class MstGroupDaoImpl extends BaseDaoImpl implements MstGroupDao {
	PreparedStatement pStmt = null;
	ResultSet rs = null;
	/**
	 * {@inheritDoc}
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public List<MstGroupEntity> getAllMstGroup() throws ClassNotFoundException, SQLException, IOException {
		List<MstGroupEntity> listMstGroupEntities = new ArrayList<MstGroupEntity>();
		try {
			if(connection == null || connection.isClosed()) {
				openConnection();
			}
			String sql = "SELECT * FROM mst_group ORDER BY group_id";
			pStmt = connection.prepareStatement(sql);
			rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int i = 1;
				MstGroupEntity mstGroupEntity = new MstGroupEntity();
				mstGroupEntity.setGroupId(rs.getInt(i++));
				mstGroupEntity.setGroupName(rs.getString(i++));
				listMstGroupEntities.add(mstGroupEntity);
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("MstGroupDaoImpl: getAllMstGroup: " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return listMstGroupEntities;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getGroupNameById(int groupId) throws SQLException, ClassNotFoundException, IOException {
		String groupName = Constant.EMPTY_STRING;
		try {
			if(connection == null || connection.isClosed()) {
				openConnection();
			}
			String sql = "SELECT group_name FROM mst_group WHERE group_id = ?";
			pStmt = connection.prepareStatement(sql);
			pStmt.setInt(1, groupId);
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				groupName = rs.getString(1);
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("MstGroupDaoImpl: getGroupNameById: " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return groupName;
	}
}
