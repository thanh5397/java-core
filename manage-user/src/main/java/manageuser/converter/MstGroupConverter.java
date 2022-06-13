package manageuser.converter;

import org.springframework.stereotype.Component;

import manageuser.dto.MstGroupDTO;
import manageuser.entities.MstGroupEntity;
@Component
public class MstGroupConverter {
	public MstGroupEntity toEntity(MstGroupDTO mstGroupDTO) {
		MstGroupEntity mstGroupEntity = new MstGroupEntity();
		mstGroupEntity.setGroupId(mstGroupDTO.getGroupId());
		mstGroupEntity.setGroupName(mstGroupDTO.getGroupName());
		mstGroupEntity.setTblUserEntities(mstGroupDTO.getTblUserEntities());
		return mstGroupEntity;
	}
	public MstGroupDTO toDTO(MstGroupEntity mstGroupEntity) {
		MstGroupDTO mstGroupDTO = new MstGroupDTO();
		mstGroupDTO.setGroupId(mstGroupEntity.getGroupId());
		mstGroupDTO.setGroupName(mstGroupEntity.getGroupName());
//		mstGroupDTO.setTblUserEntities(mstGroupEntity.getTblUserEntities());
		return mstGroupDTO;
	}
}
