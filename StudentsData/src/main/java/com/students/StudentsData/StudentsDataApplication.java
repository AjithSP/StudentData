package com.students.StudentsData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class StudentsDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsDataApplication.class, args);
	}

}
