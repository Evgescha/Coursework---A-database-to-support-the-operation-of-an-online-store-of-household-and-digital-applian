package com.group.webstorebase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.webstorebase.entity.Role;
import com.group.webstorebase.repository.RoleRepository;

@Service
public class RoleService extends CrudImpl<Role> {
	RoleRepository repository;

	@Autowired
	public RoleService(RoleRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public Role findByName(String name) {
		return repository.findByName(name);
	}
}
