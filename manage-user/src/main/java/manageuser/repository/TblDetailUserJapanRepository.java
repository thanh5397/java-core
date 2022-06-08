package manageuser.repository;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import manageuser.entities.TblDetailUserJapanEntity;

@Repository
public interface TblDetailUserJapanRepository extends JpaRepository<TblDetailUserJapanEntity, Integer>{
	boolean existsById(int id);
	void deleteById(int id);
	@Modifying
	@Query("insert into tbl_detail_user_japan (userId,codeLevel,startDate,endDate,total) select :idTask,:description,:filepath from Dual")
	public void insertTblDetailUserJapanById(@Param("userId") Integer id,@Param("codeLevel") String codeLevel,@Param("startDate") Date startDate)
}
