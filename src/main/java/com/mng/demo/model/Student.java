package com.mng.demo.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;

	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="location", column=@Column(name="home_location")),
	@AttributeOverride(name="pincode", column=@Column(name="home_pincode"))
	})
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="location", column=@Column(name="office_location")),
	@AttributeOverride(name="pincode", column=@Column(name="office_pincode"))
	})
	private Address officeAddress;
	
	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
