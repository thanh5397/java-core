package manageuser.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_infor")
public class UserInforEntity {
	@Id
	private int userId;
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
	private int total;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
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
	public String getStrTotal() {
		return strTotal;
	}
	public void setStrTotal(String strTotal) {
		this.strTotal = strTotal;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<Integer> getArrBirthday() {
		return arrBirthday;
	}
	public void setArrBirthday(List<Integer> arrBirthday) {
		this.arrBirthday = arrBirthday;
	}
	public List<Integer> getArrStartDate() {
		return arrStartDate;
	}
	public void setArrStartDate(List<Integer> arrStartDate) {
		this.arrStartDate = arrStartDate;
	}
	public List<Integer> getArrEndDate() {
		return arrEndDate;
	}
	public void setArrEndDate(List<Integer> arrEndDate) {
		this.arrEndDate = arrEndDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
