package manageuser.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="mst_group")
public class MstGroupEntity {
	private int groupId;
	private String groupName;
}
