package manageuser.dto;

import java.util.Date;
import java.util.List;

import manageuser.entities.TblDetailUserJapanEntity;

public class TblUserDTO {
private int userId;
	
	private int groupId;
	private String loginName;
	private String password;
	private String fullName;
	private String fullNameKana;
	private String email;
	private String tel;
	private Date birthday;
	private int rule;
	private String salt;
    private List<TblDetailUserJapanEntity> mstJapans;
}
