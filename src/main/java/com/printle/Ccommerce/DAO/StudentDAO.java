package com.printle.Ccommerce.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.printle.Ccommerce.DTO.Student;
import com.printle.Ccommerce.Repository.StudentRepository;

@Repository
public class StudentDAO {
	@Autowired
	private StudentRepository rep;
	
	public Student Save(Student st) {
		return rep.save(st);
	}
	
	public Student Update(Student st) {
		return rep.save(st);
	}
	
	public Optional<Student> getByid(int id){
		return rep.findById(id);
	}
	
	
	
	

}
