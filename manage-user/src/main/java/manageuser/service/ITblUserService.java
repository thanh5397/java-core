package manageuser.service;

public interface ITblUserService {
	public boolean existTblUser(String loginName,String password);
	public int getCountTotalUser(int groupId,String fullName);
}
