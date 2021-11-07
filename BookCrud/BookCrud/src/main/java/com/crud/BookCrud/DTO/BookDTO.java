package com.crud.BookCrud.DTO;

import org.springframework.stereotype.Component;

import com.crud.BookCrud.Entity.BookEntity;

@Component
public class BookDTO {

	private Long bookId;
	private String name; 
	private String author; 
	private String publication;
	private String category;
	private Integer price; 
	private Integer pages;
	
	public BookDTO() {
		
	}
	public BookDTO(Long bookId, String name, String author, String publication, String category, Integer price,
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
		return "BookDTO [bookId=" + bookId + ", name=" + name + ", author=" + author + ", publication=" + publication
				+ ", category=" + category + ", price=" + price + ", pages=" + pages + "]";
	}
	
	public static BookEntity prepareEntity(BookDTO data) {
		BookEntity value = new BookEntity();
		value.setAuthor(data.getAuthor());
		value.setBookId(data.getBookId());
		value.setCategory(data.getCategory());
		value.setName(data.getName());
		value.setPages(data.getPages());
		value.setPrice(data.getPrice());
		value.setPublication(data.getPublication());
		return value; 
	}
	
	
}
