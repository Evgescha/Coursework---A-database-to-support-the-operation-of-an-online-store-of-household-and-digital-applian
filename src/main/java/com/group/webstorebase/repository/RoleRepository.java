package com.group.webstorebase.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.webstorebase.entity.Role;

@Repository
public interface RoleRepository extends  JpaRepository<Role, Long>{
	public Role findByName(String name);
	public ArrayList<Role> findAll();
}
