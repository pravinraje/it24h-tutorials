package com.sstvn.ct4.alert.web.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sstvn.ct4.alert.core.models.Book;
import com.sstvn.ct4.alert.core.repositories.BookRepository;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired BookRepository bookRepository;
	
	@RequestMapping("/bookstore")
	public @ResponseBody List<Book> listBook() {
		return bookRepository.findAll();
	}
	
	@RequestMapping("/fixtures")
	public @ResponseBody String bookFixtures() {
		bookRepository.save(new Book("Harry Potter", true));
		bookRepository.save(new Book("Titanic Ship", true));
		bookRepository.save(new Book("Alice Adventure", true));
		
		return "Add Book Ok";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Book> list() {
		return bookRepository.findAll();
	}
	
	@RequestMapping("/{id}")
	public @ResponseBody Book get(@PathVariable("id") Long id) {
		return bookRepository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody String create(@RequestBody String name, BindingResult result) {
		bookRepository.save(new Book(name, true));
		return "Create OK";
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public @ResponseBody String update(@PathVariable Long id, @RequestBody Book book, BindingResult result) {
		book.setId(id);
		bookRepository.save(book);
		return "Update OK";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable Long id, BindingResult result) {
		bookRepository.delete(id);
		return "Delete OK";
	}
}
