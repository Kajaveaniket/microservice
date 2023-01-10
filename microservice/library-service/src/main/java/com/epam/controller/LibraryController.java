package com.epam.controller;

import com.epam.entity.BookEntity;
import com.epam.entity.UserDto;
import com.epam.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @PostMapping("user/register")
    public String register(@RequestBody UserDto userDto) {
        return libraryService.register(userDto);
    }

    @GetMapping("/user/{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        return libraryService.getUserByUsername(username);
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return libraryService.getUsers();
    }

    @GetMapping("/book")
    public List<BookEntity> getBooks() {
        return libraryService.getBooks();
    }

    @GetMapping("/book/{id}")
    public BookEntity getBookById(@PathVariable int id) {
        return libraryService.getBookById(id);
    }

    @PostMapping("/book")
    public String addBook(@RequestBody BookEntity book) {
        return libraryService.addBook(book);
    }

    @PostMapping("/association/{username}/{id}")
    public String createAssociation(@PathVariable String username,@PathVariable int id){
        return libraryService.createAssociation(username,id);
    }

    @GetMapping("/{username}")
    public List<String> getAssociatedBooks(@PathVariable String username){
        return libraryService.getBooksFromAssociation(username);
    }
}
