/**
 * Copyright(C) 2020 Luvina Software
 * TblUserRepository.java, 29/09/2020 HaDuyenQuangHuy
 */
package manageuser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import manageuser.entities.TblUserEntity;

/**
 * Class TblDetailUserJapanRepository hỗ trợ lấy dữ liệu từ bảng TblUser
 * 
 * @author Ha Duyen Quang Huy
 */
@Repository
public interface TblUserRepository extends JpaRepository<TblUserEntity, Integer> {

	public List<TblUserEntity> findAllByLoginNameAndRule(String loginName, int rule);

	public List<TblUserEntity> findAllByLoginName(String loginName);

	public List<TblUserEntity> findAllByEmail(String email);

	public TblUserEntity findOneByUserId(int iD);

	public void deleteByUserId(int userId);

	@Query("SELECT u from tblUser u where u.email = :validateEmail and u.email != :emailOnDB")
	public List<TblUserEntity> findAllByEmail(@Param("validateEmail") String validateEmail, @Param("emailOnDB") String emailOnDB);

}
