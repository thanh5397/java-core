package manageuser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import manageuser.entities.MstGroupEntity;

@Repository
public interface MstGroupRepository extends JpaRepository<MstGroupEntity, Integer> {
	List<MstGroupEntity> findAll();
	String findGroupNameByGroupId(int groupId);
	MstGroupEntity findMstGroupByGroupId(int groupId);
}
