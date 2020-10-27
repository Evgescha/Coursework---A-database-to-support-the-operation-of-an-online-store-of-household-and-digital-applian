package com.group.webstorebase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.webstorebase.entity.Brand;
import com.group.webstorebase.entity.Category;
import com.group.webstorebase.entity.Producer;
import com.group.webstorebase.entity.Product;

@Repository
public interface ProductRepository extends  JpaRepository<Product, Long>{
	public List<Product> findByNameContaining(String name);
	public List<Product> findByPrice(float price);
	public List<Product> findByQuantity(int quantity);
	public List<Product> findByDescriptionContaining(String description);
	public List<Product> findByCategory(Category ategory);
	public List<Product> findByProducer(Producer producer);
	public List<Product> findByBrand(Brand brand);
}
