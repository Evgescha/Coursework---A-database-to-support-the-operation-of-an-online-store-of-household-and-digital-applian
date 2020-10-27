package com.group.webstorebase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.webstorebase.entity.Category;
import com.group.webstorebase.repository.CategoryRepository;

@Service
public class CategoryService extends CrudImpl<Category> {
	public CategoryRepository repository;

	@Autowired
	public CategoryService(CategoryRepository repository) {
		super(repository);
		this.repository = repository;
	}
}
