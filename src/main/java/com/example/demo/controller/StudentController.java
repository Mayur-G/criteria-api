package com.example.demo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping(path="/student",produces = APPLICATION_JSON_VALUE)
	public void listOfStudent()
	{	
		studentService.getStudent();
	}
	
	@GetMapping(path="/student1",produces = APPLICATION_JSON_VALUE)
	public void listOfStudent1()
	{	
		studentService.getStudent1();
	}
	
	@GetMapping(path="/student2",produces = APPLICATION_JSON_VALUE)
	public void listOfStudent2()
	{	
		studentService.getStudent2();
	}
	
	@GetMapping(path="/student3",produces = APPLICATION_JSON_VALUE)
	public void listOfStudent3()
	{	
		studentService.getStudent3();
	}
	
	@GetMapping(path="/student4",produces = APPLICATION_JSON_VALUE)
	public void listOfStudent4()
	{	
		studentService.getStudent4();
	}
	
	@GetMapping(path="/student5",produces = APPLICATION_JSON_VALUE)
	public void listOfStudent5()
	{	
		studentService.getStudent5();
	}
	
	@GetMapping(path="/student6",produces = APPLICATION_JSON_VALUE)
	public void listOfStudent6()
	{	
		studentService.getStudent6();
	}
	
	@GetMapping(path="/student7",produces = APPLICATION_JSON_VALUE)
	public void listOfStudent7()
	{	
		studentService.getStudent7();
	}
	
	@GetMapping(path="/student8",produces = APPLICATION_JSON_VALUE)
	public void listOfStudent8()
	{	
		studentService.getStudent8();
	}
	
	@GetMapping(path="/student9",produces = APPLICATION_JSON_VALUE)
	public void listOfStudent9()
	{	
		studentService.getStudent9();
	}
}
