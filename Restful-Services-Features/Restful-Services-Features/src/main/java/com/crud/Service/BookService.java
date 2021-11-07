package com.crud.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;
import com.crud.CustomException.BusinessException;
import com.crud.DTO.BookDTO;
import com.crud.Entity.BookEntity;
import com.crud.Repository.BookRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;


////////////////////////////////////////////////////////Author////////////////////////////////////////////
	
	
	public List<BookDTO> getAllBooks_author() { 
		try {
		List<BookEntity> data = bookRepository.findAll();
		if(data.isEmpty()) {
			throw new BusinessException("601","Data not found");
		}
		List<BookDTO> value = new ArrayList<>();
		for(BookEntity items: data) {
			value.add(BookEntity.prepareDTO(items));
		}
	return value;
		}catch(Exception e){
			throw new BusinessException("602","Something went wrong -- " + e.getMessage());
		}
	}
		

	public BookDTO getBook_author(Long id){
		try {
//			if(id <= 0) {
//				throw new BusinessException("603","Please enter correct id");
//			}
			Optional<BookEntity> data = bookRepository.findById(id);
		
			if(data.isEmpty()) {
				throw new BusinessException("601","Data not found");
			}
			BookEntity detail = data.get();
			return BookEntity.prepareDTO(detail);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("605","Please enter correct id");
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("601","Data not found");
		}catch(Exception e){
			throw new BusinessException("602","Something went wrong" + e.getMessage());
		}
	
	}

	public BookDTO createBook_author(BookDTO data) {
		try {
			if(data.getName().isEmpty() || data.getName().length() == 0) {
				throw new BusinessException("604","Your field is empty");
			}
			BookEntity detail = bookRepository.save(BookDTO.prepareEntity(data));
			return BookEntity.prepareDTO(detail);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("601","Data not found");
		}catch(Exception e) {
			throw new BusinessException("602","Something went wrong" + e.getMessage());
		}
	
	}

	public String deleteBook_author(Long id) {
		try {
//			if(id <= 0) {
//				throw new BusinessException("603","Please enter correct id");
//			}
			bookRepository.deleteById(id);
			return "Done";
		}catch(IllegalArgumentException e) {
			throw new BusinessException("605","Please enter correct id");
		}catch(Exception e) {
			throw new BusinessException("602","Something went wrong" + e.getMessage());
		}
	
	}

	public BookDTO updateBook_author(Long id, BookDTO data) {
		try {
//			if(id <= 0) {
//				throw new BusinessException("603","Please enter correct id");
//			}
			if(data.getName().isEmpty() || data.getName().length() == 0) {
				throw new BusinessException("604","Your field is empty");
			}
			
			Optional<BookEntity> value = bookRepository.findById(id);
			
			BookEntity detail = value.get();
			detail.setAuthor(data.getAuthor());
			detail.setBookId(data.getBookId());
			detail.setCategory(data.getCategory());
			detail.setName(data.getName());
	        detail.setPrice(data.getPrice());
		    detail.setPages(data.getPages());
			detail.setPublication(data.getPublication());
			detail.setRegistrationNo(data.getRegistrationNo());
			detail.setAuthorNo(data.getAuthorNo());
			return BookEntity.prepareDTO(detail);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("605","Please enter correct id");
		}catch(Exception e) {
			throw new BusinessException("602","Something went wrong" + e.getMessage());
		}
		
	}

//////////////////////////////////////////////////////Reader////////////////////////////////////////////////////
	
	
	public MappingJacksonValue getAllBooks_reader() {
		
		try {
			List<BookEntity> data = bookRepository.findAll();
			if(data.isEmpty()) {
				throw new BusinessException("601","Data not found");
			}
			List<BookEntity> value = new ArrayList<>();
			for(BookEntity items: data) {
				value.add(items);
			}
			Set<String> fields = new HashSet<String>();
			fields.add("name");
			fields.add("author");
			fields.add("publication");
			fields.add("category");
			fields.add("pages");
			fields.add("price");
			
			FilterProvider  FilterProvider = new SimpleFilterProvider().addFilter("bookFilter",
			SimpleBeanPropertyFilter.filterOutAllExcept(fields));
			MappingJacksonValue mapper = new MappingJacksonValue(value);
		    mapper.setFilters(FilterProvider);
			return mapper;
		}catch(Exception e){
			throw new BusinessException("602","Something went wrong" + e.getMessage());
		}
		
	
	}

	
	public MappingJacksonValue getBook_reader(Long id) {
		try {
			if(id <= 0) {
				throw new BusinessException("603","Please enter correct id");
			}
			Optional<BookEntity> data = bookRepository.findById(id);
			if(data.isEmpty()) {
				throw new BusinessException("601","Data not found");
			}
			BookEntity detail = data.get();
			
			Set<String> fields = new HashSet<String>();
			fields.add("name");
			fields.add("author");
			fields.add("publication");
			fields.add("category");
			fields.add("pages");
			fields.add("price");
			
			FilterProvider  FilterProvider = new SimpleFilterProvider().addFilter("bookFilter",
			SimpleBeanPropertyFilter.filterOutAllExcept(fields));
			MappingJacksonValue mapper = new MappingJacksonValue(detail);
		    mapper.setFilters(FilterProvider);
			return mapper;
			}catch(IllegalArgumentException e) {
				throw new BusinessException("605","Please enter correct id");
			}catch(java.util.NoSuchElementException e) {
				throw new BusinessException("601","Data not found");
			}catch(Exception e){
				throw new BusinessException("602","Something went wrong" + e.getMessage());
			}
		
	}

}
