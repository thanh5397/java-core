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
		mstJapanEntity.setStartDate(mstJapanDTO.getStartDate());
		mstJapanEntity.setEndDate(mstJapanDTO.getEndDate());
		mstJapanEntity.setTotal(mstJapanDTO.getTotal());
		mstJapanEntity.setTblDetailUserJapanEntities(mstJapanDTO.getTblDetailUserJapanEntities());
		return mstJapanEntity;
	}
	public MstJapanDTO toDTO(MstJapanEntity mstJapanEntity) {
		MstJapanDTO mstJapanDTO = new MstJapanDTO();
		mstJapanDTO.setCodeLevel(mstJapanEntity.getCodeLevel());
		mstJapanDTO.setNameLevel(mstJapanEntity.getNameLevel());
		mstJapanDTO.setStartDate(mstJapanEntity.getStartDate());
		mstJapanDTO.setEndDate(mstJapanEntity.getEndDate());
		mstJapanDTO.setTotal(mstJapanEntity.getTotal());
		mstJapanDTO.setTblDetailUserJapanEntities(mstJapanEntity.getTblDetailUserJapanEntities());
		return mstJapanDTO;
	}
}
