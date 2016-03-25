package com.mng.demo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mng.demo.dao.StudentDAO;
import com.mng.demo.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	
	@PersistenceContext(unitName="entityManagerFactoryBean1")
	@Autowired
	@Qualifier(value="entityManagerFactoryBean1")
	private EntityManager entityManager;
	
	@Override
	public void add(Student student) {

		System.out.println("Adding student");
		entityManager.persist(student);
		
		System.out.println("Added student");
	}
}
