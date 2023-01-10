package com.epam.serice;

import com.epam.dao.BookRepo;
import com.epam.entity.Book;
import com.epam.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;
    @Autowired
    ModelMapper modelMapper;

    public List<BookEntity> get() {
        List<Book> books = bookRepo.findAll();
        List<BookEntity> bookEntities = books.stream().map(b -> modelMapper.map(b, BookEntity.class)).collect(Collectors.toList());
        return bookEntities;
    }

    public BookEntity getById(int id) {
        Book book = bookRepo.findById(id);
        return modelMapper.map(book, BookEntity.class);
    }

    public String add(BookEntity bookEntity) {
        Book book = modelMapper.map(bookEntity, Book.class);
        bookRepo.save(book);
        return "Book added sucessfully";
    }
}
