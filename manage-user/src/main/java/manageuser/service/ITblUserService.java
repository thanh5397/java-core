package manageuser.service;

import java.util.List;

import manageuser.dto.UserInforDTO;

public interface ITblUserService {
	public boolean existTblUser(String loginName,String password);
	public int getCountTotalUser(int groupId,String fullName);
	public List<UserInforDTO> getListUsers(int rule,int offset, int limit, int groupId, String fullName, String sortType,
			String sortByFullName, String sortByCodeLevel, String sortByEndDate);
}
