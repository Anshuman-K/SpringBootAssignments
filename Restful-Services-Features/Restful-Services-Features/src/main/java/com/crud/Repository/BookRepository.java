package com.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.Entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> { 

}
