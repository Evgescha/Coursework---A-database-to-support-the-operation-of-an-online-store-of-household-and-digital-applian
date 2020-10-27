package com.group.webstorebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.webstorebase.entity.MyUser;

@Repository
public interface MyUserRepository extends  JpaRepository<MyUser, Long>{
	public MyUser findByUsername(String fio);
}
