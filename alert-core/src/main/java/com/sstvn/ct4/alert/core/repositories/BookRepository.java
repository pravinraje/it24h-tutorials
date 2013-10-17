package com.sstvn.ct4.alert.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sstvn.ct4.alert.core.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
