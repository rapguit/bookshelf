package com.books.bookshelf.controller;

import com.books.bookshelf.IntegrationTest;
import com.books.bookshelf.model.Book;
import com.books.bookshelf.repository.BookRepository;
import com.books.bookshelf.util.TestUtil;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookshelfControllerTest extends IntegrationTest {

    @Autowired private BookRepository repo;

    @After
    public void tearDown() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void should_retrieve_a_book() throws Exception {
        Book book = getObjectMapper().readValue(TestUtil.load("book_sample"), Book.class);
        Book saved = repo.save(book);

        getMockMvc().perform(
                get("/api/bookshelf/{isbn}", saved.getIsbn()))
                .andExpect(status().isOk())
                .andDo(document("bookshelf-find-one",
                        responseFields(
                                fieldWithPath(".isbn").description("The book isbn."),
                                fieldWithPath(".title").description("The book title."),
                                fieldWithPath(".description").description("The book description."),
                                fieldWithPath(".subtitle").description("The book subtitle."),
                                fieldWithPath(".authors[]").description("The book authors names."),
                                fieldWithPath(".published").description("The book published date."),
                                fieldWithPath(".publisher").description("The book publisher name."),
                                fieldWithPath(".pages").description("The book total pages number."),
                                fieldWithPath(".inStock").description("If the book is in stock.")
                        )
                ));
    }

    @Test
    public void should_retrieve_books() throws Exception {
        Book book = getObjectMapper().readValue(TestUtil.load("book_sample"), Book.class);
        repo.save(book);

        getMockMvc().perform(
                get("/api/bookshelf"))
                .andExpect(status().isOk())
                .andDo(document("bookshelf-find-all",
                        responseFields(
                                fieldWithPath("bookshelf[]").description("The books collection."),
                                fieldWithPath("bookshelf[].isbn").description("The book isbn."),
                                fieldWithPath("bookshelf[].title").description("The book title."),
                                fieldWithPath("bookshelf[].description").description("The book description."),
                                fieldWithPath("bookshelf[].subtitle").description("The book subtitle."),
                                fieldWithPath("bookshelf[].authors[]").description("The book authors names."),
                                fieldWithPath("bookshelf[].published").description("The book published date."),
                                fieldWithPath("bookshelf[].publisher").description("The book publisher name."),
                                fieldWithPath("bookshelf[].pages").description("The book total pages number."),
                                fieldWithPath("bookshelf[].inStock").description("If the book is in stock.")
                        )
                ));
    }

    @Test
    public void should_retrieve_a_book_filter_by_title() throws Exception {
        Book book = getObjectMapper().readValue(TestUtil.load("book_sample"), Book.class);
        repo.save(book);

        getMockMvc().perform(
                get("/api/bookshelf")
                        .param("title", "in Action"))
                .andExpect(status().isOk())
                .andDo(document("bookshelf-find-by-title",
                        requestParameters(
                                parameterWithName("title").description("The book title term to filter.")
                        ),
                        responseFields(
                                fieldWithPath("bookshelf[]").description("The books collection."),
                                fieldWithPath("bookshelf[].isbn").description("The book isbn."),
                                fieldWithPath("bookshelf[].title").description("The book title."),
                                fieldWithPath("bookshelf[].description").description("The book description."),
                                fieldWithPath("bookshelf[].subtitle").description("The book subtitle."),
                                fieldWithPath("bookshelf[].authors[]").description("The book authors names."),
                                fieldWithPath("bookshelf[].published").description("The book published date."),
                                fieldWithPath("bookshelf[].publisher").description("The book publisher name."),
                                fieldWithPath("bookshelf[].pages").description("The book total pages number."),
                                fieldWithPath("bookshelf[].inStock").description("If the book is in stock.")
                        )
                ));
    }

    @Test
    public void should_retrieve_a_book_filter_by_desc() throws Exception {
        Book book = getObjectMapper().readValue(TestUtil.load("book_sample"), Book.class);
        repo.save(book);

        getMockMvc().perform(
                get("/api/bookshelf")
                        .param("description", "in Action"))
                .andExpect(status().isOk())
                .andDo(document("bookshelf-find-by-desc",
                        requestParameters(
                                parameterWithName("description").description("The book description term to filter.")
                        ),
                        responseFields(
                                fieldWithPath("bookshelf[]").description("The books collection."),
                                fieldWithPath("bookshelf[].isbn").description("The book isbn."),
                                fieldWithPath("bookshelf[].title").description("The book title."),
                                fieldWithPath("bookshelf[].description").description("The book description."),
                                fieldWithPath("bookshelf[].subtitle").description("The book subtitle."),
                                fieldWithPath("bookshelf[].authors[]").description("The book authors names."),
                                fieldWithPath("bookshelf[].published").description("The book published date."),
                                fieldWithPath("bookshelf[].publisher").description("The book publisher name."),
                                fieldWithPath("bookshelf[].pages").description("The book total pages number."),
                                fieldWithPath("bookshelf[].inStock").description("If the book is in stock.")
                        )
                ));
    }

    @Test
    public void should_retrieve_a_book_filter_by_title_and_desc() throws Exception {
        Book book = getObjectMapper().readValue(TestUtil.load("book_sample"), Book.class);
        repo.save(book);

        getMockMvc().perform(
                get("/api/bookshelf")
                        .param("title", "in Action")
                        .param("description", "in Action"))
                .andExpect(status().isOk())
                .andDo(document("bookshelf-find-by-title-and-desc",
                        requestParameters(
                                parameterWithName("title").description("The book title term to filter."),
                                parameterWithName("description").description("The book description term to filter.")
                        ),
                        responseFields(
                                fieldWithPath("bookshelf[]").description("The books collection."),
                                fieldWithPath("bookshelf[].isbn").description("The book isbn."),
                                fieldWithPath("bookshelf[].title").description("The book title."),
                                fieldWithPath("bookshelf[].description").description("The book description."),
                                fieldWithPath("bookshelf[].subtitle").description("The book subtitle."),
                                fieldWithPath("bookshelf[].authors[]").description("The book authors names."),
                                fieldWithPath("bookshelf[].published").description("The book published date."),
                                fieldWithPath("bookshelf[].publisher").description("The book publisher name."),
                                fieldWithPath("bookshelf[].pages").description("The book total pages number."),
                                fieldWithPath("bookshelf[].inStock").description("If the book is in stock.")
                        )
                ));
    }


    @Test
    public void should_save_a_book() throws Exception {
        getMockMvc().perform(
                post("/api/bookshelf")
                        .contentType(APPLICATION_JSON)
                        .content(TestUtil.load("book_sample")))
                .andExpect(status().isCreated())
                .andDo(document("book-save",
                        requestFields(
                                fieldWithPath(".isbn").description("The book isbn."),
                                fieldWithPath(".title").description("The book title."),
                                fieldWithPath(".description").description("The book description."),
                                fieldWithPath(".subtitle").description("The book subtitle."),
                                fieldWithPath(".authors[]").description("The book authors names."),
                                fieldWithPath(".published").description("The book published date."),
                                fieldWithPath(".publisher").description("The book publisher name."),
                                fieldWithPath(".pages").description("The book total pages number."),
                                fieldWithPath(".inStock").description("If the book is in stock.")
                        ))
                );
    }

    @Test
    public void should_update_a_book() throws Exception {
        Book book = getObjectMapper().readValue(TestUtil.load("book_sample"), Book.class);
        book.setTitle("");
        repo.save(book);

        getMockMvc().perform(
                put("/api/bookshelf/{isbn}", book.getIsbn())
                        .contentType(APPLICATION_JSON)
                        .content(TestUtil.load("book_sample")))
                .andExpect(status().isNoContent())
                .andDo(document("book-update",
                        pathParameters(
                                parameterWithName("isbn").description("The book isbn to update.")
                        ),
                        requestFields(
                                fieldWithPath(".isbn").description("The book isbn."),
                                fieldWithPath(".title").description("The book title."),
                                fieldWithPath(".description").description("The book description."),
                                fieldWithPath(".subtitle").description("The book subtitle."),
                                fieldWithPath(".authors[]").description("The book authors names."),
                                fieldWithPath(".published").description("The book published date."),
                                fieldWithPath(".publisher").description("The book publisher name."),
                                fieldWithPath(".pages").description("The book total pages number."),
                                fieldWithPath(".inStock").description("If the book is in stock.")
                        ))
                );

        assertThat(repo.findAll().get(0).getTitle(), equalTo("Java 8 in Action"));
    }

    @Test
    public void should_delete_a_book() throws Exception {
        Book book = getObjectMapper().readValue(TestUtil.load("book_sample"), Book.class);
        repo.save(book);

        getMockMvc().perform(delete("/api/bookshelf/{isbn}", book.getIsbn()))
                .andExpect(status().isNoContent())
                .andDo(document("book-update",
                        pathParameters(
                                parameterWithName("isbn").description("The book isbn to update.")
                        ))
                );

        assertThat(repo.findAll(), empty());
    }
}