package com.sandeep.ws.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sandeep.ws.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findById(Long id);
}
