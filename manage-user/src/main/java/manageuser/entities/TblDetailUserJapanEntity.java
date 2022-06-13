package manageuser.entities;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_detail_user_japan")
public class TblDetailUserJapanEntity {
	
	@EmbeddedId
    private TblDetailUserJapanId tblDetailUserJapanId;
	
	@ManyToOne
    @MapsId("codeLevel")
    private MstJapanEntity mstJapanEntity;
 
    @ManyToOne
    @MapsId("userId")
    private TblUserEntity tblUserEntity;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	private int total;
	
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
}
