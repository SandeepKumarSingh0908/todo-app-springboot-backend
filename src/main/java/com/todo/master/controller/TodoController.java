package com.todo.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.master.model.Todo;
import com.todo.master.rest.response.GenericResponse;
import com.todo.master.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/getTodos/{userId}")
	public ResponseEntity<GenericResponse<List<Todo>>> getTodos(@PathVariable("userId") Long userId){
		GenericResponse<List<Todo>> serviceResponse = todoService.getTodos(userId);
		return new ResponseEntity<GenericResponse<List<Todo>>>(serviceResponse, HttpStatus.OK);
	}
}
