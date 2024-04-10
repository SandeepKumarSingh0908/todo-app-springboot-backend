package com.todo.master.service;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.ISignaturePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.master.exception.NotAValidUserIdException;
import com.todo.master.model.Todo;
import com.todo.master.repo.TodoRepository;
import com.todo.master.rest.response.GenericResponse;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository todoRepo;
	
	private boolean validateReq(Object obj) {
		if(obj instanceof Long) {
			Long id = (Long) obj;
			return id>0;
		}else {
			return false;
		}
	}
	
	public GenericResponse<List<Todo>> getTodos(Long userId){
		GenericResponse<List<Todo>> apiResponse = new GenericResponse<>();
		try {
			boolean isReqValidated = validateReq(userId);
			if(isReqValidated) {
				apiResponse.setObj(todoRepo.findByUserId(userId));
				apiResponse.setMessage("Successfully got the todo's");
				return apiResponse;
			}else {
				throw new NotAValidUserIdException(String.format("User id is incorret",userId));
			}
		}catch(Exception e) {
			throw e;
		}
	}
}
