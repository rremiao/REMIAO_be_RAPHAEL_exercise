package com.ecore.roles.service.impl;

import com.ecore.roles.client.UsersClient;
import com.ecore.roles.service.UsersService;
import com.ecore.roles.web.dto.UserDto;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import static com.ecore.roles.web.dto.UserDto.fromModel;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersClient usersClient;

    public UsersServiceImpl(UsersClient usersClient) {
        this.usersClient = usersClient;
    }

    public UserDto getUser(UUID id) {
        return fromModel(usersClient.getUser(id).getBody());
    }

    public List<UserDto> getUsers() {
        return usersClient.getUsers()
                .getBody()
                .stream()
                .map(UserDto::fromModel)
                .collect(Collectors.toList());
    }
}
