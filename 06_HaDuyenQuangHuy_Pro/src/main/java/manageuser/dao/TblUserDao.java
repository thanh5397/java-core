package manageuser.dao;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.TblUserEntity;
import manageuser.entities.UserInfoEntity;

public interface TblUserDao {
	public List<TblUserEntity> getTblUserByLoginName(String loginName) throws ClassNotFoundException, SQLException;

	public List<UserInfoEntity> getListUsers(int offset, int limit, int groupId, String fullName, String sortType,
			String sortByFullName, String sortByCodeLevel, String sortByEndDate)
			throws ClassNotFoundException, SQLException;

	public int getTotalUser(int groupId, String fullName);

	public boolean checkExistedUserByLoginName(String loginName);

	public boolean checkExistedUserByEmail(String email);

	public TblUserEntity getTblUserFromUserInfo(UserInfoEntity userInfo);

	public UserInfoEntity getUserInfoById(int iD);
	
	public int getRuleByUserId(int iD);

	public boolean checkExistedUserByEmail(String email, int iD);
	

}
