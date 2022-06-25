package com.api.book.bootrestbook1.dao;

import com.api.book.bootrestbook1.Entities.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    
    public Book findById(int id);
}
