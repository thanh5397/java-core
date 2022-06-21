package manageuser.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import manageuser.converter.MstGroupConverter;
import manageuser.converter.TblUserConverter;
import manageuser.dto.TblUserDTO;
import manageuser.dto.UserInforDTO;
import manageuser.entities.TblUserEntity;
import manageuser.repository.TblUserRepository;
import manageuser.service.ITblUserService;
import manageuser.utils.Common;

@Service
public class TblUserServiceImpl implements ITblUserService {
	
	@Autowired
	TblUserRepository tblUserRepository;
	
	@Autowired
	TblUserConverter tblUserConverter;
	
	@Autowired
	MstGroupConverter mstGroupConverter;

	@Override
	public boolean existTblUser(String loginName, String password) {
		TblUserDTO tblUserDTO = new TblUserDTO();
		TblUserEntity tblUserEntity = tblUserRepository.findUserByLoginName(loginName);
		boolean isExist = false;
		
		try {
			if (tblUserEntity != null) {
				tblUserDTO = tblUserConverter.toDTO(tblUserEntity);
//				String salt = tblUserDTO.getSalt();
				String passwordChecked = tblUserDTO.getPassword();
//				String passwordEncrypted = Common.encryptPassword(password, salt);
				isExist = Common.compareString(password, passwordChecked);
			}
		} catch (Exception e) {
			System.out.println("TblUserServiceImpl: existTblUser: " + e.getMessage());
			throw e;
		}
		
		return isExist;
	}

	@Override
	public int getCountTotalUser(int groupId, String fullName) {
//		MstGroupEntity mstGroupEntity = new MstGroupEntity();
//		mstGroupEntity = mstGroupConverter.toEntity(mstGroupDTO);
		long count = tblUserRepository.countTotalUserByMstGroupEntity_groupIdAndFullName(groupId,fullName);
		int i = 0;
		return i;
	}

	@Override
	public List<UserInforDTO> getListUsers(int rule, int offset, int limit, int groupId, String fullName,
			String sortType, String sortByFullName, String sortByCodeLevel, String sortByEndDate) {
		List<UserInforDTO> listUserInfor = new ArrayList<UserInforDTO>();
		try {
			Sort sortable = null;
			Pageable pageable = null;
			Order previousOrder = null;
			if(sortType.equals("fullName")) {
				sortable = Sort.by(
						sortByFullName.equals("ASC") ? Sort.Order.desc("fullName") : Sort.Order.asc("fullName"),
						Sort.Order.desc("codeLevel"),
						Sort.Order.desc("endDate"));
			} else if(sortType.equals("codeLevel")) {
				previousOrder = sortable.getOrderFor(sortType);
				sortable = Sort.by(
						sortByCodeLevel.equals("ASC") ? Sort.Order.desc("codeLevel") : Sort.Order.asc("codeLevel"),
						Sort.Order.desc("fullName"),
						Sort.Order.desc("endDate"));
			} else if(sortType.equals("endDate")) {
				previousOrder = sortable.getOrderFor(sortType);
				sortable = Sort.by(
						sortByEndDate.equals("ASC") ? Sort.Order.desc("endDate") : Sort.Order.asc("endDate"),
						Sort.Order.desc("fullName"),
						Sort.Order.desc("codeLevel"));
			} else {
				sortable = Sort.by(Sort.Order.asc("fullName"),Sort.Order.asc("codeLevel"),Sort.Order.desc("endDate"));
			}
			pageable = PageRequest.of(0, limit,sortable);
			listUserInfor = tblUserRepository.getListUsers(rule, offset, limit, groupId, fullName);
		} catch (Exception e) {
			System.out.println("TblUserLogicImpl: getListUsers: " + e.getMessage());
			throw e;
		}
		return listUserInfor;
	}

}
