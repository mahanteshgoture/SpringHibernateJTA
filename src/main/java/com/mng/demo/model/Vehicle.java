package com.mng.demo.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="VEHICLE_TYPE",
//discriminatorType=DiscriminatorType.STRING)
public abstract class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="vehicle_id")
	private long vehicleId;
	
	@Column(name="vehicle_name")
	private String vehicleName;

//	@ManyToOne(cascade={CascadeType.ALL})
//	@JoinColumn(name="USER_ID")
//	@JoinTable(name="USER_VEHICLE", joinColumns=@JoinColumn(name="VEHICLE_ID"),
//	inverseJoinColumns=@JoinColumn(name="USER_ID"))
//	@ManyToMany(mappedBy="vehicles",cascade={CascadeType.ALL})
//	private Collection<UserDetails> userDetails=new ArrayList<UserDetails>();
	
	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

//	public Collection<UserDetails> getUserDetails() {
//		return userDetails;
//	}
//
//	public void setUserDetails(Collection<UserDetails> userDetails) {
//		this.userDetails = userDetails;
//	}
	
	public abstract void setSteeringHandle(String str);
	public abstract void setSteeringWheel(String str);
}
