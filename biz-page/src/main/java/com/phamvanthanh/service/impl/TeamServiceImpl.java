package com.phamvanthanh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamvanthanh.entity.TeamEntity;
import com.phamvanthanh.repository.TeamRepository;
import com.phamvanthanh.service.ITeamService;

@Service
public class TeamServiceImpl implements ITeamService {
	
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public List<TeamEntity> findAll() {
		return teamRepository.findAll();
	}

}
