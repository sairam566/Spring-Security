package com.example.demo.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("get/javastudents")
public class StudentController {
	
	private static final List<Student> students 
	= Arrays.asList(new Student(1,"sai"),
					new Student(2,"ram"),
					new Student(3, "thadi")
					);
	
	@GetMapping(path = "{studentId}")
	public Student getStudentDtls(@PathVariable("studentId") Integer studentId) {
		return students.stream()
				.filter(student -> studentId.equals(student.getStudentId()))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Student Id "+studentId+" Not found"));
	}
}
