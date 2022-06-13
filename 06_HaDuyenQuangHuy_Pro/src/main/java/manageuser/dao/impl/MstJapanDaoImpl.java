/**
 * Copyright(C) 2020 Luvina Software
 * MstGroupDaoImpl.java, 29/09/2020 HaDuyenQuangHuy
 */
package manageuser.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manageuser.dao.MstJapanDao;
import manageuser.entities.MstJapanEntity;
import manageuser.repository.MstJapanRepository;
import manageuser.utils.Common;

/**
 * Class MstGroupDaoImpl Thực hiện lấy dữ liệu từ DB liên quan đến mstGroup
 * 
 * @author Ha Duyen Quang Huy
 */
@Service
public class MstJapanDaoImpl implements MstJapanDao {

	@Autowired
	private MstJapanRepository mstJapanRepo;

	/**
	 * Lấy tất cả các mstJapan trong bảng mstJapan
	 * 
	 * @return List<MstJapanEntity> 
	 */
	@Override
	public List<MstJapanEntity> getAllMstJapan() {
		return mstJapanRepo.findAll();
	}

	/**
	 * Kiểm tra tồn tại mstJapan trong cơ sở dữ liệu
	 * 
	 * @param String codeLevel
	 * 
	 * @return false/true nếu mstJapan tồn tại / không tồn tại  
	 */
	@Override
	public boolean checkExistMstJapan(String codeLevel) {
		List<MstJapanEntity> listJapan = mstJapanRepo.findAllByCodeLevel(codeLevel);
		if (listJapan.size() != 0) {
			return false;
		}
		return true;
	}

	/**
	 * Lấy codeLevel từ nameLevel
	 * 
	 * @param String nameLevel
	 * 
	 * @return codeLevel 
	 */
	@Override
	public String getCodeLevelFromNameLevel(String nameLevel) {
		List<MstJapanEntity> listJapan = mstJapanRepo.findAllByNameLevel(nameLevel);
		for (MstJapanEntity mstJapan : listJapan) {
			if (Common.compareString(mstJapan.getNameLevel(), nameLevel)) {
				return mstJapan.getCodeLevel();
			}
		}
		return null;
	}

}
