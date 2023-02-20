package com.ecore.roles.service;

import com.ecore.roles.exception.ResourceNotFoundException;
import com.ecore.roles.model.Membership;
import com.ecore.roles.web.dto.MembershipDto;

import java.util.List;
import java.util.UUID;

public interface MembershipsService {

    MembershipDto assignRoleToMembership(Membership membership) throws ResourceNotFoundException;

    List<MembershipDto> getMemberships(UUID roleId);

    List<MembershipDto> getAllMemberships();
}
