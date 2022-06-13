/**
 * Copyright(C) 2020 Luvina Software
 * LoginController.java, 15/07/2020 HaDuyenQuangHuy
 */
package manageuser.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "tblUser")
@Table(name = "TblUser")
public class TblUserEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * JavaBean TblUserEntity
	 * 
	 * Ha Duyen Quang Huy
	 */

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	@Column(name = "group_id")
	int groupId;
	@Column(name = "rule")
	int rule;
	@Column(name = "login_name")
	String loginName;
	String password;
	String fullName;
	String fullNameKana;
	String email;
	String tel;
	@Column(name = "birthday")
	Date birthday;
	String Salt;

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
	 * @return the group_id
	 */
	public int getGroupId() {
		return groupId;
	}

	/**
	 * @param group_id the group_id to set
	 */
	public void setGroup_id(int groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the rule
	 */
	@Column(name = "Rule")
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
	 * @return the login_name
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param login_name the login_name to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	 * @return the full_name_kana
	 */
	public String getFullNameKana() {
		return fullNameKana;
	}

	/**
	 * @param full_name_kana the full_name_kana to set
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
	 * @return the salt
	 */
	public String getSalt() {
		return Salt;
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		Salt = salt;
	}

}
