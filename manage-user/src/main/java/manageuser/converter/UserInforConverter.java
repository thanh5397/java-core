//package manageuser.converter;
//
//import org.springframework.stereotype.Component;
//
//import manageuser.dto.TblUserDTO;
//import manageuser.dto.UserInforDTO;
//import manageuser.entities.TblUserEntity;
//import manageuser.entities.UserInforEntity;
//
//@Component
//public class UserInforConverter {
//	public UserInforEntity toEntity(UserInforDTO userInforDTO) {
//		UserInforEntity userInforEntity = new UserInforEntity();
//		userInforEntity.setUserId(userInforDTO.getUserId());
//		userInforEntity.setLoginName(userInforDTO.getLoginName());
//		userInforEntity.setGroupId(userInforDTO.getGroupId());
//		userInforEntity.setGroupName(userInforDTO.getGroupId());
//		userInforEntity.setFullName(userInforDTO.getGroupId());
//		userInforEntity.setFullNameKana(userInforDTO.getGroupId());
//		userInforEntity.setEmail(email);(userInforDTO.getGroupId());
//		userInforEntity.setTel(userInforDTO.getGroupId());
//		userInforEntity.setPassword(password);(userInforDTO.getGroupId());
//		userInforEntity.setRePassword(rePassword);(userInforDTO.getGroupId());
//		userInforEntity.setSalt(salt);(userInforDTO.getGroupId());
//		userInforEntity.setCodeLevel(codeLevel);(userInforDTO.getGroupId());
//		userInforEntity.setNameLevel(nameLevel);(userInforDTO.getGroupId());
//		userInforEntity.setStrTotal(strTotal);(startDate);(userInforDTO.getGroupId());
//		userInforEntity.setBirthday(birthday);(userInforDTO.getGroupId());
//		userInforEntity.setStartDate(startDate);(userInforDTO.getGroupId());
//		userInforEntity.setEndDate(endDate);(userInforDTO.getGroupId());
//		userInforEntity.setArrBirthday(arrBirthday);(userInforDTO.getGroupId());
//		userInforEntity.setArrStartDate(arrStartDate);(userInforDTO.getGroupId());
//		userInforEntity.setEndDate(endDate);(arrEndDate);(userInforDTO.getGroupId());
//		userInforEntity.setTotal(userInforDTO.getTotal());
//		return tblUserEntity;
//	}
//	public TblUserDTO toDTO(TblUserEntity tblUserEntity) {
//		
//		return tblUserDTO;
//	}
//}
