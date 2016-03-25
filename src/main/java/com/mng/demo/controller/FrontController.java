package com.mng.demo.controller;

import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mng.demo.model.Address;
import com.mng.demo.model.FourWheeler;
import com.mng.demo.model.MyVehicle;
import com.mng.demo.model.Student;
import com.mng.demo.model.TwoWheeler;
import com.mng.demo.model.UserDetails;
import com.mng.demo.model.Vehicle;
import com.mng.demo.service.StudentService;
import com.mng.demo.service.UserDetailsService;

@RestController
@RequestMapping(value="/example")
public class FrontController {
	
	@Autowired
	private StudentService studentService;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(value="/userdetails", method=RequestMethod.GET, produces=(MimeTypeUtils.APPLICATION_JSON_VALUE))
	public String userDetails()
	{
		
		System.out.println("HERE YOU GO :" + Student.class.getClassLoader().getResource(Student.class.getName().replace('.', '/')+".class"));
		
		UserDetails userDetails=new UserDetails();
		
		userDetails.setUserName("Mahantesh");
		
		Set<Address> listOfAddresses=new HashSet<Address>();
		
		Address homeAddress=new Address();
		Address officeAddress=new Address();
		
		homeAddress.setLocation("BSK");
		homeAddress.setPincode("560085");
		
		officeAddress.setLocation("PTP");
		officeAddress.setPincode("5600100");
		
		listOfAddresses.add(homeAddress);
		listOfAddresses.add(officeAddress);
		
		userDetails.setListOfAddress(listOfAddresses);
		Vehicle vehicle1=new TwoWheeler();
//		vehicle1.setVehicleId(7628);
		vehicle1.setVehicleName("TVS Bike");
		vehicle1.setSteeringHandle("Steering Handle");
//		userDetails.setVehicle(vehicle1);
		
		Collection<Vehicle> vehicles=new ArrayList<Vehicle>();
		vehicles.add(vehicle1);
		Vehicle vehicle2=new FourWheeler();
		vehicle2.setVehicleName("Bollero");
		vehicle2.setSteeringWheel("Steering Wheel");
		vehicles.add(vehicle2);
		
//		Vehicle vehicle3=new Vehicle();
//		vehicle3.setVehicleName("Vehicle");
//		vehicles.add(vehicle3);
//		vehicle1.getUserDetails().add(userDetails);
//		vehicle2.getUserDetails().add(userDetails);
		
		userDetails.setMyVehicle(new MyVehicle("Maruti"));
		userDetails.setVehicles(vehicles);
		
		userDetailsService.addUserDetails(userDetails);
		
		return userDetails.toString();
	}
}
