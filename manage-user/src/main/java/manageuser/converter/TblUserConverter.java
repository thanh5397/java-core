package manageuser.converter;

import org.springframework.stereotype.Component;

import manageuser.dto.TblUserDTO;
import manageuser.entities.TblUserEntity;

@Component
public class TblUserConverter {
	public TblUserEntity toEntity(TblUserDTO tblUserDTO) {
		TblUserEntity tblUserEntity = new TblUserEntity();
		tblUserEntity.setUserId(tblUserDTO.getUserId());
		tblUserEntity.setGroupId(tblUserDTO.getGroupId());
		tblUserEntity.setLoginName(tblUserDTO.getLoginName());
		tblUserEntity.setPassword(tblUserDTO.getPassword());
		tblUserEntity.setFullName(tblUserDTO.getFullName());
		tblUserEntity.setFullNameKana(tblUserDTO.getFullNameKana());
		tblUserEntity.setEmail(tblUserDTO.getEmail());
		tblUserEntity.setTel(tblUserDTO.getTel());
		tblUserEntity.setBirthday(tblUserDTO.getBirthday());
		tblUserEntity.setRule(tblUserDTO.getRule());
		tblUserEntity.setSalt(tblUserDTO.getSalt());
		tblUserEntity.setMstJapans(tblUserDTO.getMstJapans());
		return tblUserEntity;
	}
	public TblUserDTO toDTO(TblUserEntity tblUserEntity) {
		TblUserDTO tblUserDTO = new TblUserDTO();
		tblUserDTO.setUserId(tblUserEntity.getUserId());
		tblUserDTO.setGroupId(tblUserEntity.getGroupId());
		tblUserDTO.setLoginName(tblUserEntity.getLoginName());
		tblUserDTO.setPassword(tblUserEntity.getPassword());
		tblUserDTO.setFullName(tblUserEntity.getFullName());
		tblUserDTO.setFullNameKana(tblUserEntity.getFullNameKana());
		tblUserDTO.setEmail(tblUserEntity.getEmail());
		tblUserDTO.setTel(tblUserEntity.getTel());
		tblUserDTO.setBirthday(tblUserEntity.getBirthday());
		tblUserDTO.setRule(tblUserEntity.getRule());
		tblUserDTO.setSalt(tblUserEntity.getSalt());
		tblUserDTO.setMstJapans(tblUserEntity.getMstJapans());
		return tblUserDTO;
	}
}
