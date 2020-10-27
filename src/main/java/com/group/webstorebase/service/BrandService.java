package com.group.webstorebase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.webstorebase.entity.Brand;
import com.group.webstorebase.repository.BrandRepository;

@Service
public class BrandService extends CrudImpl<Brand> {
	public BrandRepository repository;
	@Autowired
	public BrandService(BrandRepository repository) {
	super(repository);
	this.repository=repository;
	}
}
