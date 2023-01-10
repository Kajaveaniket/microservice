package com.epam.resttemplate;

import com.epam.entity.BookEntity;
import com.epam.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserClient {
    @Autowired
    RestTemplate restTemplate;

    public List<UserDto> getUsers() {
        return restTemplate.getForObject("http://localhost:8081/user",List.class);
    }
    public UserDto getUserByUsername(String username) {
        return restTemplate.getForObject("http://localhost:8081/user/" + username,UserDto.class);
    }

    public String addUser(UserDto userDto) {
        return restTemplate.postForObject("http://localhost:8081/user",userDto,String.class);
    }
}
