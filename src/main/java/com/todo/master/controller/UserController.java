package com.todo.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.master.rest.request.CreateUserRequest;
import com.todo.master.rest.response.GenericResponse;
import com.todo.master.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userSvc;

	@PostMapping("/create")
	public ResponseEntity<GenericResponse<String>> createUser(@RequestBody CreateUserRequest req) {
		GenericResponse<String> apiResponse = userSvc.createUser(req);
		return new ResponseEntity<GenericResponse<String>>(apiResponse, HttpStatus.OK);
	}
}
