package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

//mark class as Controller
@RestController
public class UserController {
//autowire the UserService class
	@Autowired
	UserService userServices;

//creating a get mapping that retrieves all the users detail from the database 
	@GetMapping("/user")
	private List<UserModel> getAllUsers() {
		return userServices.getAllUsers();
	}

//creating a get mapping that retrieves the detail of a specific user
	@GetMapping("/users/{userId}")
	private UserModel getUsers(@PathVariable("userId") int userId) {
		return userServices.getUserById(userId);
	}

//creating a delete mapping that deletes a specified user
	@DeleteMapping("/user/{userId}")
	private void deleteUser(@PathVariable("userId") int userId) {
		userServices.delete(userId);
	}

//creating post mapping that post the user detail in the database
	@PostMapping("/users")
	private int saveUser(@RequestBody UserModel userModel) {
		userServices.saveOrUpdate(userModel);
		return userModel.getUserId();
	}

//creating put mapping that updates the user detail 
	@PutMapping("/users")
	private UserModel update(@RequestBody UserModel userModel) {
		userServices.saveOrUpdate(userModel);
		return userModel;
	}
}
