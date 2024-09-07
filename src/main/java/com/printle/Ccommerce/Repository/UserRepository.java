package com.printle.Ccommerce.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.printle.Ccommerce.DTO.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.email=?1")
	public List<User> findbyEmailPassword(String email);
	@Query("select u from User u where u.email=?1 and u.password=?2")
	public Optional<User> VerifyByEmailandPassword(String email,String password);
	@Query("select u from User u where u.phone=?1")
	public Optional<User> findbyphone(long phone);

}
