package com.mng.demo.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
	
	@Column
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	@Override
	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

	@Override
	public void setSteeringWheel(String str) {
		// TODO Auto-generated method stub
		
	}
}
