/**
 * Copyright(C) 2020 Luvina Software
 * TblDetailUserJapanRepository.java, 29/09/2020 HaDuyenQuangHuy
 */
package manageuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import manageuser.entities.TblDetailUserJapanEntity;

/**
 * Class TblDetailUserJapanRepository hỗ trợ lấy dữ liệu từ bảng TblDetaiUserJapan
 * 
 * @author Ha Duyen Quang Huy
 */
public interface TblDetailUserJapanRepository extends JpaRepository<TblDetailUserJapanEntity, Integer>{
	
	public void deleteByUserId(int userId);
	
	public TblDetailUserJapanEntity findOneByUserId(int userId);
	

}
