package manageuser.converter;

import org.springframework.stereotype.Component;

import manageuser.dto.TblDetailUserJapanDTO;
import manageuser.entities.TblDetailUserJapanEntity;
@Component
public class TblDetailUserJapanConverter {
	public TblDetailUserJapanEntity toEntity(TblDetailUserJapanDTO tblDetailUserJapanDTO) {
		TblDetailUserJapanEntity tblDetailUserJapanEntity = new TblDetailUserJapanEntity();
		tblDetailUserJapanEntity.setStartDate(tblDetailUserJapanDTO.getStartDate());
		tblDetailUserJapanEntity.setEndDate(tblDetailUserJapanDTO.getEndDate());
		tblDetailUserJapanEntity.setTotal(tblDetailUserJapanDTO.getTotal());
		return tblDetailUserJapanEntity;
	}
	public TblDetailUserJapanDTO toDTO(TblDetailUserJapanEntity tblDetailUserJapanEntity) {
		TblDetailUserJapanDTO tblDetailUserJapanDTO = new TblDetailUserJapanDTO();
		tblDetailUserJapanDTO.setStartDate(tblDetailUserJapanEntity.getStartDate());
		tblDetailUserJapanDTO.setEndDate(tblDetailUserJapanEntity.getEndDate());
		tblDetailUserJapanDTO.setTotal(tblDetailUserJapanEntity.getTotal());
		return tblDetailUserJapanDTO;
	}
}
