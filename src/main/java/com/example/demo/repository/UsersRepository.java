package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.UserModel;
//repository that extends CrudRepository
public interface UsersRepository extends CrudRepository<UserModel, Integer>
{
}
