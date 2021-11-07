package com.book.DTO;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.book.Entity.AuthorEntity;


@Component
public class AuthorDTO {
	
	private Long authorId;
	private String name;
	private Integer age;
	private String address;
	List<BookDTO> books = new ArrayList<>();
	
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<BookDTO> getBooks() {
		return books;
	}
	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
	public AuthorDTO() {}
	public AuthorDTO(Long authorId, String name, Integer age, String address, List<BookDTO> books) {
		super();
		this.authorId = authorId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.books = books;
	}
	@Override
	public String toString() {
		return "AuthorDTO [authorId=" + authorId + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", books=" + books + "]";
	}
	
	public static AuthorEntity prepareEntity(AuthorDTO data) {
		AuthorEntity value = new AuthorEntity();
	   value.setAddress(data.getAddress());
	   value.setAge(data.getAge());
	   value.setAuthorId(data.getAuthorId());
	   value.setBooks(data.getBooks());
	   value.setName(data.getName());
		return value;
	}
}
