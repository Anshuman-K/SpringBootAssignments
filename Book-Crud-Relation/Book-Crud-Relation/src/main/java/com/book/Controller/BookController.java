package com.book.Controller;

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
import com.book.DTO.BookDTO;
import com.book.Service.BookService;


@RestController
@RequestMapping("/bookservice")
public class BookController {
	
	@Autowired
	BookService service;
	
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
	public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO data) {
		BookDTO details = service.createBook(data);
		return new ResponseEntity<BookDTO>(details, HttpStatus.OK);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
		String data = service.deleteBook(id);
		return new ResponseEntity<String>(data, HttpStatus.OK);
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<BookDTO> updateBook(@PathVariable("id") Long id, @RequestBody BookDTO data) {
		BookDTO detail = service.updateBook(id, data);
		return new ResponseEntity<BookDTO>(detail, HttpStatus.OK);
	}
}
