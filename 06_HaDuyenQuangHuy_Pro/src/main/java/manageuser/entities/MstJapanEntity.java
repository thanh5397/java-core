/**
 * Copyright(C) 2020
 * Luvina
 * 06_haduyenquanghuy_pro_manageuser
 * 10:57:30 AM
 * Ha Duyen Quang Huy
 */
package manageuser.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JavaBean MstJapanEntity
 * 
 * @author Ha Duyen Quang Huy
 */

@Entity(name = "mstJapan")
@Table(name = "mst_japan")
public class MstJapanEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code_level")
	String codeLevel;
	String nameLevel;

	/**
	 * @return the codeLevel
	 */
	public String getCodeLevel() {
		return codeLevel;
	}

	/**
	 * @param codeLevel the codeLevel to set
	 */
	public void setCodeLevel(String codeLevel) {
		this.codeLevel = codeLevel;
	}

	/**
	 * @return the nameLevel
	 */
	public String getNameLevel() {
		return nameLevel;
	}

	/**
	 * @param nameLevel the nameLevel to set
	 */
	public void setNameLevel(String nameLevel) {
		this.nameLevel = nameLevel;
	}

}
