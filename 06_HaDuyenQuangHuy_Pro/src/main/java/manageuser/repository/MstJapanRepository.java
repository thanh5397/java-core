/**
 * Copyright(C) 2020 Luvina Software
 * MstJapanRepository.java, 29/09/2020 HaDuyenQuangHuy
 */
package manageuser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import manageuser.entities.MstJapanEntity;

/**
 * Class MstJapanRepository hỗ trợ lấy dữ liệu từ bảng mstJapan
 * 
 * @author Ha Duyen Quang Huy
 */
public interface MstJapanRepository extends JpaRepository<MstJapanEntity, Integer> {
	List<MstJapanEntity> findAllByNameLevel(String nameLevel);

	List<MstJapanEntity> findAllByCodeLevel(String codeLevel);
	

}
