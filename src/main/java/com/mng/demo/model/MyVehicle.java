package com.mng.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MyVehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	
	@Column
	private String vehicleName;

	public MyVehicle()
	{
		
	}
	
	@OneToOne(mappedBy="myVehicle")
	private UserDetails userDetails;
	
	public MyVehicle(String vehicleName)
	{
		this.vehicleName=vehicleName;
	}
	
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
		
}
