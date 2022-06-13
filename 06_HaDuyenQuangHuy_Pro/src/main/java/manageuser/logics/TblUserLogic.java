package manageuser.logics;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import manageuser.entities.UserInfoEntity;

public interface TblUserLogic {
	public Boolean checkExistLogin(String loginName, String password)
			throws ClassNotFoundException, SQLException, NoSuchAlgorithmException;
	
	public boolean createUser(UserInfoEntity userInfo);
	
	public boolean updateUser(UserInfoEntity userInfo);
	
	public boolean deleteUser(int userId);
	


}
