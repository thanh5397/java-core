package manageuser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manageuser.converter.TblUserConverter;
import manageuser.dto.TblUserDTO;
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
		int count = (int) tblUserRepository.countTotalUserByMstGroupEntityAndFullName(groupId,fullName);
		return count;
	}

}
