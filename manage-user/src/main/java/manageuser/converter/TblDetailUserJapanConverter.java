package manageuser.converter;

import manageuser.dto.TblDetailUserJapanDTO;
import manageuser.entities.TblDetailUserJapanEntity;

public class TblDetailUserJapanConverter {
	public TblDetailUserJapanEntity toEntity(TblDetailUserJapanDTO tblDetailUserJapanDTO) {
		TblDetailUserJapanEntity tblDetailUserJapanEntity = new TblDetailUserJapanEntity();
		tblDetailUserJapanEntity.setUserId(tblDetailUserJapanDTO.getUserId());
		tblDetailUserJapanEntity.setCodeLevel(tblDetailUserJapanDTO.getCodeLevel());
		tblDetailUserJapanEntity.setStartDate(tblDetailUserJapanDTO.getStartDate());
		tblDetailUserJapanEntity.setEndDate(tblDetailUserJapanDTO.getEndDate());
		tblDetailUserJapanEntity.setTotal(tblDetailUserJapanDTO.getTotal());
		return tblDetailUserJapanEntity;
	}
	public TblDetailUserJapanDTO toDTO(TblDetailUserJapanEntity tblDetailUserJapanEntity) {
		TblDetailUserJapanDTO tblDetailUserJapanDTO = new TblDetailUserJapanDTO();
		tblDetailUserJapanDTO.setUserId(tblDetailUserJapanEntity.getUserId());
		tblDetailUserJapanDTO.setCodeLevel(tblDetailUserJapanEntity.getCodeLevel());
		tblDetailUserJapanDTO.setStartDate(tblDetailUserJapanEntity.getStartDate());
		tblDetailUserJapanDTO.setEndDate(tblDetailUserJapanEntity.getEndDate());
		tblDetailUserJapanDTO.setTotal(tblDetailUserJapanEntity.getTotal());
		return tblDetailUserJapanDTO;
	}
}
