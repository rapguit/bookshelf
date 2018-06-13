package com.books.bookshelf.dto;

import com.books.bookshelf.model.Book;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bookshelf {
    @Singular("book") private List<Book> bookshelf;
}
