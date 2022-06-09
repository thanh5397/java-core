package manageuser.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="tbl_detail_user_japan")
public class TblDetailUserJapanEntity {
	
	@EmbeddedId
    private TblDetailUserJapanId id = new TblDetailUserJapanId();
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
	private TblUserEntity tblUserEntity;
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("codeLevel")
	private MstJapanEntity mstJapanEntity;
	
	
	
	public TblDetailUserJapanId getId() {
		return id;
	}
	public void setId(TblDetailUserJapanId id) {
		this.id = id;
	}
	public TblUserEntity getTblUserEntity() {
		return tblUserEntity;
	}
	public void setTblUserEntity(TblUserEntity tblUserEntity) {
		this.tblUserEntity = tblUserEntity;
	}
	public MstJapanEntity getMstJapanEntity() {
		return mstJapanEntity;
	}
	public void setMstJapanEntity(MstJapanEntity mstJapanEntity) {
		this.mstJapanEntity = mstJapanEntity;
	}
}
