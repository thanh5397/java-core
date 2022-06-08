package manageuser.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mst_japan")
public class MstJapanEntity {
	
	@Id
	private String codeLevel;
	private String nameLevel;
	
    @OneToMany(
            mappedBy = "mst_japan",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
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
