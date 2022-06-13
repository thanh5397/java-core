package manageuser.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import manageuser.entities.TblDetailUserJapanEntity;
import manageuser.entities.TblUserEntity;

public class MstJapanDTO {
	private String codeLevel;
	private String nameLevel;
	private Date startDate;
	private Date endDate;
	private int total;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<TblDetailUserJapanEntity> getTblDetailUserJapanEntities() {
		return tblDetailUserJapanEntities;
	}
	public void setTblDetailUserJapanEntities(List<TblDetailUserJapanEntity> tblDetailUserJapanEntities) {
		this.tblDetailUserJapanEntities = tblDetailUserJapanEntities;
	}
	
}
