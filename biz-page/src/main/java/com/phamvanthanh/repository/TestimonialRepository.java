package com.phamvanthanh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phamvanthanh.entity.TestimonialEntity;

@Repository
public interface TestimonialRepository extends JpaRepository<TestimonialEntity, Long>  {
	List<TestimonialEntity> findAll();
}
