package com.ecore.roles.service;

import com.ecore.roles.model.Role;
import com.ecore.roles.web.dto.RoleDto;

import java.util.List;
import java.util.UUID;

public interface RolesService {

    RoleDto createRole(Role role);

    RoleDto getRole(UUID id);

    List<RoleDto> getRoles();

    List<RoleDto> getRolesByFilter(UUID userId, UUID teamId);

}
