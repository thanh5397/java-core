/**
 * Copyright(C) 2020 Luvina Software
 * MstGroupDaoImpl.java, 29/09/2020 HaDuyenQuangHuy
 */
package manageuser.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manageuser.dao.MstGroupDao;
import manageuser.entities.MstGroupEntity;
import manageuser.repository.MstGroupRepository;
import manageuser.utils.Common;

/**
 * Class MstGroupDaoImpl Thực hiện lấy dữ liệu từ DB liên quan đến mstGroup
 * 
 * @author Ha Duyen Quang Huy
 */
@Service
public class MstGroupDaoImpl implements MstGroupDao {

	@Autowired
	private MstGroupRepository mstGroupRepo;

	/**
	 * Lấy tất cả các group trong bảng mst_group
	 * 
	 * @return listGroup
	 */
	@Override
	public List<MstGroupEntity> getAllMstGroup() {
		return mstGroupRepo.findAll();
	}

	/**
	 * Kiểm tra group tồn tại trong bảng csdl
	 * 
	 * @param String groupName
	 * 
	 * @return true/false nếu group tồn tại/ không tồn tại 
	 */
	@Override
	public boolean checkExistMstGroup(String groupName) {
		List<MstGroupEntity> listGroup = mstGroupRepo.findAllByGroupName(groupName);
		if (listGroup.size() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * Lấy groupId từ groupName
	 * 
	 * @param String groupName
	 * 
	 * @return groupId; 
	 */
	@Override
	public int getGroupIdFromGroupName(String groupName) {
		List<MstGroupEntity> listGroup = mstGroupRepo.findAllByGroupName(groupName);
		for (MstGroupEntity mstGroup : listGroup) {
			if (Common.compareString(mstGroup.getGroupName(), groupName)) {
				return mstGroup.getGroupId();
			}
		}
		return 0;
	}

}
