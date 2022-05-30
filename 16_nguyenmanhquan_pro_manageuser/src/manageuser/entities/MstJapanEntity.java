/**
 * Copyright(C) 2020 Luvina Software
 * MstJapan.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.entities;

import java.io.Serializable;

/**
 * Mô tả: Bean chứa các thuộc tính của bảng mst_japan trong Database
 * @author Nguyễn Mạnh Quân
 */
public class MstJapanEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codeLevel;
	private String nameLevel;
	
	/**
	 * Constructor mặc định 
	 */
	public MstJapanEntity() {
	}

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
