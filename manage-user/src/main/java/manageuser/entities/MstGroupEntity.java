package manageuser.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mst_group")
public class MstGroupEntity {
	
	@Id
	private Integer groupId;
	private String groupName;
	
	@OneToMany(mappedBy = "mst_group", cascade = CascadeType.ALL)
	private List<TblUserEntity> tblUserEntities;
	
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<TblUserEntity> getTblUserEntities() {
		return tblUserEntities;
	}
	public void setTblUserEntities(List<TblUserEntity> tblUserEntities) {
		this.tblUserEntities = tblUserEntities;
	}
}
