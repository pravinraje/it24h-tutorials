package com.sstvn.ct4.alert.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sstvn.ct4.alert.core.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
}
