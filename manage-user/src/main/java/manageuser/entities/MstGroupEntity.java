package manageuser.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="MstGroupEntity")
@Table(name="mst_group")
public class MstGroupEntity {
	
	@Id
	@Column(name="group_id")
	private Integer groupId;
	@Column(name="group_name")
	private String groupName;
	
	@OneToMany(mappedBy = "mstGroupEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
