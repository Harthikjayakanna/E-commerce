package com.printle.Ccommerce.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.printle.Ccommerce.DTO.User;
import com.printle.Ccommerce.Repository.UserRepository;
import com.printle.Ccommerce.Service.UserService;

@Repository
public class UserDAO {	
	@Autowired
	private UserRepository rep;
	
	public User saveUser(User u) {
		return rep.save(u);
	}
	public User updateUser(User u) {
		return rep.save(u);
	}
	public Optional<User> getbyID(int id) {
		return rep.findById(id);
	}
	public List<User> findybyEmail(String email){
		return rep.findbyEmailPassword(email);
	}
	public Optional<User> VerifyByEmailandPassword(String email,String password){
		return rep.VerifyByEmailandPassword(email, password);
	}
	public Optional<User> findbyphone(long phone){
		return rep.findbyphone(phone);
	}


}
