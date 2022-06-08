package manageuser.dto;

import java.util.List;

import manageuser.entities.TblDetailUserJapanEntity;

public class MstJapanDTO {
	private String codeLevel;
	private String nameLevel;
	private List<TblDetailUserJapanEntity> tblUsers;
	
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
	public List<TblDetailUserJapanEntity> getTblUsers() {
		return tblUsers;
	}
	public void setTblUsers(List<TblDetailUserJapanEntity> tblUsers) {
		this.tblUsers = tblUsers;
	}
}
