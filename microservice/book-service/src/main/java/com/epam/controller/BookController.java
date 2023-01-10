package com.epam.controller;

import com.epam.entity.Book;
import com.epam.entity.BookEntity;
import com.epam.serice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
    @GetMapping
    public ResponseEntity<List<BookEntity>> get(){
        return new ResponseEntity<List<BookEntity>>(bookService.get(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getById(@PathVariable int id){
        return new ResponseEntity<BookEntity>(bookService.getById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> add(@RequestBody BookEntity book){
        return new ResponseEntity<>(bookService.add(book),HttpStatus.CREATED);
    }


}
