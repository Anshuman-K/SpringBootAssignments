package com.crud.BookCrud.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.BookCrud.DTO.BookDTO;
import com.crud.BookCrud.Entity.BookEntity;
import com.crud.BookCrud.Repository.BookRepository;


@Service
public class BookServices {
	
	@Autowired
	BookRepository bookRepo;

	public List<BookDTO> getAllBooks() {
		List<BookEntity> data= bookRepo.findAll();
		List<BookDTO> value =  new ArrayList<>();
		for(BookEntity items : data) {
			value.add(BookEntity.prepareBookDTO(items));
		}
		return value;
	}

	public BookDTO getBook(Long id) {
		Optional<BookEntity> data = bookRepo.findById(id);
		BookEntity detail = data.get();
		return BookEntity.prepareBookDTO(detail);
	}

	public BookDTO CreateBook(BookDTO data) {
		BookEntity detail = bookRepo.save(BookDTO.prepareEntity(data));
		return BookEntity.prepareBookDTO(detail);
	}

	public String DeleteBook(Long id) {
		bookRepo.deleteById(id);
		return "done";
	}

	public BookDTO UpdateBook(Long id, BookDTO data) {
		Optional<BookEntity> value = bookRepo.findById(id);
		BookEntity detail = value.get();
		detail.setAuthor(data.getAuthor());
		detail.setBookId(data.getBookId());
		detail.setCategory(data.getCategory());
		detail.setName(data.getName());
		detail.setPages(data.getPages());
		detail.setPrice(data.getPrice());
		detail.setPublication(data.getPublication());
		
		return BookEntity.prepareBookDTO(detail);
	}
	
	

}
