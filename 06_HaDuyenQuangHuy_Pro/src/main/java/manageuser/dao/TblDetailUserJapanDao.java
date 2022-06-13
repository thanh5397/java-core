package manageuser.dao;

import manageuser.entities.TblDetailUserJapanEntity;
import manageuser.entities.UserInfoEntity;

public interface TblDetailUserJapanDao {

	public TblDetailUserJapanEntity getTblDetaiUserJapanFromUserInfo(UserInfoEntity userInfo);

}
