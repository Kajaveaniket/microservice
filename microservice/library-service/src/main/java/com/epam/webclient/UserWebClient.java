package com.epam.webclient;

import com.epam.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class UserWebClient {

    @Autowired
    WebClient webClient;


    public List<UserDto> getUsers() {
        return webClient.get().uri("http://localhost:8081/user").retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<UserDto>>() {
                })
                .block();
    }

    public UserDto getUserByUsername(String username) {
        return webClient.get().uri("http://localhost:8081/user/" + username).retrieve()
                .bodyToMono(UserDto.class).block();
    }

    public String addUser(UserDto userDto) {
        return webClient.post().uri("http://localhost:8081/user")
                .bodyValue(userDto).retrieve()
                .bodyToMono(String.class).block();
    }
}
