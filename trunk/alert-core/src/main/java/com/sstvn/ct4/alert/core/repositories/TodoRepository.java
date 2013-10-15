package com.sstvn.ct4.alert.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sstvn.ct4.alert.core.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	public List<Todo> findAllByCompleted(boolean completed);
}
