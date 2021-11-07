package com.book.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.DTO.BookDTO;
import com.book.Entity.BookEntity;
import com.book.Repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	public List<BookDTO> getAllBooks() {
		List<BookEntity> data = bookRepository.findAll();
		List<BookDTO> value = new ArrayList<>();
		for(BookEntity items: data) {
			value.add(BookEntity.prepareDTO(items));
		}
	return value;
	}

	public BookDTO getBook(Long id) {
		Optional<BookEntity> data = bookRepository.findById(id);
		BookEntity detail = data.get();
		return BookEntity.prepareDTO(detail);
	}

	public String deleteBook(Long id) {
		bookRepository.deleteById(id);
		return "Done";
	}

	public BookDTO createBook(BookDTO data) {
		BookEntity detail = bookRepository.save(BookDTO.prepareEntity(data));
		return BookEntity.prepareDTO(detail);
	}

	public BookDTO updateBook(Long id, BookDTO data) {
		Optional<BookEntity> value = bookRepository.findById(id);
		BookEntity detail = value.get();
		detail.setAuthor(data.getAuthor());
		detail.setBookId(data.getBookId());
		detail.setCategory(data.getCategory());
		detail.setName(data.getName());
		detail.setPrice(data.getPrice());
		detail.setPages(data.getPages());
		detail.setPublication(data.getPublication());
		return BookEntity.prepareDTO(detail);
	}

}
