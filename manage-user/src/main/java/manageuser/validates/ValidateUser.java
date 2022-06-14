package manageuser.validates;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import manageuser.service.ITblUserService;
import manageuser.utils.Common;
import manageuser.utils.Constant;

public class ValidateUser {
	
    @Autowired
    MessageSource messageSource;
    
    @Autowired
    ITblUserService tblUserService;

	public List<String> validateLogin(String loginName, String password) {
			List<String> listError = new ArrayList<String>();
			try {
				if (Common.compareString(Constant.EMPTY_STRING, loginName)) {
					String loginNameER001 = messageSource.getMessage(Constant.ER001_LOGIN_NAME , null , null);
					listError.add(loginNameER001);
				}
	
				if (Common.compareString(Constant.EMPTY_STRING, password)) {
					String passwordER001 = messageSource.getMessage(Constant.ER001_PASSWORD , null , null);
					listError.add(passwordER001);
				}
	
				if (listError.size() == 0) {
					boolean isExist = tblUserService.existTblUser(loginName, password);
					if (!isExist) {
						String ER016 = messageSource.getMessage(Constant.ER016 , null , null);
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
