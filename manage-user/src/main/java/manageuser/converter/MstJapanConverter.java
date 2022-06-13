package manageuser.converter;

import org.springframework.stereotype.Component;

import manageuser.dto.MstJapanDTO;
import manageuser.entities.MstJapanEntity;
@Component
public class MstJapanConverter {
	public MstJapanEntity toEntity(MstJapanDTO mstJapanDTO) {
		MstJapanEntity mstJapanEntity = new MstJapanEntity();
		mstJapanEntity.setCodeLevel(mstJapanDTO.getCodeLevel());
		mstJapanEntity.setNameLevel(mstJapanDTO.getNameLevel());
		return mstJapanEntity;
	}
	public MstJapanDTO toDTO(MstJapanEntity mstJapanEntity) {
		MstJapanDTO mstJapanDTO = new MstJapanDTO();
		mstJapanDTO.setCodeLevel(mstJapanEntity.getCodeLevel());
		mstJapanDTO.setNameLevel(mstJapanEntity.getNameLevel());
		return mstJapanDTO;
	}
}
