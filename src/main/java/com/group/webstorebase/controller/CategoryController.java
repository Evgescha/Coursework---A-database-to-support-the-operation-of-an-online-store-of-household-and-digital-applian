package com.group.webstorebase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group.webstorebase.entity.Category;
import com.group.webstorebase.service.CategoryService;
import com.group.webstorebase.service.ListService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService service;
	@Autowired
	ListService listService;

	@GetMapping
	public String getcategory(Model model) {
		listService.makeModel(model);
		return "category";
	}

	@PostMapping
	public String setcategory(Model model, @ModelAttribute Category category, RedirectAttributes ra) {
		String response;
		System.out.println("start create category");
		try {
			service.create(category);
			response = "Success created";
			ra.addFlashAttribute("response1", response);
		} catch (Exception e) {
			e.printStackTrace();
			response = "Creating failed";
			ra.addFlashAttribute("response1", response);
		}
		System.out.println("create category: " + response);

		return "redirect:/category";
	}

	@GetMapping("/remove/{id}")
	public String removecategory(Model model, @PathVariable Long id, RedirectAttributes ra) {
		try {
		System.out.println(id);
		service.repository.delete(service.read(id));
		ra.addFlashAttribute("response1", "Succes removed");}
		catch(Exception ex) {ra.addFlashAttribute("response1", "Removing failed");}
		return "redirect:/category";
	}

	@PostMapping("/edit")
	public String editcategory(@ModelAttribute Category category, @Param("idd") int idd, RedirectAttributes ra) {
		try {
			Category read = service.read(idd);
			read.setName(category.getName());
			service.update(read);
			ra.addFlashAttribute("response1", "Success edited");
		} catch (Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("response1", "Editing failed");
		}

		return "redirect:/category";
	}
}
