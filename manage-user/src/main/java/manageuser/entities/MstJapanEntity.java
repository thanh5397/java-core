package manageuser.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="MstJapanEntity")
@Table(name="mst_japan")
public class MstJapanEntity {
	@Id
    @Column(name = "code_level",length = 255)
	private String codeLevel;
	@Column(length = 255)
	private String nameLevel;
	
	@OneToMany(mappedBy = "mstJapanEntity")
    List<TblDetailUserJapanEntity> tblDetailUserJapanEntities;
	
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
