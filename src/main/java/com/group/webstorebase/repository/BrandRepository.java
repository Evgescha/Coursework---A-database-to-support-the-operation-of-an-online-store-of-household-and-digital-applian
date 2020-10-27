package com.group.webstorebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.webstorebase.entity.Brand;

@Repository
public interface BrandRepository extends  JpaRepository<Brand, Long>{
	public Brand findByName(String name);
}
