package com.books.bookshelf.repository;

import com.books.bookshelf.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByTitleOrDescription(String title, String description);
}
