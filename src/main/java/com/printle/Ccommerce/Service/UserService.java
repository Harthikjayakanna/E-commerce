package com.printle.Ccommerce.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.printle.Ccommerce.DAO.UserDAO;
import com.printle.Ccommerce.DTO.Student;
import com.printle.Ccommerce.DTO.User;
import com.printle.Ccommerce.ErrorHandling.ErrorHandlingController;
import com.printle.Ccommerce.ErrorHandling.InvalidCredientials;
import com.printle.Ccommerce.ErrorHandling.NotFound;
import com.printle.Ccommerce.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;	
    @Autowired
    private ErrorHandlingController col;
	public ResponseEntity<User> saveUser(User u) {
		System.out.println(u);
		dao.saveUser(u);
		return new ResponseEntity<User>(u,HttpStatus.CREATED);
	}
	public ResponseEntity<User> findByid(int id) {
		Optional<User> getst= dao.getbyID(id);
		if(getst.isPresent()) {
			User st=getst.get();
			return new ResponseEntity<User>(st,HttpStatus.OK);
		}
		throw new InvalidCredientials();
	}
	public ResponseEntity<List<User>> findbyEmail(String email){
		List<User> optionalu = dao.findybyEmail(email);
		if(!optionalu.isEmpty())
			return new ResponseEntity<List<User>>(optionalu,HttpStatus.OK);
	    throw new InvalidCredientials();
	}
	public ResponseEntity<User> verifybyEmailandPassword(String email,String password){
		Optional<User> opU=dao.VerifyByEmailandPassword(email, password);
		if(opU.isPresent()) {
			return new ResponseEntity<User>(opU.get(),HttpStatus.OK); 
		}
		throw new InvalidCredientials();
	}
	public ResponseEntity<User> updateUser(int id,User u){
		Optional<User> opU=dao.getbyID(id);
		if(opU.isPresent()) {
			User nu=opU.get();
			nu.setEmail(u.getEmail());
			nu.setAge(u.getAge());
			return new ResponseEntity<User>(dao.saveUser(nu),HttpStatus.OK);
		}
		throw new NotFound();
	}
	public ResponseEntity<User> findbyphone(long phone){
		Optional<User> opu=dao.findbyphone(phone);
		if(opu.isPresent()) {
			return new ResponseEntity<User>(opu.get(),HttpStatus.OK);
		}
		throw new NotFound();
	}
	
}
