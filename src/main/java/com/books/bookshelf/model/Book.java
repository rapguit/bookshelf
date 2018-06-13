package com.books.bookshelf.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id @NotBlank private String isbn;

    @NotBlank private String title;
    private String subtitle;
    @Singular private List<String> authors;

    private Date published;

    private String publisher;
    private Integer pages;
    private String description;
    private Boolean inStock;
}
