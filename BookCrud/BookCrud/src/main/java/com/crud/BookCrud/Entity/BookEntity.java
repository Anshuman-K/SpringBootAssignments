package com.crud.BookCrud.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crud.BookCrud.DTO.BookDTO;

@Entity
@Table(name = "book")
public class BookEntity {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long bookId;
	private String name; 
	private String author; 
	private String publication;
	private String category;
	private Integer price; 
	private Integer pages;
	
	public BookEntity() {
		
	}
	
	public BookEntity(Long bookId, String name, String author, String publication, String category, Integer price,
			Integer pages) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.publication = publication;
		this.category = category;
		this.price = price;
		this.pages = pages;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", name=" + name + ", author=" + author + ", publication=" + publication
				+ ", category=" + category + ", price=" + price + ", pages=" + pages + "]";
	}
	
	public static BookDTO prepareBookDTO(BookEntity bookEntity) {
		BookDTO value = new BookDTO();
		value.setAuthor(bookEntity.getAuthor());
		value.setBookId(bookEntity.getBookId());
		value.setCategory(bookEntity.getCategory());
		value.setName(bookEntity.getName());
		value.setPages(bookEntity.getPages());
		value.setPrice(bookEntity.getPrice());
		value.setPublication(bookEntity.getPublication());
		return value; 
	}
	
}
