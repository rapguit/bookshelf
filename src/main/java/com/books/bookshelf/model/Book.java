package com.books.bookshelf.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
public class Book {

    @Id @NotBlank private String isbn;

    @NotBlank private String title;
    private String subtitle;
    private List<String> authors;
    private ZonedDateTime published;
    private String publisher;
    private Integer pages;
    private String description;
    private Boolean instock;
}
