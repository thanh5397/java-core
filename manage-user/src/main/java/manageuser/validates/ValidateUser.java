package manageuser.validates;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import manageuser.entities.UserInforEntity;
import manageuser.logics.MstGroupLogic;
import manageuser.logics.MstJapanLogic;
import manageuser.logics.TblUserLogic;
import manageuser.logics.impl.MstGroupLogicImpl;
import manageuser.logics.impl.MstJapanLogicImpl;
import manageuser.logics.impl.TblUserLogicImpl;
import manageuser.utils.Common;
import manageuser.utils.Constant;
import manageuser.utils.MessageErrorProperties;

public class ValidateUser {

	public List<String> validateLogin(String loginName, String password)
			throws ClassNotFoundException, SQLException, IOException, NoSuchAlgorithmException {
			List<String> listError = new ArrayList<String>();
			try {
				if (Common.compareString(Constant.EMPTY_STRING, loginName)) {
					String loginNameER001 = MessageErrorProperties.getMessageError(Constant.ER001_LOGIN_NAME);
					listError.add(loginNameER001);
				}
	
				if (Common.compareString(Constant.EMPTY_STRING, password)) {
					String passwordER001 = MessageErrorProperties.getMessageError(Constant.ER001_PASSWORD);
					listError.add(passwordER001);
				}
	
				if (listError.size() == 0) {
					boolean isExist = tblUserLogic.existLogin(loginName, password);
					if (!isExist) {
						String ER016 = MessageErrorProperties.getMessageError(Constant.ER016);
						listError.add(ER016);
					}
				}
			} catch (Exception e) {
				System.out.println("ValidateUser: validateLogin: " + e.getMessage());
				throw e;
			}
			return listError;
	}
}
