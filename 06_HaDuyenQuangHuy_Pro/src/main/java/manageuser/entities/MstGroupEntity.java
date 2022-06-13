package manageuser.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "mstGroup")
@Table(name = "mst_group")
public class MstGroupEntity implements Serializable {
	/**
	 * JavaBean MstGroupEntity
	 * 
	 * Ha Duyen Quang Huy
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "group_id")
	int groupId;
	@Column(name = "group_name")
	String groupName;

	/**
	 * @return the group_id
	 */
	public int getGroupId() {
		return groupId;
	}

	/**
	 * @param group_id the group_id to set
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the group_name
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param group_name the group_name to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
