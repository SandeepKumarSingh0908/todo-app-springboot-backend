package com.todo.master.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.master.model.User;
import com.todo.master.repo.UserRepository;
import com.todo.master.rest.request.CreateUserRequest;
import com.todo.master.rest.response.GenericResponse;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public GenericResponse<String> createUser(CreateUserRequest req){
		GenericResponse<String> apiResponse = new GenericResponse<>();
		try {
			User user = new User();
	        user.setName(req.getName());
	        user.setEmail(req.getEmail());
	        user.setPassword(req.getPassword());
	        user.setEnabled(true); // Assuming the user is enabled by default
	        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
	        user.setCreatedDate(timestamp);
	        user.setUpdatedDate(timestamp);
	        userRepo.save(user);
	        apiResponse.setMessage("Success");
	        apiResponse.setObj("Successfully created an user");
	        return apiResponse;
		}catch(Exception e) {
			throw e;
		}
	}
}
