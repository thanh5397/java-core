package manageuser.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import manageuser.dto.UserInforDTO;
import manageuser.entities.MstGroupEntity;
import manageuser.entities.TblUserEntity;

@Repository
public interface TblUserRepository extends JpaRepository<TblUserEntity, Integer>{
	TblUserEntity findUserByLoginName(String loginName);
	long countTotalUserByMstGroupEntity_groupIdAndFullName(int groupId, String fullName);
//phải custom lại query
	@Modifying
	@Query(value = "SELECT u.user_id, u.full_name, u.birthday, g.group_name,"
			+ "u.email, u.tel, j.name_level, duj.end_date, duj.total "
			+ "FROM tbl_user u INNER JOIN mst_group g USING (group_id) "
			+ "LEFT JOIN tbl_detail_user_japan duj USING(user_id) "
			+ "LEFT JOIN mst_japan j USING (code_level) "
			+ "WHERE u.rule = :rule "
			+ "AND (:fullName is null or u.full_name LIKE %:fullName%) "
			+ "AND (:groupId = 0 or u.group_id = :groupId) "
			+ "LIMIT :limit OFFSET :offset"		 		
			, nativeQuery = true)
	List<UserInforDTO> getListUsers(@Param("rule") int rule,@Param("offset") int offset,@Param("limit") int limit,@Param("groupId") int groupId,@Param("fullName") String fullName);
// phải custom lại query	
//	boolean existEmailByUserIdAndEmail(int userId, String email);
// phải check lại hoạt động	
	@Modifying
	@Query(value = "INSERT INTO tbl_user(group_id, login_name, password, full_name, full_name_kana, email, tel, birthday, rule, salt) "
			+ "VALUES (:groudId, :loginName, :password, :fullName, :fullNameKana, :email, :tel, :birthday, :startDate, :endDate,:total,:rule,:salt)", nativeQuery = true)
	public void insertTblUserById(@Param("groudId") Integer groupId,@Param("loginName") String loginName,
			@Param("password") String password,@Param("fullName") String fullName,@Param("fullNameKana") String fullNameKana,
			@Param("email") String email,@Param("tel") String tel,@Param("birthday") Date birthday,
			@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("total") String total,
			@Param("rule") int rule,@Param("salt") String salt);
// phải custom lại query
//	UserInforDTO getUserDetailById(int userId);
	
	String getLoginNameByUserId(int userId);
	@Modifying
	@Query(value = "UPDATE tbl_user SET group_id = ?1, full_name = ?2, full_name_kana = ?3, email = ?4, tel = ?5, birthday = ?6 WHERE user_id = ?7", nativeQuery = true)
	void updateTblUserById(int groupId, String fullName, String fullNameKana,String email,String tel,Date birthday,int userId);
	
	Long deleteByUserId(int id);
	int getRuleByUserId(int userId);
	int getRuleByLoginName(String loginName);
}
