package com.academetrics.academetrics;

import com.academetrics.academetrics.Entity.Student;
import com.academetrics.academetrics.Repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;

@SpringBootApplication
public class AcademetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademetricsApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	// TODO: Fix
//	@Autowired
//	private StudentRepository studentRepository;
//
//	@PostConstruct
//	public void calculateAllStudentGPAs() {
//		Iterable<Student> students = studentRepository.findAll();
//
//		for (Student student : students) {
//			student.calculateGPA();
//			studentRepository.save(student);
//		}
//	}
}
