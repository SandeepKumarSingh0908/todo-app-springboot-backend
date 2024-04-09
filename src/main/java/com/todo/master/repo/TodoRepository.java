package com.todo.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.master.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
	public List<Todo> getByUserId(Long userId);
}
