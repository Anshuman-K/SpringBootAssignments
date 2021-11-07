package com.book.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.book.DTO.AuthorDTO;
import com.book.DTO.BookDTO;

@Entity
@Table(name="Book")
public class BookEntity {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long bookId;
	private String name;
	private String publication;
	private String category;
	private Integer pages;
	private Integer price;
	
	@ManyToOne
	AuthorDTO author;
	
	public BookEntity() {}
	public BookEntity(Long bookId, String name, String publication, String category, Integer pages, Integer price,
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
		return "BookEntity [bookId=" + bookId + ", name=" + name + ", publication=" + publication + ", category="
				+ category + ", pages=" + pages + ", price=" + price + ", author=" + author + "]";
	}
	
	public static BookDTO prepareDTO(BookEntity bookEntity) {
		BookDTO value = new BookDTO();
		value.setAuthor(bookEntity.getAuthor());
	    value.setBookId(bookEntity.getBookId());
	    value.setCategory(bookEntity.getCategory());
	    value.setName(bookEntity.getName());
	    value.setPages(bookEntity.getPrice());
	    value.setPublication(bookEntity.getPublication());
	    value.setPrice(bookEntity.getPrice());
		return value;
		
	}
}
