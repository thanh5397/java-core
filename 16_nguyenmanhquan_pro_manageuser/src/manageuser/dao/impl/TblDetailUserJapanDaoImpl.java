/**
 * Copyright(C) 2020 Luvina Software
 * TblDetailUserJapan.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import manageuser.dao.TblDetailUserJapanDao;
import manageuser.entities.TblDetailUserJapanEntity;

/**
 * Mô tả:
 * @author Nguyễn Mạnh Quân
 */
public class TblDetailUserJapanDaoImpl extends BaseDaoImpl implements TblDetailUserJapanDao {
	PreparedStatement pStmt = null;
	ResultSet rs = null;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Connection getConnection() {
		return super.getConnection();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setConnection(Connection connection) {
		super.setConnection(connection);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertDetailUserJapan(TblDetailUserJapanEntity tblDetailUserJapanEntity) throws SQLException {
		try {
			String sql = "INSERT INTO  tbl_detail_user_japan(user_id, code_level, start_date, end_date, total) VALUES (?, ?, ?, ?, ?);";
			pStmt = connection.prepareStatement(sql);
			int i = 1;
			pStmt.setInt(i++, tblDetailUserJapanEntity.getUserId());
			pStmt.setString(i++, tblDetailUserJapanEntity.getCodeLevel());
			pStmt.setDate(i++, new java.sql.Date(tblDetailUserJapanEntity.getStartDate().getTime()));
			pStmt.setDate(i++, new java.sql.Date(tblDetailUserJapanEntity.getEndDate().getTime()));
			pStmt.setInt(i++, tblDetailUserJapanEntity.getTotal());
			pStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("TblDetailUserJapanDaoImpl: insertDetailUserJapan: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkExistDetailUserJapanById(int userId) throws SQLException, IOException, ClassNotFoundException {
		boolean isExist = false;
		try {
			if (connection == null || connection.isClosed()) {
				openConnection();
			}
			String sql = "SELECT detail_user_japan_id FROM tbl_detail_user_japan WHERE user_id = ?;";
			pStmt = connection.prepareStatement(sql);
			int i = 1;
			pStmt.setInt(i++, userId);
			rs = pStmt.executeQuery();
			if(rs.next()) {
				isExist = true;
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblDetailUserJapanDaoImpl: checkExistDetailUserJapnById: " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return isExist;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateDetailUserJapan(TblDetailUserJapanEntity tblDetailUserJapanEntity) throws SQLException {
		try {
			String sql = "UPDATE tbl_detail_user_japan SET code_level = ?, start_date = ?, end_date = ?, total = ? WHERE user_id = ?;";
			pStmt = connection.prepareStatement(sql);
			int i = 1;
			pStmt.setString(i++, tblDetailUserJapanEntity.getCodeLevel());
			pStmt.setDate(i++, new java.sql.Date(tblDetailUserJapanEntity.getStartDate().getTime()));
			pStmt.setDate(i++, new java.sql.Date(tblDetailUserJapanEntity.getEndDate().getTime()));
			pStmt.setInt(i++, tblDetailUserJapanEntity.getTotal());
			pStmt.setInt(i++, tblDetailUserJapanEntity.getUserId());
			pStmt.execute();
		} catch (SQLException e) {
			System.out.println("TblDetailUserJapanDaoImpl: updateDetailUserJapan: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteDetailUserJapan(int userId) throws SQLException {
		try {
			String sql = "DELETE FROM tbl_detail_user_japan WHERE user_id = ?";
			int i = 1;
			pStmt = connection.prepareStatement(sql);
			pStmt.setInt(i++, userId);
			pStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("TblDetailUserJapanDaoImpl: deleteDetailUserJapan: " + e.getMessage());
			throw e;
		}
	}
}
