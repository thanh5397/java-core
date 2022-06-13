/**
 * Copyright(C) 2020  Luvina software
 * TblDetailUserJapanDaoImpl.java, 29/09/2020 HuyHDQ
 */
package manageuser.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manageuser.dao.TblDetailUserJapanDao;
import manageuser.entities.TblDetailUserJapanEntity;
import manageuser.entities.UserInfoEntity;

/**
 * Thực hiện lấy dữ liệu từ DB liên quan đến TblDetailUserJapan
 * @author Ha Duyen Quang Huy
 */
@Service
public class TblDetaiUserJapanDaoImpl implements TblDetailUserJapanDao {

	@Autowired
	MstJapanDaoImpl japanDao;
	

	/**
	 * Tạo mới một đối tượng TblDetailUserJapan từ userInfo
	 * 
	 * @param UserInfoEntity userInfo: đối tương userInfo nhập vào
	 * 
	 * @return TblDetailUserJapan tblDetailUserJapan: đối tượng tblUser mới được tạo
	 */
	@Override
	public TblDetailUserJapanEntity getTblDetaiUserJapanFromUserInfo(UserInfoEntity userInfo) {
		TblDetailUserJapanEntity tblDetailUserJapan = new TblDetailUserJapanEntity();
		tblDetailUserJapan.setUserId(userInfo.getUserId());
		tblDetailUserJapan.setStartDate(userInfo.getStartDate());
		tblDetailUserJapan.setCodeLevel(japanDao.getCodeLevelFromNameLevel(userInfo.getNameLevel()));
		tblDetailUserJapan.setEndDate(userInfo.getEndDate());
		tblDetailUserJapan.setTotal(userInfo.getTotal());

		return tblDetailUserJapan;
	}
}
