/**
 * Copyright(C) 2020 Luvina Software
 * LoginController.java, 29/07/2020 HaDuyenQuangHuy
 */
package manageuser.logics.impl;

/**
 * Class TblUserLogicImpl Xử lý các logic liên quan đến tblUser
 *
 * @author HaDuyenQuangHuy
 */
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manageuser.dao.TblDetailUserJapanDao;
import manageuser.dao.TblUserDao;
import manageuser.entities.TblDetailUserJapanEntity;
import manageuser.entities.TblUserEntity;
import manageuser.entities.UserInfoEntity;
import manageuser.logics.TblUserLogic;
import manageuser.repository.TblDetailUserJapanRepository;
import manageuser.repository.TblUserRepository;
import manageuser.utils.Common;

@Service
public class TblUserLogicImpl implements TblUserLogic {

	@Autowired
	TblUserDao userDao;

	@Autowired
	TblDetailUserJapanDao userDetail;

	@Autowired
	TblUserRepository userRepo;

	@Autowired
	TblDetailUserJapanRepository userDetailRepo;

	/**
	 * Kiểm tra password và loginName có tồn tại trong cơ sở dữ liệu
	 *
	 * @param String: loginName - Giá trị của loginName 
	 * @param String: password - Giá trị của passowrd 
	 * @return boolean true/false nếu login name trùng/không trùng với password
	 *         trong cơ sở dữ liệu
	 */
	@Override
	public Boolean checkExistLogin(String loginName, String password)
			throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		List<TblUserEntity> listUser = userDao.getTblUserByLoginName(loginName);
		for (TblUserEntity tblUser : listUser) {
			if (Common.compareString(Common.encryptPassword(password, tblUser.getSalt()), tblUser.getPassword())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Xử lý logic của tạo mới một user trong DB
	 * 
	 * @param userInfoEntity userInfo user để thêm mới vào cơ sở dữ liệu
	 * 
	 * @return true/false nếu tạo mới thành công/ không thành công
	 */
	@Transactional
	@Override
	public boolean createUser(UserInfoEntity userInfo) {
		try {
			TblUserEntity newUser = userRepo.save(userDao.getTblUserFromUserInfo(userInfo));
			if (!Common.checkEmpty(userInfo.getNameLevel())) {
				userRepo.flush();
				userInfo.setUserId(newUser.getUserId());
				userDetailRepo.save(userDetail.getTblDetaiUserJapanFromUserInfo(userInfo));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Xử lý logic của việc cập nhật user trong cơ sở dữ liệu
	 * 
	 * @param UserInfoEntity userInfo: giá trị userInfo để update vào cơ sở dữ liệu
	 * 
	 * @return true/false nếu việc cập nhật thành công/ không thành công
	 */
	@Transactional
	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		try {
			userDetailRepo.deleteByUserId(userId);
			userRepo.deleteByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Xử lý logic của việc deltete user trong cơ sở dữ liệu
	 * 
	 * @param int iD: iD của user cần xóa
	 * 
	 * @return true/false nếu việc delete thành công/ không thành công
	 */
	@Transactional
	@Override
	public boolean updateUser(UserInfoEntity userInfo) {
		boolean checkJapanUserEntered = false;
		boolean checkJapanUserOnDB = false;
		try {
			TblUserEntity tblUser = userDao.getTblUserFromUserInfo(userInfo);
			TblDetailUserJapanEntity tblUserDetail = userDetail.getTblDetaiUserJapanFromUserInfo(userInfo);
			int userId = userInfo.getUserId();
			if (!Common.checkEmpty(userInfo.getNameLevel())) {
				checkJapanUserEntered = true;
			}
			if (userDetailRepo.findOneByUserId(userId) != null) {
				checkJapanUserOnDB = true;
			}
			userRepo.save(tblUser);
			if (checkJapanUserOnDB && checkJapanUserEntered) {
				userDetailRepo.deleteByUserId(tblUserDetail.getUserId());
				userDetailRepo.save(tblUserDetail);
			} else if (checkJapanUserOnDB && !checkJapanUserEntered) {
				userDetailRepo.deleteByUserId(tblUserDetail.getUserId());
			} else if (!checkJapanUserOnDB && checkJapanUserEntered) {
				userDetailRepo.save(tblUserDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
