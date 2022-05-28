package manageuser.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="mst_japan")
public class MstJapanEntity {
	private String codeLevel;
	private String nameLevel;
	
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
}
