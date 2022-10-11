package com.students.StudentsData.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.students.StudentsData.dao.StudentRepository;
import com.students.StudentsData.model.Student;

@RestController
public class StudentDataController {
	
	@Autowired
	StudentRepository studentRepository;
	
	//Api to add student
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		 studentRepository.save(student);
		 return student;
	}
	
	//Api to fetch all students
	@GetMapping("/Students")
	public List<Student> getStudent() {
		  
		 return studentRepository.findAll(); 
		 
	}
	
	//Api to fetch student by id
	@GetMapping("/Student/{id}")
	public Optional<Student> getStudent(@PathVariable int id) {
		 return studentRepository.findById(id); 
		 
	}
	
	//Api to calculate Age using DOB of the student and update the student table
	@PostMapping("/calculateAge/{id}")
	public String calculateAge(@PathVariable int id) {
		Student student= studentRepository.findById(id).get();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
		LocalDate dob= LocalDate.parse(student.getDobDate(),formatter);
		LocalDate curDate = LocalDate.now(); 
		Period period = Period.between(dob, curDate);  
		int age=period.getYears();
		student.setAge(age);
		studentRepository.save(student);
		return "Age is "+age;
		
	}
	
	// Get students of age 18 to 25years
	@GetMapping("/getStudents")
	public List<Student> fetchStudents(){
		List<Student> sList=studentRepository.findAll();
		List<Student> fList=sList.stream().filter(s->s.getAge()>=18 && s.getAge()<=25).collect(Collectors.toList());
		
		return fList;
		
	}
	
	
}
