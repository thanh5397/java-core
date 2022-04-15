package com.phamvanthanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phamvanthanh.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
	ContactEntity findFirst();
}
