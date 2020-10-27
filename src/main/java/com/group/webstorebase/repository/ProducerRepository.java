package com.group.webstorebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.webstorebase.entity.Producer;

@Repository
public interface ProducerRepository extends  JpaRepository<Producer, Long>{
	public Producer findByTitle(String title); 
}
