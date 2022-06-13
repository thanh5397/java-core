package manageuser.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="MstGroupEntity")
@Table(name="mst_group")
public class MstGroupEntity {
	
	@Id
	private Integer groupId;
	private String groupName;
	
	@OneToMany(mappedBy = "mstGroupEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TblUserEntity> tblUserEntities = new ArrayList<TblUserEntity>();
	
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
