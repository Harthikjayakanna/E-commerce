package com.printle.Ccommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.printle.Ccommerce.DTO.Student;
import com.printle.Ccommerce.Service.StudentService;

@RestController
@CrossOrigin
public class StudentController {
	@Autowired
	public StudentService ser;
	@PostMapping("/student")
	public ResponseEntity<Student> Save(@RequestBody Student st){
		System.out.println(st);
		return ser.savestudent(st);
	}
	
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id) throws Exception {
		return ser.findByid(id);
	}
	

}
