package com.books.bookshelf.vo;

import com.books.bookshelf.model.Book;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class Bookshelf {
    @Singular("book") private List<Book> bookshelf;
}
