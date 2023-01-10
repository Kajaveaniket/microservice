package com.epam.service;

import com.epam.dao.UserRepo;
import com.epam.entity.User;
import com.epam.entity.UserDto;
import com.epam.exception.UserException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;

    public List<UserDto> get() {
        Optional<List<User>> optionalUsers = Optional.ofNullable(userRepo.findAll());
        List<User> users = optionalUsers.orElseThrow(() -> new UserException("user is empty"));
        return users.stream().map(u -> modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
    }

    public UserDto getByUsername(String username) {
        Optional<User> optionalUser = Optional.ofNullable(userRepo.findByUsername(username));
        User user = optionalUser.orElseThrow(()->new UserException(username+" is not present"));
        return modelMapper.map(userRepo.findByUsername(username), UserDto.class);
    }

    public String add(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        Optional<User> optionalUser=Optional.ofNullable(userRepo.save(user));
        optionalUser.orElseThrow(()->new UserException("user is not added"));
        return "user added succesfully";
    }
}
