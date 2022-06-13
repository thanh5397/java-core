package manageuser.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import manageuser.entities.TblDetailUserJapanEntity;

@Repository
public interface TblDetailUserJapanRepository extends JpaRepository<TblDetailUserJapanEntity, Integer>{
	boolean existsById(int id);
	Long deleteByPrimaryKey(int id);
	@Modifying
	@Query("INSERT INTO tbl_detail_user_japan (userId,codeLevel,startDate,endDate,total) VALUES (:userId,:codeLevel,:startDate,:endDate,:total)")
	public void insertTblDetailUserJapanById(@Param("userId") Integer id,@Param("codeLevel") String codeLevel,@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("total") Date total);
	@Modifying
	@Query("UPDATE tbl_detail_user_japan d SET d.code_level = ?1, d.start_date = ?2, d.end_date = ?3, d.total = ?4 WHERE d.user_id = ?5")
	public void updateTblDetailUserJapanById(String codeLevel, Date startDate, Date endDate,int total,int userId);
}
