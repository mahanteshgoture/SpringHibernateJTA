package com.mng.demo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mng.demo.dao.UserDetailsDAO;
import com.mng.demo.model.UserDetails;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {

	
	@PersistenceContext(unitName="entityManagerFactoryBean2")
	@Autowired
	@Qualifier(value="entityManagerFactoryBean2")
	private EntityManager entityManager;
	
	@Override
	public void addUserDetails(UserDetails userDetails) {

		System.out.println("Adding userDetails");
		entityManager.persist(userDetails);
		
//		userDetails.setUserId(100);
		
		System.out.println("Added useDetails");
		
//		System.out.println("Retrieving user Details for user id 1");
		
//		UserDetails userFound=entityManager.find(UserDetails.class, 1);
		
//		System.out.println("User Address List:"+ userFound.getListOfAddress().size());
		
		
//		Vehicle vehicle=null;
////		
////		System.out.println("\n\n\nRetrieving user with id 1");
////
//		long vehicleId=17;
////		
//		vehicle=entityManager.find(Vehicle.class, vehicleId);
		
	}
}
