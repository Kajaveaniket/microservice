package com.epam.service;

import com.epam.dao.LibraryRepo;
import com.epam.entity.BookEntity;
import com.epam.entity.Library;
import com.epam.feignclient.BookClient;
import com.epam.resttemplate.UserClient;
import com.epam.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    @Autowired
    UserClient userClient;
    @Autowired
    BookClient bookClient;
    @Autowired
    LibraryRepo libraryRepo;

    
    public String register(UserDto userDto){
       return userClient.addUser(userDto);
    }
    
    public UserDto getUserByUsername(String username){
        return userClient.getUserByUsername(username);
    }
    
    public List<UserDto> getUsers(){
        return  userClient.getUsers();
    }
    
    public List<BookEntity> getBooks(){
        return bookClient.get();
    }
    
    public BookEntity getBookById(int id){
        return bookClient.getById(id);
    }
    
    public String addBook(BookEntity book){
        return bookClient.add(book);
    }

    public String createAssociation(String username, int id) {
        Optional<UserDto> userDto = Optional.ofNullable(userClient.getUserByUsername(username));
        userDto.orElseThrow(()->new RuntimeException("user is not present"));
        Library library = new Library(username,id);
        libraryRepo.save(library);
        return "Association created succesfully";
    }

    public List<String> getBooksFromAssociation(String username){
        List<Library> booksData = libraryRepo.findByUsername(username);
        List<Integer> collectBookId = booksData.stream().map(l -> l.getId()).collect(Collectors.toList());
        return collectBookId.stream().map(id -> bookClient.getById(id)).map(b->b.getName()).collect(Collectors.toList());

    }
}
