/**
 * Copyright(C) 2020 Luvina Software
 * MstJapanImpl.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.dao.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.MstJapanDao;
import manageuser.entities.MstJapanEntity;
import manageuser.utils.Constant;

/**
 * Mô tả: Implement MstJapanDao để thao tác với DB bảng mst_japan
 * 
 * @author Nguyễn Mạnh Quân
 */
public class MstJapanDaoImpl extends BaseDaoImpl implements MstJapanDao {
	PreparedStatement pStmt = null;
	ResultSet rs = null;

	/**
	 * {@inheritDoc}
	 * 
	 * @throws SQLException, ClassNotFoundException, IOException
	 */
	@Override
	public List<MstJapanEntity> getAllMstJapan() throws SQLException, ClassNotFoundException, IOException {
		List<MstJapanEntity> listMstJapanEntities = new ArrayList<MstJapanEntity>();
		try {
			if (connection == null || connection.isClosed()) {
				openConnection();
			}
			String sql = "SELECT * FROM mst_japan ORDER BY code_level";
			pStmt = connection.prepareStatement(sql);
			rs = pStmt.executeQuery();

			while (rs.next()) {
				int i = 1;
				MstJapanEntity mstJapanEntity = new MstJapanEntity();
				mstJapanEntity.setCodeLevel(rs.getString(i++));
				mstJapanEntity.setNameLevel(rs.getString(i++));
				listMstJapanEntities.add(mstJapanEntity);
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("MstJapanDaoImpl: getAllMstJapan: " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return listMstJapanEntities;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNameLevelByCodeLevel(String codeLevel) throws SQLException, ClassNotFoundException, IOException {
		String nameLevel = Constant.EMPTY_STRING;
		try {
			if (connection == null || connection.isClosed()) {
				openConnection();
			}
			String sql = "SELECT name_level FROM mst_japan WHERE code_level = ?";
			pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, codeLevel);
			rs = pStmt.executeQuery();

			if (rs.next()) {
				nameLevel = rs.getString(1);
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("MstJapanDaoImpl: getNameLevelByCodeLevel: " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return nameLevel;
	}
}
