package com.books.bookshelf.controller;

import com.books.bookshelf.model.Book;
import com.books.bookshelf.service.BookshelfService;
import com.books.bookshelf.dto.Bookshelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/bookshelf")
public class BookshelfController {

    @Autowired private BookshelfService service;

    @GetMapping
    public Bookshelf getBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String desc){
        return service.findBy(title, desc);
    }

    @GetMapping("{isbn}")
    public Book getBook(@PathVariable String isbn){
        return service.findOne(isbn).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBook(@RequestBody @Valid Book book){
        service.save(book);
    }

    @PutMapping("/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@PathVariable String isbn, @RequestBody @Valid Book book){
        book.setIsbn(isbn);
        service.save(book);
    }

    @DeleteMapping("/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable String isbn){
        service.delete(isbn);
    }
}
