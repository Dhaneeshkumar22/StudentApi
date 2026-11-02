package com.dhaneesh.welcome.controller;

import com.dhaneesh.welcome.model.Books;
import com.dhaneesh.welcome.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping
public class BookController {

    private final Logger logger= LoggerFactory.getLogger(BookController.class);

    public BookService books;

    public BookController(BookService books){
        this.books=books;
    }

   @GetMapping("/getBooks")

    public List<Books> getAll(Books b)
   {
       return books.getBooks();
   }
}
