package com.books.bookshelf.service;

import com.books.bookshelf.model.Book;
import com.books.bookshelf.repository.BookRepository;
import com.books.bookshelf.vo.Bookshelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookshelfService {

    @Autowired private BookRepository repo;

    public Bookshelf getAll() {
        List<Book> books = repo.findAll();
        return Bookshelf.builder().bookshelf(books).build();
    }

    public Book save(Book book) {
        return repo.save(book);
    }

    public void delete(String isbn) {
        repo.deleteById(isbn);
    }
}
