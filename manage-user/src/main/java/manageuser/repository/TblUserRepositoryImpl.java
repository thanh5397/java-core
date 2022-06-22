package manageuser.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import manageuser.dto.UserInforDTO;

@Repository
public class TblUserRepositoryImpl {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<UserInforDTO> getListUsers(int rule, int offset, int limit, int groupId, String fullName,
			String sortType, String sortByFullName, String sortByCodeLevel, String sortByEndDate) {
		return entityManager.createQuery("SELECT u.userId, u.fullName, u.birthday, g.groupName, " 
				+ "u.email, u.tel, j.nameLevel, duj.endDate, duj.total "
				+ "FROM TblUserEntity u INNER JOIN MstGroupEntity g "
				+ "LEFT JOIN TblDetailUserJapanEntity duj "
				+ "LEFT JOIN MstJapanEntity j " 
				+ "WHERE u.rule = :rule "  
				+ "AND (:fullName is null or u.fullName LIKE :fullName) "
				+ "AND (:groupId = 0 or u.mstGroupEntity.groupId = :groupId)",
				UserInforDTO.class)
				.setParameter("rule", rule)
				.setParameter("fullName","%" + fullName + "%")
				.setParameter("groupId", groupId)
				.setMaxResults(limit).getResultList();
			}
}
