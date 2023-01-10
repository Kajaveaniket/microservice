package com.epam.feignclient;

import com.epam.entity.BookEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "book-service")
public interface BookClient {

    @GetMapping("/book")
    public List<BookEntity> get();

    @GetMapping("/book/{id}")
    public BookEntity getById(@PathVariable int id);

    @PostMapping("/book")
    public String add(BookEntity book);
}
