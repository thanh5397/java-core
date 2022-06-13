package manageuser.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import manageuser.entities.TblUserEntity;

@Repository
public interface TblUserRepository extends JpaRepository<TblUserEntity, Integer>{
	TblUserEntity findUserByLoginName(String loginName);
	int checkAdminByLoginName(String loginName);
//	long countTotalUserByGroupIdAndFullName(int groupId, String fullName);
//phải custom lại query
//	List<UserInforDTO> getListUsers(int offset, int limit, int groupId, String fullName, String sortType,
//			String sortByFullName, String sortByCodeLevel, String sortByEndDate);
// phải custom lại query	
//	boolean existEmailByUserIdAndEmail(int userId, String email);
// phải check lại hoạt động	
	@Modifying
	@Query("INSERT INTO tbl_user(group_id, login_name, password, full_name, full_name_kana, email, tel, birthday, rule, salt) "
			+ "VALUES (:groudId, :loginName, :password, :fullName, :fullNameKana, :email, :tel, :birthday, :startDate, :endDate,:total,:rule,:salt)")
	public void insertTblUserById(@Param("groudId") Integer groupId,@Param("loginName") String loginName,
			@Param("password") String password,@Param("fullName") String fullName,@Param("fullNameKana") String fullNameKana,
			@Param("email") String email,@Param("tel") String tel,@Param("birthday") Date birthday,
			@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("total") String total,
			@Param("rule") int rule,@Param("salt") String salt);
// phải custom lại query
//	UserInforDTO getUserDetailById(int userId);
	
	boolean existLoginNameByUserId(int userId);
	@Modifying
	@Query("UPDATE tbl_user SET group_id = ?1, full_name = ?2, full_name_kana = ?3, email = ?4, tel = ?5, birthday = ?6 WHERE user_id = ?7")
	void updateTblDetailUserJapanById(int groupId, String fullName, String fullNameKana,String email,String tel,Date birthday,int userId);
	
	Long deleteByUserId(int id);
	int getRuleByUserId(int userId);
	int getRuleByLoginName(String loginName);
}
