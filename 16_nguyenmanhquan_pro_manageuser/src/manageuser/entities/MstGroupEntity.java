/**
 * Copyright(C) 2020 Luvina Software
 * MstGroup.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.entities;

import java.io.Serializable;

/**
 * Mô tả: Bean chứa các thuộc tính của bảng mst_group trong Database
 * @author Nguyễn Mạnh Quân
 */
public class MstGroupEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	private int groupId;
	private String groupName;
	
	/**
	 * Constructor mặc định. 
	 */
	public MstGroupEntity() {
	}

	/**
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
}
