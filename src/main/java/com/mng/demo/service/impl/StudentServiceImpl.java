package com.mng.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mng.demo.dao.StudentDAO;
import com.mng.demo.model.Student;
import com.mng.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;
	
	@Override
	public void add(Student student) {
		
		System.out.println("StudentServiceImpl add...");
		studentDAO.add(student);

		System.out.println("StudentServiceImpl add...completed");
	}

}
