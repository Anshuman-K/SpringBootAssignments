package com.book.DTO;

import org.springframework.stereotype.Component;

import com.book.Entity.BookEntity;



@Component
public class BookDTO {
	
	private Long bookId;
	private String name;
	private String publication;
	private String category;
	private Integer pages;
	private Integer price;
	AuthorDTO author;
	
	public BookDTO() {}
	public BookDTO(Long bookId, String name, String publication, String category, Integer pages, Integer price,
			AuthorDTO author) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.publication = publication;
		this.category = category;
		this.pages = pages;
		this.price = price;
		this.author = author;
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
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public AuthorDTO getAuthor() {
		return author;
	}
	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "BookDTO [bookId=" + bookId + ", name=" + name + ", publication=" + publication + ", category="
				+ category + ", pages=" + pages + ", price=" + price + ", author=" + author + "]";
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
