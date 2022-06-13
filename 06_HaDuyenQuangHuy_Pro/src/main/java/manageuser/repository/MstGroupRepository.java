/**
 * Copyright(C) 2020 Luvina Software
 * MstGroupRepository.java, 29/09/2020 HaDuyenQuangHuy
 */
package manageuser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import manageuser.entities.MstGroupEntity;

/**
 * Class MstGroupRepository hỗ trợ lấy dữ liệu từ bảng mstGroup
 * 
 * @author Ha Duyen Quang Huy
 */
public interface MstGroupRepository extends JpaRepository<MstGroupEntity, Integer> {
	List<MstGroupEntity> findAllByGroupName(String groupName);

}
