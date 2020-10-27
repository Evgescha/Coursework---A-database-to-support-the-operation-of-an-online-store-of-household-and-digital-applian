package com.group.webstorebase.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table
@Data
public class Brand extends AbstractEntity{

	String name;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="brand", cascade=CascadeType.ALL)
    private List<Product> product;
}
