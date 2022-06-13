/**
 * Copyright(C) 2020
 * Luvina
 * 06_haduyenquanghuy_pro_manageuser
 * 9:29:18 AM
 * Ha Duyen Quang Huy
 */
package manageuser.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * JavaBean UserInfoEntity
 * 
 * Ha Duyen Quang Huy
 */

@Entity(name = "userInfo")

public class UserInfoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int userId;
	private int groupId;
	private int rule;

	private String loginName;
	private String groupName;
	private String fullName;
	private String fullNameKana;
	private String email;
	private String tel;
	private String total;
	private String password;
	private String passwordConfirm;
	private String nameLevel;
	private String codeLevel;

	private Date birthday;
	private Date startDate;
	private Date endDate;

	public UserInfoEntity() {

	}

	public UserInfoEntity(int userId, String groupName, String fullName, String email, String tel, String total,
			String nameLevel, Date birthday, Date endDate) {
		this.userId = userId;
		this.groupName = groupName;
		this.fullName = fullName;
		this.email = email;
		this.tel = tel;
		this.total = total;
		this.nameLevel = nameLevel;
		this.birthday = birthday;
		this.endDate = endDate;
	}

	
	
	public UserInfoEntity(int userId, String groupName, String loginName, String fullName, String fullNameKana, String email,
			String tel, String total, String nameLevel, Date birthday, Date startDate, Date endDate) {
		this.userId = userId;
		this.groupName = groupName;
		this.loginName = loginName;
		this.fullName = fullName;
		this.fullNameKana = fullNameKana;
		this.email = email;
		this.tel = tel;
		this.total = total;
		this.nameLevel = nameLevel;
		this.birthday = birthday;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * @return the user_id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
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

	/**
	 * @return the full_name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param full_name the full_name to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the name_level
	 */

	/**
	 * @return the end_date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param end_date the end_date to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	 * @return the rule
	 */
	public int getRule() {
		return rule;
	}

	/**
	 * @param rule the rule to set
	 */
	public void setRule(int rule) {
		this.rule = rule;
	}

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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

	/**
	 * @return the fullNameKana
	 */
	public String getFullNameKana() {
		return fullNameKana;
	}

	/**
	 * @param fullNameKana the fullNameKana to set
	 */
	public void setFullNameKana(String fullNameKana) {
		this.fullNameKana = fullNameKana;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * @param passwordConfirm the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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
	 * @return the start_date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param start_date the start_date to set
	 */
	public void setStartDate(Date start_date) {
		this.startDate = start_date;
	}

}
