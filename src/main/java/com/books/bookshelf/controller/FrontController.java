package com.books.bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookshelf")
public class FrontController {

    @GetMapping
    public String home(){
        return "home";
    }
}
