package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService{

	@Inject
	private INewDAO newDAO;
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		
		return newDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		Long newId = newDAO.save(newModel);
		return newDAO.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDAO.findOne(updateNew.getId());
		
		return null;
	}
}
