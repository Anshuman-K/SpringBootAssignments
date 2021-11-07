package com.crud.DTO;

import org.springframework.stereotype.Component;
import com.crud.Entity.BookEntity;

@Component
public class BookDTO {

private Long bookId;
private String name;
private String  author;
private String publication;
private String category;
private Integer pages;
private Integer price;
private Integer registrationNo;
private String authorNo;

public BookDTO() {}

public BookDTO(Long bookId, String name, String author, String publication, String category, Integer pages, Integer price,
		Integer registrationNo, String authorNo) {
	super();
	this.bookId = bookId;
	this.name = name;
	this.author = author;
	this.publication = publication;
	this.category = category;
	this.pages = pages;
	this.price = price;
	this.registrationNo = registrationNo;
	this.authorNo = authorNo;
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

public Integer getRegistrationNo() {
	return registrationNo;
}

public void setRegistrationNo(Integer registrationNo) {
	this.registrationNo = registrationNo;
}

public String getAuthorNo() {
	return authorNo;
}

public void setAuthorNo(String authorNo) {
	this.authorNo = authorNo;
}


@Override
public String toString() {
	return "DTO [bookId=" + bookId + ", name=" + name + ", author=" + author + ", publication=" + publication
			+ ", category=" + category + ", pages=" + pages + ", price=" + price + ", registrationNo=" + registrationNo
			+ ", authorNo=" + authorNo + "]";
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
    value.setAuthorNo(data.getAuthorNo());
    value.setRegistrationNo(data.getRegistrationNo());
	return value;
}


}
