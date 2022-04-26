package com.phamvanthanh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phamvanthanh.entity.AboutEntity;

@Repository
public interface AboutRepository extends JpaRepository<AboutEntity, Long> {
	List<AboutEntity> findAll();
}
