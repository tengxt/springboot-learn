package com.tengxt.propertiesspringboot.Controller;

import com.tengxt.propertiesspringboot.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private Book book;

    @GetMapping("/bookAll")
    public String books(){
        return book.getId() + book.getName() + book.getAuthor();
    }
}
