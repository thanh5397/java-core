package manageuser.dao;

import java.util.List;

import manageuser.entities.MstJapanEntity;

public interface MstJapanDao {

	public List<MstJapanEntity> getAllMstJapan();
	
	public boolean checkExistMstJapan(String codeLevel);
	
	public String getCodeLevelFromNameLevel(String nameLevel);

}
