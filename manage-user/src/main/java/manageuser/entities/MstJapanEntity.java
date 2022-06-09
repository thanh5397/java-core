package manageuser.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="mst_japan")
public class MstJapanEntity {
	
	@Id
	private String codeLevel;
	private String nameLevel;
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	private int total;
	
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
