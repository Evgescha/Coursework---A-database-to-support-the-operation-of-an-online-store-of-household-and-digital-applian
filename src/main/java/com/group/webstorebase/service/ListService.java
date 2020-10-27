package com.group.webstorebase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.group.webstorebase.entity.Brand;
import com.group.webstorebase.entity.Category;

@Service
public class ListService {
	@Autowired
    BrandService brandService;
    @Autowired
    CategoryService categoryService;

	public void makeModel(Model model) {
		List<Brand> brands = brandService.repository.findAll();
        if (!brands.isEmpty())
			model.addAttribute("brands", brands);
        
        List<Category> categories = categoryService.repository.findAll();
        if (!categories.isEmpty())
			model.addAttribute("categories", categories);
        
	}
}
