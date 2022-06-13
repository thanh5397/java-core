package manageuser.dto;

import java.util.Date;
import java.util.List;

import manageuser.entities.MstGroupEntity;
import manageuser.entities.MstJapanEntity;
import manageuser.entities.TblDetailUserJapanEntity;

public class TblUserDTO {
	private int userId;
	private String loginName;
	private String password;
	private String fullName;
	private String fullNameKana;
	private String email;
	private String tel;
	private Date birthday;
	private int rule;
	private String salt;
	private List<TblDetailUserJapanEntity> tblDetailUserJapanEntities;
	
	private MstGroupEntity mstGroupEntity;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullNameKana() {
		return fullNameKana;
	}
	public void setFullNameKana(String fullNameKana) {
		this.fullNameKana = fullNameKana;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getRule() {
		return rule;
	}
	public void setRule(int rule) {
		this.rule = rule;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public List<TblDetailUserJapanEntity> getTblDetailUserJapanEntities() {
		return tblDetailUserJapanEntities;
	}
	public void setTblDetailUserJapanEntities(List<TblDetailUserJapanEntity> tblDetailUserJapanEntities) {
		this.tblDetailUserJapanEntities = tblDetailUserJapanEntities;
	}
	public MstGroupEntity getMstGroupEntity() {
		return mstGroupEntity;
	}
	public void setMstGroupEntity(MstGroupEntity mstGroupEntity) {
		this.mstGroupEntity = mstGroupEntity;
	}
	
}
