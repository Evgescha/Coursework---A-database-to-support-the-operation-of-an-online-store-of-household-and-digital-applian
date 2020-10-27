package com.group.webstorebase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.webstorebase.entity.Producer;
import com.group.webstorebase.repository.ProducerRepository;

@Service
public class ProducerService extends CrudImpl<Producer> {
	public ProducerRepository repository;
	@Autowired
	public ProducerService(ProducerRepository repository) {
	super(repository);
	this.repository=repository;
	}
}
