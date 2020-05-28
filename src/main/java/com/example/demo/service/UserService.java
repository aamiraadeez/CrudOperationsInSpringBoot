package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UsersRepository;

//defining the business logic
@Service
public class UserService {
	@Autowired
	UsersRepository usersRepository;

//getting all users record by using the method findaAll() of CrudRepository
	public List<UserModel> getAllUsers() {
		List<UserModel> userModel = new ArrayList<UserModel>();
		usersRepository.findAll().forEach(user1 -> userModel.add(user1));
		return userModel;
	}

//getting a specific record by using the method findById() of CrudRepository
	public UserModel getUserById(int id) {
		return usersRepository.findById(id).get();
	}

//saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(UserModel userModel) {
		usersRepository.save(userModel);
	}

//deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(int id) {
		usersRepository.deleteById(id);
	}

//updating a record
	public void update(UserModel userModel, int userId) {
		usersRepository.save(userModel);
	}
}