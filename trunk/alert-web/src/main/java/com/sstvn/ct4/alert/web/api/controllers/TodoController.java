package com.sstvn.ct4.alert.web.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sstvn.ct4.alert.core.models.Book;
import com.sstvn.ct4.alert.core.models.Student;
import com.sstvn.ct4.alert.core.models.Todo;
import com.sstvn.ct4.alert.core.repositories.StudentRepository;
import com.sstvn.ct4.alert.core.repositories.TodoRepository;


@Controller
@RequestMapping("/todos")
public class TodoController {

	@Autowired TodoRepository todoRepository;
	@Autowired StudentRepository studentRepository;
	
	@RequestMapping("/students")
	public @ResponseBody List<Student> listStudent() {
		return studentRepository.findAll();
	}
	
	@RequestMapping("/student/fixtures") 
	public @ResponseBody String studentFixtures() {
		studentRepository.save(new Student("Khoi", "abc"));
		studentRepository.save(new Student("Nghi", "def"));
		return "OK";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Todo> list() {
		return todoRepository.findAll();
	}
	
	@RequestMapping("/status/{status}")
	public @ResponseBody List<Todo> listByStatus(@PathVariable("status") String status) {
		Boolean isCompleted = status.equals("completed") ? true : false;
		
		return todoRepository.findAllByCompleted(isCompleted);
	}
	
	@RequestMapping("/{id}")
	public @ResponseBody Todo get(@PathVariable("id") Long id) {
		return todoRepository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody String create(@RequestBody String name, BindingResult result) {
		System.err.print("----------POST-------------" +name);
		todoRepository.save(new Todo(name, true));
		return "OK";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody String update(@PathVariable Long id, @RequestBody String name, BindingResult result) {
		System.err.print("------------------PUT-----------------" +name);
		Todo todo = todoRepository.findOne(id);
		todo.setTitle(name);
		todoRepository.save(todo);
		return "OK";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable Long id) {
		System.err.print("-----------------========DELETE===================------" +id);
		todoRepository.delete(id);
		return "OK";
	}
	
	@RequestMapping("/fixtures") 
	public @ResponseBody String fixtures() {
		todoRepository.save(new Todo("Hello", true));
		todoRepository.save(new Todo("World", true));
		return "OK";
	}
}
