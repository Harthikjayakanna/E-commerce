package com.printle.Ccommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.printle.Ccommerce.DTO.LoginCre;
import com.printle.Ccommerce.DTO.Student;
import com.printle.Ccommerce.DTO.User;
import com.printle.Ccommerce.Service.UserService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Controller
@ResponseBody
@CrossOrigin
public class UserController {
	@Autowired
	private UserService ser;
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		System.out.println(user);
		return ser.saveUser(user);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws Exception {
		return ser.findByid(id);
	}
	@GetMapping("/usersEmail")
	public ResponseEntity<List<User>> getByEmail(@RequestParam String email) {
		return ser.findbyEmail(email);
	}
	@GetMapping("/usersLogin")
	public ResponseEntity<User>getMethodName(@RequestParam String email,@RequestParam String password) {
		return ser.verifybyEmailandPassword(email,password);
	}
	@PutMapping("usersd/{id}")
	public ResponseEntity<User> ChangeAge(@PathVariable int id, @RequestBody User u) {
		//TODO: process PUT request
		
		return ser.updateUser(id, u);
	}
	@GetMapping("/usersphn")
	public ResponseEntity<User>getByphone(@RequestParam long phone){
		return ser.findbyphone(phone);
	}
	
	

}