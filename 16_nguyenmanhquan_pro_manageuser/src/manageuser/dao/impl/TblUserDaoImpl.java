/**
 * Copyright(C) 2020 Luvina Software
 * TblUserDaoImpl.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.TblUserDao;
import manageuser.entities.TblUserEntity;
import manageuser.entities.UserInforEntity;
import manageuser.utils.Common;
import manageuser.utils.Constant;

/**
 * Mô tả: Implement TblUserDao để thao tác với DB bảng tbl_user
 * 
 * @author Nguyễn Mạnh Quân
 */
public class TblUserDaoImpl extends BaseDaoImpl implements TblUserDao {
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
	public TblUserEntity getUserByLoginName(String loginName) throws SQLException, IOException, ClassNotFoundException {
		TblUserEntity tblUserEntity = null;
		try {
			if (connection == null || connection.isClosed()) {
				openConnection();
			}
			String sql = "SELECT password, salt FROM tbl_user WHERE rule = ? AND login_name = ?";
			pStmt = connection.prepareStatement(sql);
			int i = 1;
			pStmt.setInt(i++, Constant.RULE_ADMIN);
			pStmt.setString(i++, loginName);
			rs = pStmt.executeQuery();

			if (rs.next()) {
				i = 1;
				tblUserEntity = new TblUserEntity();
				tblUserEntity.setPassword(rs.getString(i++));
				tblUserEntity.setSalt(rs.getString(i++));
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserDaoImpl: getUserByLoginName: " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return tblUserEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getTotalUsers(int groupId, String fullName) throws SQLException, IOException, ClassNotFoundException {
		int count = 0;
		try {
			if (connection == null || connection.isClosed()) {
				openConnection();
			}
			StringBuilder sql = new StringBuilder();
			String tempSql;
			sql.append("SELECT count(full_name) FROM tbl_user WHERE rule = ? ");
			boolean isBlankFullName = Common.checkBlank(fullName);
			if (groupId != 0) {
				sql.append("AND group_id = ? ");
			}
			if (!isBlankFullName) {
				sql.append("AND full_name LIKE ? ");
			}
			tempSql = sql.toString();
			pStmt = connection.prepareStatement(tempSql);
			int i = 1;
			pStmt.setInt(i++, Constant.RULE_USER);
			if (groupId != 0) {
				pStmt.setInt(i++, groupId);
			}
			if (!isBlankFullName) {
				pStmt.setString(i++, "%" + fullName + "%");
			}
			rs = pStmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserDaoImpl: getTotalUsers: " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return count;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserInforEntity> getListUsers(int offset, int limit, int groupId, String fullName, String sortType,
			String sortByFullName, String sortByCodeLevel, String sortByEndDate)
			throws SQLException, ClassNotFoundException, IOException {
		List<UserInforEntity> listUserInfos = new ArrayList<UserInforEntity>();
		List<String> listColumnNames = new ArrayList<String>();

		try {
			if (connection == null || connection.isClosed()) {
				openConnection();
			}
			StringBuilder sql = new StringBuilder();
			String tempSql;
			sql.append("SELECT u.user_id, u.full_name, u.birthday, g.group_name, ");
			sql.append("u.email, u.tel, j.name_level, duj.end_date, duj.total ");
			sql.append("FROM tbl_user u INNER JOIN mst_group g USING (group_id) ");
			sql.append("LEFT JOIN tbl_detail_user_japan duj USING(user_id) ");
			sql.append("LEFT JOIN mst_japan j USING (code_level) ");
			sql.append("WHERE u.rule = ? ");
			boolean isBlankFullName = Common.checkBlank(fullName);
			if (groupId != 0) {
				sql.append("AND group_id = ? ");
			}
			if (!isBlankFullName) {
				sql.append("AND full_name LIKE ? ");
			}
			boolean checkWhiteList = false;
			if (sortType != null && !Common.compareString(sortType, Constant.EMPTY_STRING)) {
				listColumnNames.addAll(Common.getListColumnName(connection, "tbl_user"));
				listColumnNames.addAll(Common.getListColumnName(connection, "tbl_detail_user_japan"));
				listColumnNames.addAll(Common.getListColumnName(connection, "mst_japan"));
				for (String column : listColumnNames) {
					if (Common.compareString(column, sortType)) {
						checkWhiteList = true;
						break;
					}
				}
			}
			if (checkWhiteList) {
				sql.append("ORDER BY ");
				if (Common.compareString(sortType, Constant.SORT_TYPE_FULL_NAME)) {
					sql.append(Constant.SORT_TYPE_FULL_NAME + " " + sortByFullName + ", ");
					sql.append(Constant.SORT_TYPE_CODE_LEVEL + " " + sortByCodeLevel + ", ");
					sql.append(Constant.SORT_TYPE_END_DATE + " " + sortByEndDate + " ");
				} else if (Common.compareString(sortType, Constant.SORT_TYPE_CODE_LEVEL)) {
					sql.append(Constant.SORT_TYPE_CODE_LEVEL + " " + sortByCodeLevel + ", ");
					sql.append(Constant.SORT_TYPE_FULL_NAME + " " + sortByFullName + ", ");
					sql.append(Constant.SORT_TYPE_END_DATE + " " + sortByEndDate + " ");
				} else if (Common.compareString(sortType, Constant.SORT_TYPE_END_DATE)) {
					sql.append(Constant.SORT_TYPE_END_DATE + " " + sortByEndDate + ",");
					sql.append(Constant.SORT_TYPE_FULL_NAME + " " + sortByFullName + ", ");
					sql.append(Constant.SORT_TYPE_CODE_LEVEL + " " + sortByCodeLevel + " ");
				}
			} else {
				sql.append("ORDER BY ");
				sql.append(Constant.SORT_TYPE_FULL_NAME + " " + Constant.SORT_ASC + ", ");
				sql.append(Constant.SORT_TYPE_CODE_LEVEL + " " + Constant.SORT_ASC + ", ");
				sql.append(Constant.SORT_TYPE_END_DATE + " " + Constant.SORT_DESC + " ");
			}

			sql.append("LIMIT ? OFFSET ?;");
			tempSql = sql.toString();
			pStmt = connection.prepareStatement(tempSql);
			int i = 1;
			pStmt.setInt(i++, Constant.RULE_USER);
			if (groupId != 0) {
				pStmt.setInt(i++, groupId);
			}
			if (!isBlankFullName) {
				pStmt.setString(i++, "%" + fullName + "%");
			}
			pStmt.setInt(i++, limit);
			pStmt.setInt(i++, offset);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				int indexColumn = 1;
				UserInforEntity userInforEntity = new UserInforEntity();
				userInforEntity.setUserId(rs.getInt(indexColumn++));
				userInforEntity.setFullName(rs.getString(indexColumn++));
				userInforEntity.setBirthday(rs.getDate(indexColumn++));
				userInforEntity.setGroupName(rs.getString(indexColumn++));
				userInforEntity.setEmail(rs.getString(indexColumn++));
				userInforEntity.setTel(rs.getString(indexColumn++));
				userInforEntity.setNameLevel(rs.getString(indexColumn++));
				userInforEntity.setEndDate(rs.getDate(indexColumn++));
				userInforEntity.setTotal(rs.getInt(indexColumn++));
				listUserInfos.add(userInforEntity);
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserDaoImpl: getListUsers: " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return listUserInfos;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkExistLoginName(String loginName) throws SQLException, IOException, ClassNotFoundException {
		boolean isExist = false;
		try {
			if (connection == null || connection.isClosed()) {
				openConnection();
			}
			String sql = "SELECT user_id FROM tbl_user WHERE login_name = ?;";
			pStmt = connection.prepareStatement(sql);
			int i = 1;
			pStmt.setString(i++, loginName);
			rs = pStmt.executeQuery();

			if (rs.next()) {
				isExist = true;
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserDaoImpl: checkExistLoginName: " + e.getMessage());
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
	public boolean checkExistEmail(int userId, String email) throws SQLException, IOException, ClassNotFoundException {
		boolean isExist = false;
		try {
			if (connection == null || connection.isClosed()) {
				openConnection();
			}
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT login_name FROM tbl_user WHERE email = ?");
			if (userId > 0) {
				sql.append(" AND user_id != ?");
			}
			pStmt = connection.prepareStatement(sql.toString());
			int i = 1;
			pStmt.setString(i++, email);
			if (userId > 0) {
				pStmt.setInt(i++, userId);
			}
			rs = pStmt.executeQuery();

			if (rs.next()) {
				isExist = true;
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserDaoImpl: checkExistEmail: " + e.getMessage());
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
	public int insertUser(TblUserEntity tblUserEntity) throws SQLException {
		int userId = 0;
		try {
			String sql = "INSERT INTO tbl_user(group_id, login_name, password, full_name, full_name_kana, email, tel, birthday, rule, salt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			pStmt = connection.prepareStatement(sql, new String[] { "user_id" });
			int i = 1;
			pStmt.setInt(i++, tblUserEntity.getGroupId());
			pStmt.setString(i++, tblUserEntity.getLoginName());
			pStmt.setString(i++, tblUserEntity.getPassword());
			pStmt.setString(i++, tblUserEntity.getFullName());
			pStmt.setString(i++, tblUserEntity.getFullNameKana());
			pStmt.setString(i++, tblUserEntity.getEmail());
			pStmt.setString(i++, tblUserEntity.getTel());
			pStmt.setDate(i++, new java.sql.Date(tblUserEntity.getBirthday().getTime()));
			pStmt.setInt(i++, Constant.RULE_USER);
			pStmt.setString(i++, tblUserEntity.getSalt());
			pStmt.executeUpdate();
			rs = pStmt.getGeneratedKeys();

			if (rs.next()) {
				userId = rs.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println("TblUserDaoImpl: insertUser: " + e.getMessage());
			throw e;
		}
		return userId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserInforEntity getUserDetailById(int userId) throws SQLException, IOException, ClassNotFoundException {
		UserInforEntity userInforEntity = null;
		try {
			if (connection == null || connection.isClosed()) {
				openConnection();
			}
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT u.login_name, g.group_id, g.group_name, u.full_name, u.full_name_kana, ");
			sql.append("u.birthday, u.email, u.tel, j.code_level, j.name_level, duj.start_date, duj.end_date, duj.total ");
			sql.append("FROM tbl_user u INNER JOIN mst_group g USING (group_id) ");
			sql.append("LEFT JOIN tbl_detail_user_japan duj USING(user_id) ");
			sql.append("LEFT JOIN mst_japan j USING (code_level) ");
			sql.append("WHERE u.user_id = ?;");
			pStmt = connection.prepareStatement(sql.toString());
			int i = 1;
			pStmt.setInt(i++, userId);
			rs = pStmt.executeQuery();

			if (rs.next()) {
				i = 1;
				userInforEntity = new UserInforEntity();
				userInforEntity.setUserId(userId);
				userInforEntity.setLoginName(rs.getString(i++));
				userInforEntity.setGroupId(rs.getInt(i++));
				userInforEntity.setGroupName(rs.getString(i++));
				userInforEntity.setFullName(rs.getString(i++));
				userInforEntity.setFullNameKana(rs.getString(i++));
				userInforEntity.setBirthday(rs.getDate(i++));
				userInforEntity.setEmail(rs.getString(i++));
				userInforEntity.setTel(rs.getString(i++));
				userInforEntity.setCodeLevel(rs.getString(i++));
				userInforEntity.setNameLevel(rs.getString(i++));
				userInforEntity.setStartDate(rs.getDate(i++));
				userInforEntity.setEndDate(rs.getDate(i++));
				userInforEntity.setTotal(rs.getInt(i++));
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserDaoImpl: getUserDetailById: " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return userInforEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkExistUserId(int userId) throws SQLException, IOException, ClassNotFoundException {
		boolean isExist = false;
		try {
			if (connection == null || connection.isClosed()) {
				openConnection();
			}
			String sql = "SELECT login_name FROM tbl_user WHERE user_id = ?;";
			pStmt = connection.prepareStatement(sql);
			int i = 1;
			pStmt.setInt(i++, userId);
			rs = pStmt.executeQuery();

			if (rs.next()) {
				isExist = true;
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserDaoImpl: checkExsistUserId: " + e.getMessage());
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
	public void updateUser(TblUserEntity tblUserEntity) throws SQLException {
		try {
			String sql = "UPDATE tbl_user SET group_id = ?, full_name = ?, full_name_kana = ?, email = ?, tel = ?, birthday = ? WHERE user_id = ?;";
			int i = 1;
			pStmt = connection.prepareStatement(sql);
			pStmt.setInt(i++, tblUserEntity.getGroupId());
			pStmt.setString(i++, tblUserEntity.getFullName());
			pStmt.setString(i++, tblUserEntity.getFullNameKana());
			pStmt.setString(i++, tblUserEntity.getEmail());
			pStmt.setString(i++, tblUserEntity.getTel());
			pStmt.setDate(i++, new java.sql.Date(tblUserEntity.getBirthday().getTime()));
			pStmt.setInt(i++, tblUserEntity.getUserId());
			pStmt.execute();
		} catch (SQLException e) {
			System.out.println("TblUserDaoImpl: updateUser: " + e.getMessage());
			throw e;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUser(int userId) throws SQLException {
		try {
			String sql = "DELETE FROM tbl_user WHERE user_id = ?;";
			int i = 1;
			pStmt = connection.prepareStatement(sql);
			pStmt.setInt(i++, userId);
			pStmt.execute();
		} catch (SQLException e) {
			System.out.println("TblUserDaoImpl: updateUser: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TblUserEntity getRuleByUserId(int userId) throws SQLException, IOException, ClassNotFoundException {
		TblUserEntity tblUserEntity = null;
		try {
			if (connection == null || connection.isClosed()) {
				openConnection();
			}
			String sql = "SELECT rule FROM tbl_user WHERE user_id = ?";
			pStmt = connection.prepareStatement(sql);
			int i = 1;
			pStmt.setInt(i++, userId);
			rs = pStmt.executeQuery();
			if (rs.next()) {
				i = 1;
				tblUserEntity = new TblUserEntity();
				tblUserEntity.setRule(rs.getInt(i++));
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserDaoImpl: getRuleByUserId: " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return tblUserEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int checkAdminByLoginName(String loginName) throws SQLException, IOException, ClassNotFoundException {
		int isAdmin = 0;
		try {
			if (connection == null || connection.isClosed()) {
				openConnection();
			}
			String sql = "SELECT rule FROM tbl_user WHERE login_name = ?";
			pStmt = connection.prepareStatement(sql);
			int i = 1;
			pStmt.setString(i++, loginName);
			rs = pStmt.executeQuery();
			if (rs.next()) {
				i = 1;
				isAdmin = rs.getInt(i++);
			} else {
				isAdmin = -1;
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserDaoImpl: checkAdminByLoginName: " + e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		return isAdmin;
	}
}
