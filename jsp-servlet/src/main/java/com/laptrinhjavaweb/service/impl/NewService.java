package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService{

	@Inject
	private INewDAO newDAO;
	
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		
		return newDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreateddate(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedby("");
		Long newId = newDAO.save(newModel);
		return newDAO.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDAO.findOne(updateNew.getId());
		updateNew.setCreateddate(oldNew.getCreateddate());
		updateNew.setCreatedby(oldNew.getCreatedby());
		updateNew.setModifieddate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedby("");
//		CategoryModel category = categoryDAO.findOneByCode(updateNew.getCategoryCode());
//		updateNew.setCategoryid(category.getId());
		newDAO.update(updateNew);
		return newDAO.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newDAO.delete(id);
		}
	}
}
