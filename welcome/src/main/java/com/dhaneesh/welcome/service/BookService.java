package com.dhaneesh.welcome.service;

import com.dhaneesh.welcome.model.Books;
import com.dhaneesh.welcome.repository.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepo book;

  //  public BookService(){}

    public BookService (BookRepo book)
    {
        this.book=book;
    }

    public List<Books> getBooks(){
        return book.findAll();
    }



}
