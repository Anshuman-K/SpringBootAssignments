package com.crud.BookCrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.BookCrud.Entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long>{

}
