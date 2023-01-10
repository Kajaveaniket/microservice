package com.epam.feignclient;

import com.epam.entity.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/user")
    public List<UserDto> get();

    @GetMapping("/user/{username}")
    public  UserDto getByUsername(@PathVariable String username);

    @PostMapping("/user")
    public String save(UserDto userDto);
}
