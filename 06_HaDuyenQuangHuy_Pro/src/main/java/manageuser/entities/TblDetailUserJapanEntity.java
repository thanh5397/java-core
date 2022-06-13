/**
 * Copyright(C) 2020  Luvina software
 * TblDetailUserJapanEntity.java, Aug 4, 2020 HuyHDQ
 */
package manageuser.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JavaBean TblDetailUserJapanEntity
 * 
 * @author Ha Duyen Quang Huy
 */
//
@Entity(name = "tblDetailUserJapan")
@Table(name = "tbl_detail_user_japan")
public class TblDetailUserJapanEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int detailUserJapanId;
	private int userId;
	private String codeLevel;
	private Date startDate;
	private Date endDate;
	private String total;

	/**
	 * @return the detailUserJapanId
	 */
	public int getDetailUserJapanId() {
		return detailUserJapanId;
	}

	/**
	 * @param detailUserJapanId the detailUserJapanId to set
	 */
	public void setDetailUserJapanId(int detailUserJapanId) {
		this.detailUserJapanId = detailUserJapanId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}

}
