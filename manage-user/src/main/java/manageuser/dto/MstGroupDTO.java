package manageuser.dto;

import java.util.List;

import manageuser.entities.TblUserEntity;

public class MstGroupDTO {
	private Integer groupId;
	private String groupName;
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
