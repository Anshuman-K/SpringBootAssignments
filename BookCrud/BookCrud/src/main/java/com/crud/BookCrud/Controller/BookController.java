package com.crud.BookCrud.Controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.BookCrud.DTO.BookDTO;
import com.crud.BookCrud.Services.BookServices;


@RestController
@RequestMapping("/bookservice")
public class BookController {
	
	@Autowired
	BookServices service;
	
	@GetMapping("/books")
	public ResponseEntity<List<BookDTO>> getAllBooks() {
		List<BookDTO> data = service.getAllBooks();
		return new ResponseEntity<List<BookDTO>>(data, HttpStatus.OK);
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<BookDTO> getBook(@PathVariable("id") Long id) {
		BookDTO data = service.getBook(id);
		return new ResponseEntity<BookDTO>(data, HttpStatus.OK);
	}
	
	@PostMapping("/books")
	public ResponseEntity<BookDTO> CreateBook(@RequestBody BookDTO data) {
		BookDTO details = service.CreateBook(data);
		return new ResponseEntity<BookDTO>(details, HttpStatus.OK);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> DeleteBook(@PathVariable("id") Long id) {
		String data = service.DeleteBook(id);
		return new ResponseEntity<String>(data, HttpStatus.OK);
	}
	 	
	@PutMapping("/books/{id}")
	public ResponseEntity<BookDTO> UpdateBook(@PathVariable("id") Long id, @RequestBody BookDTO data) {
		BookDTO detail = service.UpdateBook(id, data);
		return new ResponseEntity<BookDTO>(detail, HttpStatus.OK);
	}
}
