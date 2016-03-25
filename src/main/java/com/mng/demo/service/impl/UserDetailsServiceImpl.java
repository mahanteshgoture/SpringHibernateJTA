package com.mng.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mng.demo.dao.UserDetailsDAO;
import com.mng.demo.model.Student;
import com.mng.demo.model.UserDetails;
import com.mng.demo.service.StudentService;
import com.mng.demo.service.UserDetailsService;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private StudentService studentService;

	@Autowired
	private UserDetailsDAO userDetailsDAO;
	
	@Override
	public void addUserDetails(UserDetails userDetails)
	{
		System.out.println("UserDetailsServiceImpl add...");
		userDetailsDAO.addUserDetails(userDetails);

		System.out.println("UserDetailsServiceImpl add...completed");
		
		Student student=new Student();
		student.setName("Mahantesh");
		
		studentService.add(student);
		
//		throw new NullPointerException();
		
	}

}
