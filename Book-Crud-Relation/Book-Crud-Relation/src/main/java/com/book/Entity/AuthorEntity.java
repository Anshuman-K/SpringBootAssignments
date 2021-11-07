package com.book.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.book.DTO.AuthorDTO;
import com.book.DTO.BookDTO;


@Entity
@Table(name="Author")
public class AuthorEntity {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long authorId;
	private String name;
	private Integer age;
	private String address;
	
	@OneToMany()
	List<BookDTO> books = new ArrayList<>();
	
	public AuthorEntity() {}
	public AuthorEntity(Long authorId, String name, Integer age, String address, List<BookDTO> books) {
		super();
		this.authorId = authorId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.books = books;
	}
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
	
	@Override
	public String toString() {
		return "AuthorEntity [authorId=" + authorId + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", books=" + books + "]";
	}
	
	public static AuthorDTO prepareDTO(AuthorEntity authorEntity) {
		AuthorDTO value = new AuthorDTO();
        value.setAddress(authorEntity.getAddress());
        value.setAge(authorEntity.getAge());
        value.setAuthorId(authorEntity.getAuthorId());
        value.setBooks(authorEntity.getBooks());
        value.setName(authorEntity.getName());
		return value;
		
	}
}

//(mappedBy = "AuthorEntity")