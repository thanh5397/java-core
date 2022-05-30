/**
 * Copyright(C) 2020 Luvina Software
 * TblUserLogicImpl.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.logics.impl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.TblDetailUserJapanDao;
import manageuser.dao.TblUserDao;
import manageuser.dao.impl.TblDetailUserJapanDaoImpl;
import manageuser.dao.impl.TblUserDaoImpl;
import manageuser.entities.TblDetailUserJapanEntity;
import manageuser.entities.TblUserEntity;
import manageuser.entities.UserInforEntity;
import manageuser.logics.TblUserLogic;
import manageuser.utils.Common;
import manageuser.utils.Constant;

/**
 * Mô tả: Implement TblUserLogin để xử lý logic liên quan đến thông tin của user
 * 
 * @author Nguyễn Mạnh Quân
 */
public class TblUserLogicImpl implements TblUserLogic {
	TblUserDao tblUserDao = new TblUserDaoImpl();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existLogin(String loginName, String password)
			throws ClassNotFoundException, SQLException, IOException, NoSuchAlgorithmException {
		boolean isExist = false;
		try {
			TblUserEntity tblUserEntity = tblUserDao.getUserByLoginName(loginName);
			if (tblUserEntity != null) {
				String salt = tblUserEntity.getSalt();
				String passwordChecked = tblUserEntity.getPassword();
				String passwordEncrypted = Common.encryptPassword(password, salt);
				isExist = Common.compareString(passwordEncrypted, passwordChecked);
			}
		} catch (SQLException | ClassNotFoundException | IOException | NoSuchAlgorithmException e) {
			System.out.println("TblUserLogicImpl: existLogin: " + e.getMessage());
			throw e;
		}
		return isExist;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getTotalUsers(int groupId, String fullName) throws ClassNotFoundException, SQLException, IOException {
		int count = 0;
		try {
			String tempFullName;
			if (fullName != null) {
				tempFullName = Common.replaceWildcard(fullName);
			} else {
				tempFullName = Constant.EMPTY_STRING;
			}
			count = tblUserDao.getTotalUsers(groupId, tempFullName);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserLogicImpl: getTotalUsers: " + e.getMessage());
			throw e;
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
		try {
			String tempFullName;
			if (fullName != null) {
				tempFullName = Common.replaceWildcard(fullName);
			} else {
				tempFullName = Constant.EMPTY_STRING;
			}
			listUserInfos = tblUserDao.getListUsers(offset, limit, groupId, tempFullName, sortType, sortByFullName,
					sortByCodeLevel, sortByEndDate);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserLogicImpl: getListUsers: " + e.getMessage());
			throw e;
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
			isExist = tblUserDao.checkExistLoginName(loginName);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserLogicImpl: checkExistLoginName: " + e.getMessage());
			throw e;
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
			isExist = tblUserDao.checkExistEmail(userId, email);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserLogicImpl: checkExistEmail: " + e.getMessage());
			throw e;
		}
		return isExist;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean createUser(UserInforEntity userInforEntity) throws ClassNotFoundException, SQLException, IOException, NoSuchAlgorithmException {
		Connection conn = null;
		boolean isCreated = false;
		try {
			tblUserDao.openConnection();
			conn = tblUserDao.getConnection();
			conn.setAutoCommit(false);
			TblUserEntity tblUserEntity = new TblUserEntity();
			tblUserEntity.setGroupId(userInforEntity.getGroupId());
			tblUserEntity.setLoginName(userInforEntity.getLoginName());
			String salt = Common.createSalt();
			String password = Common.encryptPassword(userInforEntity.getPassword(), salt);
			tblUserEntity.setPassword(password);
			tblUserEntity.setFullName(userInforEntity.getFullName());
			tblUserEntity.setFullNameKana(userInforEntity.getFullNameKana());
			tblUserEntity.setEmail(userInforEntity.getEmail());
			tblUserEntity.setTel(userInforEntity.getTel());
			tblUserEntity.setBirthday(userInforEntity.getBirthday());
			tblUserEntity.setSalt(salt);
			int userId = tblUserDao.insertUser(tblUserEntity);
			
			String codeLevel = userInforEntity.getCodeLevel();
			
			if (!Common.compareString(Constant.STRING_VALUE_ZERO, codeLevel)) {
				TblDetailUserJapanDao tblDetailUserJapanDao = new TblDetailUserJapanDaoImpl();
				TblDetailUserJapanEntity tblDetailUserJapanEntity = new TblDetailUserJapanEntity();
				tblDetailUserJapanDao.setConnection(conn);
				tblDetailUserJapanEntity.setUserId(userId);
				tblDetailUserJapanEntity.setCodeLevel(codeLevel);
				tblDetailUserJapanEntity.setStartDate(userInforEntity.getStartDate());
				tblDetailUserJapanEntity.setEndDate(userInforEntity.getEndDate());
				tblDetailUserJapanEntity.setTotal(userInforEntity.getTotal());
				tblDetailUserJapanDao.insertDetailUserJapan(tblDetailUserJapanEntity);
			}
			isCreated = true;
			conn.commit();
		} catch (ClassNotFoundException | SQLException | IOException | NoSuchAlgorithmException e) {
			conn.rollback();
			System.out.println("TblUserLogicImpl: createUser: " + e.getMessage());
			throw e;
		} finally {
			conn.setAutoCommit(true);
			conn.close();
			tblUserDao.closeConnection();
		}
		return isCreated;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserInforEntity getUserDetailById(int userId) throws SQLException, IOException, ClassNotFoundException {
		UserInforEntity userInforEntity = null;
		try {
			userInforEntity = tblUserDao.getUserDetailById(userId);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println("TblUserLogicImpl: getUserDetailById: " + e.getMessage());
			throw e;
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
			isExist = tblUserDao.checkExistUserId(userId);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("TblUserLogicImpl: checkExistUserId: " + e.getMessage());
			throw e;
		}
		return isExist;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateUserInfor(UserInforEntity userInforEntity, boolean isExistDetailUserJapan)
			throws ClassNotFoundException, SQLException, IOException {
		boolean isUpdated = false;
		Connection conn = null;
		try {
			tblUserDao.openConnection();
			conn = tblUserDao.getConnection();
			conn.setAutoCommit(false);
			int userId = userInforEntity.getUserId();
			TblUserEntity tblUserEntity = new TblUserEntity();
			tblUserEntity.setGroupId(userInforEntity.getGroupId());
			tblUserEntity.setFullName(userInforEntity.getFullName());
			tblUserEntity.setFullNameKana(userInforEntity.getFullNameKana());
			tblUserEntity.setEmail(userInforEntity.getEmail());
			tblUserEntity.setTel(userInforEntity.getTel());
			tblUserEntity.setBirthday(userInforEntity.getBirthday());
			tblUserEntity.setUserId(userId);
			tblUserDao.updateUser(tblUserEntity);
			
			TblDetailUserJapanDao tblDetailUserJapanDao = new TblDetailUserJapanDaoImpl();
			tblDetailUserJapanDao.setConnection(conn);
			String codeLevel = userInforEntity.getCodeLevel();
			if (!Common.compareString(Constant.STRING_VALUE_ZERO, codeLevel)) {
				TblDetailUserJapanEntity tblDetailUserJapanEntity = new TblDetailUserJapanEntity();
				tblDetailUserJapanEntity.setCodeLevel(codeLevel);
				tblDetailUserJapanEntity.setStartDate(userInforEntity.getStartDate());
				tblDetailUserJapanEntity.setEndDate(userInforEntity.getEndDate());
				tblDetailUserJapanEntity.setTotal(userInforEntity.getTotal());
				tblDetailUserJapanEntity.setUserId(userId);
				if (isExistDetailUserJapan) {
					tblDetailUserJapanDao.updateDetailUserJapan(tblDetailUserJapanEntity);
				} else {
					tblDetailUserJapanDao.insertDetailUserJapan(tblDetailUserJapanEntity);
				}
			} else {
				tblDetailUserJapanDao.deleteDetailUserJapan(userId);
			}
			isUpdated = true;
			conn.commit();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			conn.rollback();
			System.out.println("TblUserLogicImpl: updateUserInfor: " + e.getMessage());
			throw e;
		} finally {
			conn.setAutoCommit(true);
			conn.close();
			tblUserDao.closeConnection();
		}
		return isUpdated;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteUserInfor(int userId) throws ClassNotFoundException, SQLException, IOException {
		boolean isDeleted = false;
		Connection conn = null;
		try {
			tblUserDao.openConnection();
			conn = tblUserDao.getConnection();
			conn.setAutoCommit(false);
			TblDetailUserJapanDao tblDetailUserJapanDao = new TblDetailUserJapanDaoImpl();
			tblDetailUserJapanDao.setConnection(conn);
			tblDetailUserJapanDao.deleteDetailUserJapan(userId);
			tblUserDao.deleteUser(userId);
			isDeleted = true;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			conn.rollback();
			System.out.println("TblUserLogicImpl: deleteUserInfor: " + e.getMessage());
			throw e;
		} finally {
			conn.setAutoCommit(true);
			conn.close();
			tblUserDao.closeConnection(); 
		}
		return isDeleted;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TblUserEntity getRuleByUserId(int userId) throws SQLException, IOException, ClassNotFoundException {
		TblUserEntity tblUserEntity = null;
		try {
			tblUserEntity = tblUserDao.getRuleByUserId(userId);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println("TblUserLogicImpl: getRuleByUserId: " + e.getMessage());
			throw e;
		}
		return tblUserEntity;
	}
}
