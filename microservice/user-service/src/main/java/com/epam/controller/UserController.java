package com.epam.controller;

import com.epam.entity.UserDto;
import com.epam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> get(){
        return new ResponseEntity<>(userService.get(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getByUsername(@PathVariable String username){
        return new ResponseEntity<>(userService.getByUsername(username), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> save(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.add(userDto), HttpStatus.OK);
    }

}
