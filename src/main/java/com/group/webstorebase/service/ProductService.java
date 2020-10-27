package com.group.webstorebase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.webstorebase.entity.Product;
import com.group.webstorebase.repository.ProductRepository;

@Service
public class ProductService extends CrudImpl<Product> {
	public ProductRepository repository;

	@Autowired
	public ProductService(ProductRepository repository) {
		super(repository);
		this.repository = repository;
	}
}
