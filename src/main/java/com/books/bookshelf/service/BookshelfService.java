package com.books.bookshelf.service;

import com.books.bookshelf.dto.Bookshelf;
import com.books.bookshelf.model.Book;
import com.books.bookshelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class BookshelfService {

    @Autowired private BookRepository repo;

    public Bookshelf getAll() {
        List<Book> books = repo.findAll();
        return Bookshelf.builder().bookshelf(books).build();
    }

    public Optional<Book> findOne(String isbn) {
        return repo.findById(isbn);
    }

    public Book save(Book book) {
        return repo.save(book);
    }

    public void delete(String isbn) {
        repo.deleteById(isbn);
    }

    public Bookshelf findBy(String title, String description) {
        if(isBlank(title) && isBlank(description)) return getAll();

        Example<Book> bookCriteria = buildCriteria(title, description);
        List<Book> foundBooks = repo.findAll(bookCriteria);

        return Bookshelf.builder().bookshelf(foundBooks).build();
    }

    private Example<Book> buildCriteria(String title, String description) {
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreNullValues()
                .withIgnoreCase(true);

        return Example.of(
                Book.builder().title(title).description(description).build(),
                matcher
        );
    }
}
