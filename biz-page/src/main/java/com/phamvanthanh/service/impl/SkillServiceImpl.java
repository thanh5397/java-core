package com.phamvanthanh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamvanthanh.entity.SkillEntity;
import com.phamvanthanh.repository.SkillRepository;
import com.phamvanthanh.service.ISkillService;

@Service
public class SkillServiceImpl implements ISkillService  {
	
	@Autowired
	private SkillRepository skillRepository;

	@Override
	public List<SkillEntity> findAll() {
		// TODO Auto-generated method stub
		return skillRepository.findAll();
	}

}
