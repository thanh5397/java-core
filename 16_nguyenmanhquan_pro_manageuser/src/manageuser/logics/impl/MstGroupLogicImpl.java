/**
 * Copyright(C) 2020 Luvina Software
 * MstGroupLogicImpl.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.logics.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.MstGroupDao;
import manageuser.dao.impl.MstGroupDaoImpl;
import manageuser.entities.MstGroupEntity;
import manageuser.logics.MstGroupLogic;
import manageuser.utils.Constant;

/**
 * Mô tả: Implement MstGroupLogic để xử lý logic liên quan đến thông tin của group
 * @author Nguyễn Mạnh Quân
 */
public class MstGroupLogicImpl implements MstGroupLogic {
	MstGroupDao mstGroupDao = new MstGroupDaoImpl();
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MstGroupEntity> getAllMstGroup() throws ClassNotFoundException, SQLException, IOException {
		List<MstGroupEntity> listMstGroupEntities = new ArrayList<MstGroupEntity>();
		try {
			listMstGroupEntities = mstGroupDao.getAllMstGroup();
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("MstGroupLogicImpl: getAllMstGroup: " + e.getMessage());
			throw e;
		}
		return listMstGroupEntities;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getGroupNameById(int groupId) throws SQLException, ClassNotFoundException, IOException {
		String groupName = Constant.EMPTY_STRING;
		try {
			groupName = mstGroupDao.getGroupNameById(groupId);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("MstGroupLogicImpl: getGroupNameById: " + e.getMessage());
			throw e;
		}
		return groupName;
	}

}
