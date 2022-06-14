package manageuser.dto;

import java.util.Date;

import manageuser.entities.MstJapanEntity;
import manageuser.entities.TblDetailUserJapanId;
import manageuser.entities.TblUserEntity;

public class TblDetailUserJapanDTO {
	private TblDetailUserJapanId tblDetailUserJapanId;
	private MstJapanEntity mstJapanEntity;
	private TblUserEntity tblUserEntity;
	private Date startDate;
	private Date endDate;
	private int total;
	
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
	public TblDetailUserJapanId getTblDetailUserJapanId() {
		return tblDetailUserJapanId;
	}
	public void setTblDetailUserJapanId(TblDetailUserJapanId tblDetailUserJapanId) {
		this.tblDetailUserJapanId = tblDetailUserJapanId;
	}
	public MstJapanEntity getMstJapanEntity() {
		return mstJapanEntity;
	}
	public void setMstJapanEntity(MstJapanEntity mstJapanEntity) {
		this.mstJapanEntity = mstJapanEntity;
	}
	public TblUserEntity getTblUserEntity() {
		return tblUserEntity;
	}
	public void setTblUserEntity(TblUserEntity tblUserEntity) {
		this.tblUserEntity = tblUserEntity;
	}
}
