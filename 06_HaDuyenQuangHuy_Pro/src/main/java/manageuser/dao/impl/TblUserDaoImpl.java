/**
 * Copyright(C) 2020 Luvina Software
 * LoginController.java, 29/07/2020 HaDuyenQuangHuy
 */
package manageuser.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manageuser.dao.TblUserDao;
import manageuser.entities.TblUserEntity;
import manageuser.entities.UserInfoEntity;
import manageuser.repository.TblUserRepository;
import manageuser.utils.Common;
import manageuser.utils.ConfigProperties;
import manageuser.utils.Constant;

/**
 * Class TblGroupDaoImpl Thực hiện lấy dữ liệu từ DB liên quan đến mstGroup
 * 
 * @author Ha Duyen Quang Huy
 */
@Service
public class TblUserDaoImpl implements TblUserDao {

	@PersistenceContext
	public EntityManager entityManager;

	@Autowired

	private TblUserRepository repo;
	@Autowired
	private MstGroupDaoImpl groupDao;

	@Override
	public List<TblUserEntity> getTblUserByLoginName(String loginName) throws ClassNotFoundException, SQLException {

		return repo.findAllByLoginNameAndRule(loginName, 0);

	}
	/**
	 * Lấy một thực thể userInfo từ ID
	 * 
	 * @param userId
	 * 
	 * @return userInfo tương ứng với ID
	 */
	@Override
	public UserInfoEntity getUserInfoById(int userId) {
		// TODO Auto-generated method stub
		UserInfoEntity newUser = null;
		StringBuilder sqlGetUserInfo = new StringBuilder();
		sqlGetUserInfo.append(
				"SELECT new userInfo(tu.userId, mg.groupName, tu.loginName,tu.fullName,tu.fullNameKana, tu.email, tu.tel,tduj.total, mj.nameLevel, tu.birthday, tduj.startDate, tduj.endDate) FROM tblUser tu ");
		sqlGetUserInfo.append("INNER JOIN mstGroup mg ON tu.groupId=mg.groupId ");
		sqlGetUserInfo.append("LEFT JOIN tblDetailUserJapan tduj ON tduj.userId = tu.userId ");
		sqlGetUserInfo.append("LEFT JOIN mstJapan mj ON mj.codeLevel = tduj.codeLevel ");
		sqlGetUserInfo.append("WHERE tu.userId = :userId AND rule = :rule ");

		TypedQuery<UserInfoEntity> query = entityManager.createQuery(sqlGetUserInfo.toString(), UserInfoEntity.class);
		query.setParameter("rule", Constant.RULE_USER);
		query.setParameter("userId", userId);
		newUser = query.getSingleResult();

		return newUser;
	}

	/**
	 * 
	 * Hiển thị listUser tại vùng kết quả tìm kiếm ADM002
	 * 
	 * @param offset
	 *            Vị trí lấy
	 * @param limit
	 *            Giới hạn một lần lấy
	 * @param groupID,
	 *            fullName điều kiện tìm kiếm
	 * @param sortType
	 *            hạng mục ưu tiên tìm kiếm
	 * @param sortByFullName,
	 *            sortByEndDate, sortByCodeLevel giá trị tìm kiếm tại hạng mục
	 *            hiện tại
	 * 
	 * @return List<UserInfoEntity> giá trị của listUser khi thực hiện tìm kiếm
	 */
	@Override
	public List<UserInfoEntity> getListUsers(int offset, int limit, int groupId, String fullName, String sortType,
			String sortByFullName, String sortByCodeLevel, String sortByEndDate)
			throws ClassNotFoundException, SQLException {
		List<UserInfoEntity> listUser = null;
		StringBuilder sqlListUser = new StringBuilder();
		sqlListUser.append(
				"SELECT new userInfo(tu.userId, mg.groupName, tu.fullName,tu.email, tu.tel , tduj.total, mj.nameLevel, tu.birthday, tduj.endDate) FROM tblUser tu ");
		sqlListUser.append("INNER JOIN mstGroup mg ON tu.groupId=mg.groupId ");
		sqlListUser.append("LEFT JOIN tblDetailUserJapan tduj ON tduj.userId = tu.userId ");
		sqlListUser.append("LEFT JOIN mstJapan mj ON mj.codeLevel = tduj.codeLevel ");
		sqlListUser.append("WHERE tu.rule = :rule ");
		if (!"".equals(fullName)) {
			sqlListUser.append("AND tu.fullName like :fullName escape '#' ");
		}

		if (0 != groupId) {
			sqlListUser.append("AND tu.groupId = " + groupId + " ");
		}

		switch (sortType) {
		case Constant.SORT_BY_FULLNAME:
			sqlListUser.append("ORDER BY tu.fullName " + sortByFullName + ", mj.codeLevel " + sortByCodeLevel
					+ ", tduj.endDate " + sortByEndDate + " ");
			break;
		case Constant.SORT_BY_CODELEVEL:
			sqlListUser.append("ORDER BY mj.codeLevel " + sortByCodeLevel + ", tu.fullName  " + sortByFullName
					+ ", tduj.endDate " + sortByEndDate + " ");
			break;
		case Constant.SORT_BY_ENDDATE:
			sqlListUser.append("ORDER BY tduj.endDate " + sortByEndDate + ", tu.fullName " + sortByFullName
					+ ", mj.codeLevel " + sortByCodeLevel + " ");
			break;
		}
		TypedQuery<UserInfoEntity> query = entityManager.createQuery(sqlListUser.toString(), UserInfoEntity.class)
				.setMaxResults(Common.convertStringToInteger(ConfigProperties.getValueByKey("LIMIT"), 0))
				.setFirstResult(offset);
		query.setParameter("rule", Constant.RULE_USER);
		if (!"".equals(fullName)) {
			query.setParameter("fullName", "%" + fullName + "%");
		}
		listUser = query.getResultList();
		return listUser;
	}

	/**
	 * Lấy giá trị số lượng User tương ứng với groupId và fullName
	 * 
	 * @param int groupId giá trị hiện tại của groupId
	 * @param String fullName giá trị hiển tại của textbox fullName
	 * 
	 * @return: Giá trị số lượng User tương ứng với groupId và fullName
	 */
	@Override
	public int getTotalUser(int groupId, String fullName) {
		List<TblUserEntity> listUser = null;
		StringBuilder sqlListUser = new StringBuilder();
		sqlListUser.append("SELECT tu FROM tblUser tu ");
		sqlListUser.append("WHERE tu.rule = :rule ");
		if (!"".equals(fullName)) {
			sqlListUser.append("AND tu.fullName like :fullName escape '#' ");
		}
		if (0 != groupId) {
			sqlListUser.append("AND tu.groupId = " + groupId + " ");
		}
		TypedQuery<TblUserEntity> query = entityManager.createQuery(sqlListUser.toString(), TblUserEntity.class);
		query.setParameter("rule", Constant.RULE_USER);
		if (!"".equals(fullName)) {
			query.setParameter("fullName", "%" + fullName + "%");
		}
		listUser = query.getResultList();
		return listUser.size();
	}
	
	/**
	 * Kiểm tra tồn tại user bởi Loginname
	 * 
	 * @param String loginName
	 * 
	 * @return: true/false nếu user tồn tại/không tồn tại 
	 */
	@Override
	public boolean checkExistedUserByLoginName(String loginName) {
		List<TblUserEntity> listUser = repo.findAllByLoginName(loginName);
		if (listUser.size() != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Kiểm tra tồn tại user bởi email và iD
	 * 
	 * @param String loginName
	 * @param int iD
	 * 
	 * @return: true/false nếu user tồn tại/không tồn tại 
	 */
	@Override
	public boolean checkExistedUserByEmail(String email, int iD) {
		String emailOnDB = repo.findOneByUserId(iD).getEmail();
		List<TblUserEntity> listUser = repo.findAllByEmail(email, emailOnDB);
		if (listUser.size() != 0) {
			return true;
		}
		return false;

	}

	/**
	 * Kiểm tra tồn tại user bởi email
	 * 
	 * @param String loginName
	 * 
	 * @return: true/false nếu user tồn tại/không tồn tại 
	 */
	@Override
	public boolean checkExistedUserByEmail(String email) {
		List<TblUserEntity> listUser = repo.findAllByEmail(email);
		if (listUser.size() != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Tạo mới một đối tượng tblUserEntity từ userInfo
	 * 
	 * @param UserInfoEntity userInfo
	 * 
	 * @return: tblUser
	 */
	@Override
	public TblUserEntity getTblUserFromUserInfo(UserInfoEntity userInfo) {
		String salt = Common.creatSalt();
		TblUserEntity tblUser = new TblUserEntity();
		tblUser.setUserId(userInfo.getUserId());
		tblUser.setLoginName(userInfo.getLoginName());
		tblUser.setFullName(userInfo.getFullName());
		tblUser.setFullNameKana(userInfo.getFullNameKana());
		tblUser.setEmail(userInfo.getEmail());
		tblUser.setPassword(Common.encryptPassword(userInfo.getPassword(), salt));
		tblUser.setTel(userInfo.getTel());
		tblUser.setBirthday(userInfo.getBirthday());
		tblUser.setGroup_id(groupDao.getGroupIdFromGroupName(userInfo.getGroupName()));
		tblUser.setRule(Constant.RULE_USER);
		tblUser.setSalt(salt);
		return tblUser;
	}

	/**
	 * Lấy ra thuộc tính rule của User bởi Id
	 * 
	 * @param int iD
	 * 
	 * @return: rule của user tương ứng với ID
	 */
	@Override
	public int getRuleByUserId(int iD) {
		return repo.findOneByUserId(iD).getRule();
	}


}
