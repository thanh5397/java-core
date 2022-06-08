package manageuser.converter;

import manageuser.dto.MstJapanDTO;
import manageuser.entities.MstJapanEntity;

public class MstJapanConverter {
	public MstJapanEntity toEntity(MstJapanDTO mstJapanDTO) {
		MstJapanEntity mstJapanEntity = new MstJapanEntity();
		mstJapanEntity.setCodeLevel(mstJapanDTO.getCodeLevel());
		mstJapanEntity.setNameLevel(mstJapanDTO.getNameLevel());
		mstJapanEntity.setTblUsers(mstJapanDTO.getTblUsers());
		return mstJapanEntity;
	}
	public MstJapanDTO toDTO(MstJapanEntity mstJapanEntity) {
		MstJapanDTO mstJapanDTO = new MstJapanDTO();
		mstJapanDTO.setCodeLevel(mstJapanEntity.getCodeLevel());
		mstJapanDTO.setNameLevel(mstJapanEntity.getNameLevel());
		mstJapanDTO.setTblUsers(mstJapanEntity.getTblUsers());
		return mstJapanDTO;
	}
}
