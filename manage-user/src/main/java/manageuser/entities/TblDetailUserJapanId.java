package manageuser.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TblDetailUserJapanId implements Serializable  {

	private static final long serialVersionUID = 1L;
	private int userId;
	private String codeLevel;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCodeLevel() {
		return codeLevel;
	}
	public void setCodeLevel(String codeLevel) {
		this.codeLevel = codeLevel;
	}
}
