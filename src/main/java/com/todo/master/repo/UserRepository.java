package com.todo.master.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.master.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
