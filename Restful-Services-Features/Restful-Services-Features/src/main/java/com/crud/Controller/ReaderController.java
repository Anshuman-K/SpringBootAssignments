package com.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.CustomException.BusinessException;
import com.crud.CustomException.ControllerException;
import com.crud.Service.BookService;

@RestController
@RequestMapping("/reader")
public class ReaderController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/books")
	public ResponseEntity<?> getAllBooks_reader() {
		try {
			MappingJacksonValue data = service.getAllBooks_reader();
			return new ResponseEntity<>(data, HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch(Exception e){
			ControllerException ce = new ControllerException("611","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<?> getBook_reader(@PathVariable("id") Long id) {
		try {
			MappingJacksonValue data = service.getBook_reader(id);
			return new ResponseEntity< MappingJacksonValue>(data, HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch(Exception e){
			ControllerException ce = new ControllerException("611","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		 
	}
}
