package manageuser.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import manageuser.entities.TblDetailUserJapanEntity;
import manageuser.entities.TblUserEntity;

public class MstJapanDTO {
	private String codeLevel;
	private String nameLevel;
	private List<TblDetailUserJapanEntity> tblDetailUserJapanEntities = new ArrayList<TblDetailUserJapanEntity>();
	
	public String getCodeLevel() {
		return codeLevel;
	}
	public void setCodeLevel(String codeLevel) {
		this.codeLevel = codeLevel;
	}
	public String getNameLevel() {
		return nameLevel;
	}
	public void setNameLevel(String nameLevel) {
		this.nameLevel = nameLevel;
	}
	public List<TblDetailUserJapanEntity> getTblDetailUserJapanEntities() {
		return tblDetailUserJapanEntities;
	}
	public void setTblDetailUserJapanEntities(List<TblDetailUserJapanEntity> tblDetailUserJapanEntities) {
		this.tblDetailUserJapanEntities = tblDetailUserJapanEntities;
	}
	
}
