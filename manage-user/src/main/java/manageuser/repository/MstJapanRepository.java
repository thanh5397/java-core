package manageuser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import manageuser.entities.MstJapanEntity;

@Repository
public interface MstJapanRepository extends JpaRepository<MstJapanEntity, String> {
	List<MstJapanEntity> findAll();
	String findNameLevelByCodeLevel(String codeLevel);
}
