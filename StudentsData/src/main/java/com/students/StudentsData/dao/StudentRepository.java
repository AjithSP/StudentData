package com.students.StudentsData.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.StudentsData.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

		
	

}
