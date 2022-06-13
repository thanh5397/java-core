package manageuser.dao;

import java.util.List;

import manageuser.entities.MstGroupEntity;

public interface MstGroupDao {

	public List<MstGroupEntity> getAllMstGroup();

	public boolean checkExistMstGroup(String groupName);
	
	public int getGroupIdFromGroupName(String groupName);

}
