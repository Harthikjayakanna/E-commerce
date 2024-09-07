package com.printle.Ccommerce.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.printle.Ccommerce.DAO.StudentDAO;
import com.printle.Ccommerce.DTO.Student;

@Service
public class StudentService {
	@Autowired	
	private StudentDAO dao;
	public ResponseEntity<Student> savestudent(Student st){
		System.out.println(st);
		Student str= dao.Save(st);
		return new ResponseEntity<Student>(str,HttpStatus.CREATED);	
	}
	
	public ResponseEntity<Student> findByid(int id) throws Exception{
		Optional<Student> getst= dao.getByid(id);
		if(getst.isPresent()) {
			Student st=getst.get();
			return new ResponseEntity<Student>(st,HttpStatus.OK);
		}
	    throw new Exception();
			
	}

}
