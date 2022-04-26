package com.phamvanthanh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phamvanthanh.entity.SkillEntity;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long>  {
	List<SkillEntity> findAll();
}
