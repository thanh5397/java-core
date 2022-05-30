/**
 * Copyright(C) 2020 Luvina Software
 * UserInfo.java, 17/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Mô tả: Bean chứa các thuộc tính của đối tượng user để hiển thị ra màn hình
 * 
 * @author Nguyễn Mạnh Quân
 */
public class UserInforEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String loginName;
	private int groupId;
	private String groupName;
	private String fullName;
	private String fullNameKana;
	private String email;
	private String tel;
	private String password;
	private String rePassword;
	private String salt;
	private String codeLevel;
	private String nameLevel;
	private String strTotal;
	private Date birthday;
	private Date startDate;
	private Date endDate;
	private List<Integer> arrBirthday;
	private List<Integer> arrStartDate;
	private List<Integer> arrEndDate;
	private int userId;
	private int total;

	/**
	 * Constructor mặc định.
	 */
	public UserInforEntity() {
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

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	 * @return the rePassword
	 */
	public String getRePassword() {
		return rePassword;
	}

	/**
	 * @param rePassword the rePassword to set
	 */
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
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
	
	/**
	 * @return the strTotal
	 */
	public String getStrTotal() {
		return strTotal;
	}

	/**
	 * @param strTotal the strTotal to set
	 */
	public void setStrTotal(String strTotal) {
		this.strTotal = strTotal;
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
	 * @return the arrBirthday
	 */
	public List<Integer> getArrBirthday() {
		return arrBirthday;
	}

	/**
	 * @param arrBirthday the arrBirthday to set
	 */
	public void setArrBirthday(List<Integer> arrBirthday) {
		this.arrBirthday = arrBirthday;
	}

	/**
	 * @return the arrStartDate
	 */
	public List<Integer> getArrStartDate() {
		return arrStartDate;
	}

	/**
	 * @param arrStartDate the arrStartDate to set
	 */
	public void setArrStartDate(List<Integer> arrStartDate) {
		this.arrStartDate = arrStartDate;
	}

	/**
	 * @return the arrEndDate
	 */
	public List<Integer> getArrEndDate() {
		return arrEndDate;
	}

	/**
	 * @param arrEndDate the arrEndDate to set
	 */
	public void setArrEndDate(List<Integer> arrEndDate) {
		this.arrEndDate = arrEndDate;
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
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

}
