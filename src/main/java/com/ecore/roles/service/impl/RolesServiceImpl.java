package com.ecore.roles.service.impl;

import com.ecore.roles.exception.ResourceExistsException;
import com.ecore.roles.exception.ResourceNotFoundException;
import com.ecore.roles.model.Role;
import com.ecore.roles.repository.RoleRepository;
import com.ecore.roles.service.MembershipsService;
import com.ecore.roles.service.RolesService;
import com.ecore.roles.web.dto.MembershipDto;
import com.ecore.roles.web.dto.RoleDto;

import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.ecore.roles.web.dto.RoleDto.fromModel;

@Service
public class RolesServiceImpl implements RolesService {

    public static final String DEFAULT_ROLE = "Developer";

    private final RoleRepository roleRepository;
    private final MembershipsService membershipsService;

    public RolesServiceImpl(
            RoleRepository roleRepository,
            MembershipsService membershipsService) {
        this.roleRepository = roleRepository;
        this.membershipsService = membershipsService;
    }

    @Override
    public RoleDto createRole(@NonNull Role role) {
        if (roleRepository.findByName(role.getName()).isPresent()) {
            throw new ResourceExistsException(Role.class);
        }
        return fromModel(roleRepository.save(role));
    }

    @Override
    public RoleDto getRole(@NonNull UUID roleId) {
        return fromModel(roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException(Role.class, roleId)));
    }

    @Override
    public List<RoleDto> getRoles() {
        return roleRepository.findAll()
                .stream()
                .map(RoleDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoleDto> getRolesByFilter(@NonNull UUID userId, @NonNull UUID teamId) {
        List<MembershipDto> allMemberships = membershipsService.getAllMemberships();

        return allMemberships.stream()
                .filter(x -> x.getUserId().equals(userId) || x.getTeamId().equals(teamId))
                .map(x -> roleRepository.getById(x.getRoleId()))
                .map(x -> fromModel(x))
                .collect(Collectors.toList());
    }
}
