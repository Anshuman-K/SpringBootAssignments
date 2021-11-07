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
import com.book.DTO.AuthorDTO;
import com.book.Service.AuthorService;


@RestController
@RequestMapping("/authorservice")
public class AuthorController {
	
	@Autowired
	AuthorService service;
	
	@GetMapping("/authors")
	public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
		List<AuthorDTO> data = service.getAllAuthors();
		return new ResponseEntity<List<AuthorDTO>>(data, HttpStatus.OK);
	}
	
	@GetMapping("/authors/{id}")
	public ResponseEntity<AuthorDTO> getAuthor(@PathVariable("id") Long id) {
		AuthorDTO data = service.getAuthor(id);
		return new ResponseEntity<AuthorDTO>(data, HttpStatus.OK);
	}
	
	@PostMapping("/authors")
	public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO data) {
		AuthorDTO details = service.createAuthor(data);
		return new ResponseEntity<AuthorDTO>(details, HttpStatus.OK);
	}
	
	@DeleteMapping("/authors/{id}")
	public ResponseEntity<String> deleteAuthor(@PathVariable("id") Long id) {
		String data = service.deleteAuthor(id);
		return new ResponseEntity<String>(data, HttpStatus.OK);
	}
	
	@PutMapping("/authors/{id}")
	public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable("id") Long id, @RequestBody AuthorDTO data) {
		AuthorDTO detail = service.updateAuthor(id, data);
		return new ResponseEntity<AuthorDTO>(detail, HttpStatus.OK);
	}
}
