package com.crud.Controller;

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
import com.crud.CustomException.BusinessException;
import com.crud.CustomException.ControllerException;
import com.crud.DTO.BookDTO;
import com.crud.Service.BookService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/books")
	public ResponseEntity<?> getAllBooks_author() {
		try {
			List<BookDTO> data = service.getAllBooks_author();
			return new ResponseEntity<List<BookDTO>>(data, HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch(Exception e){
			ControllerException ce = new ControllerException("611","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<?> getBook_author(@PathVariable("id") Long id) {
		try {
			BookDTO data = service.getBook_author(id);
			return new ResponseEntity<BookDTO>(data, HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch(Exception e){
			ControllerException ce = new ControllerException("611","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/books")
	public ResponseEntity<?> createBook_author(@RequestBody BookDTO data) {
		try {
			BookDTO details = service.createBook_author(data);
			return new ResponseEntity<BookDTO>(details, HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch(Exception e){
			ControllerException ce = new ControllerException("611","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<?> deleteBook_author(@PathVariable("id") Long id) {
		try {
			String data = service.deleteBook_author(id);
			return new ResponseEntity<String>(data, HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch(Exception e){
			ControllerException ce = new ControllerException("611","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<?> updateBook_author(@PathVariable("id") Long id, @RequestBody BookDTO data) {
		try {
			BookDTO detail = service.updateBook_author(id, data);
			return new ResponseEntity<BookDTO>(detail, HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch(Exception e){
			ControllerException ce = new ControllerException("611","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	
	}
}
