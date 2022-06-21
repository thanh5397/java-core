package manageuser.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="TblUserEntity")
@Table(name="tbl_user")
public class TblUserEntity {
	@Id
    @Column(name = "user_id")
	private int userId;
	@Column(length = 255,name="login_name")
	private String loginName;
	@Column(length = 255,name="password")
	private String password;
	@Column(length = 255,name="full_name")
	private String fullName;
	@Column(length = 255,name="full_name_kana")
	private String fullNameKana;
	@Column(length = 255)
	private String email;
	@Column(length = 255)
	private String tel;
	private Date birthday;
	private int rule;
	@Column(length = 255)
	private String salt;
	
	@ManyToOne 
	@PrimaryKeyJoinColumn
	@Fetch(FetchMode.JOIN)
    private MstGroupEntity mstGroupEntity;
	
	@OneToMany(mappedBy = "tblUserEntity")
    List<TblDetailUserJapanEntity> tblDetailUserJapanEntities;
	
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
	public MstGroupEntity getMstGroupEntity() {
		return mstGroupEntity;
	}
	public void setMstGroupEntity(MstGroupEntity mstGroupEntity) {
		this.mstGroupEntity = mstGroupEntity;
	}
	public List<TblDetailUserJapanEntity> getTblDetailUserJapanEntities() {
		return tblDetailUserJapanEntities;
	}
	public void setTblDetailUserJapanEntities(List<TblDetailUserJapanEntity> tblDetailUserJapanEntities) {
		this.tblDetailUserJapanEntities = tblDetailUserJapanEntities;
	}
	
	
}
