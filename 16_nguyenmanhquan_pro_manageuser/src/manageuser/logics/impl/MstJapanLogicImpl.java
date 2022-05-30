/**
 * Copyright(C) 2020 Luvina Software
 * MstJapanLogicImpl.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.logics.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.MstJapanDao;
import manageuser.dao.impl.MstJapanDaoImpl;
import manageuser.entities.MstJapanEntity;
import manageuser.logics.MstJapanLogic;
import manageuser.utils.Constant;

/**
 * Mô tả: Implement MstJapanLogic để xử lý logic liên quan đến thông tin của trình độ tiếng Nhật
 * @author Nguyễn Mạnh Quân
 */
public class MstJapanLogicImpl implements MstJapanLogic {
	MstJapanDao mstJapanDao = new MstJapanDaoImpl();
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MstJapanEntity> getAllMstJapan() throws SQLException, ClassNotFoundException, IOException {
		List<MstJapanEntity> listMstJapanEntities = new ArrayList<MstJapanEntity>();
		try {
			listMstJapanEntities = mstJapanDao.getAllMstJapan();
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("MstJapanLogicImpl: getAllMstJapan: " + e.getMessage());
		}
		return listMstJapanEntities;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNameLevelByCodeLevel(String codeLevel) throws SQLException, ClassNotFoundException, IOException {
		String nameLevel = Constant.EMPTY_STRING;
		try {
			nameLevel = mstJapanDao.getNameLevelByCodeLevel(codeLevel);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println("MstJapanLogicImpl: getNameLevelByCodeLevel: " + e.getMessage());
		}
		return nameLevel;
	}
}
