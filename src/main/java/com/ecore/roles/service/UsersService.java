package com.ecore.roles.service;

import com.ecore.roles.web.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UsersService {

    UserDto getUser(UUID id);

    List<UserDto> getUsers();
}
