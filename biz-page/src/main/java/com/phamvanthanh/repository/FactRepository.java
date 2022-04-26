package com.phamvanthanh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phamvanthanh.entity.FactEntity;

@Repository
public interface FactRepository extends JpaRepository<FactEntity, Long> {
	List<FactEntity> findAll();
}
