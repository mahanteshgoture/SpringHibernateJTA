package com.mng.demo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {

	@Id
	@Column(name="userid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	@Column
	private String userName;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@JoinTable(name="USER_ADDRESS",	joinColumns=@JoinColumn(name="userid"))
//	@GenericGenerator(name="hilo-gen", strategy="hilo")
//	@CollectionId(columns={@Column(name="ADDRESS_ID")}, generator="hilo-gen",type=@Type(type="long"))
	private Set<Address> listOfAddress=new HashSet<Address>();

//	@OneToMany(mappedBy="userDetails", cascade={CascadeType.ALL})
//	@JoinTable(name="USER_VEHICLE", joinColumns=@JoinColumn(name="USER_ID"),
//									inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")
//	)
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="USER_VEHICLE", joinColumns=@JoinColumn(name="USER_ID"),
									inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")
	)
	private Collection<Vehicle> vehicles=new ArrayList<Vehicle>();

	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="vehicle_id")
	private MyVehicle myVehicle;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Set<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public MyVehicle getMyVehicle() {
		return myVehicle;
	}

	public void setMyVehicle(MyVehicle myVehicle) {
		this.myVehicle = myVehicle;
	}

	
}
