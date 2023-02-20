package com.ecore.roles.web.rest;

import com.ecore.roles.service.MembershipsService;
import com.ecore.roles.web.MembershipsApi;
import com.ecore.roles.web.dto.MembershipDto;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/roles/memberships")
public class MembershipsRestController implements MembershipsApi {

    private final MembershipsService membershipsService;

    @Override
    @PostMapping(
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<MembershipDto> assignRoleToMembership(
            @NotNull @Valid @RequestBody MembershipDto membershipDto) {
        MembershipDto membershipResponseDto =
                membershipsService.assignRoleToMembership(membershipDto.toModel());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(membershipResponseDto);
    }

    @Override
    @GetMapping(
            path = "/search",
            produces = {"application/json"})
    public ResponseEntity<List<MembershipDto>> getMemberships(
            @RequestParam UUID roleId) {

        List<MembershipDto> memberships = membershipsService.getMemberships(roleId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberships);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<MembershipDto>> getAllMemberships() {
        List<MembershipDto> memberships = membershipsService.getAllMemberships();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberships);
    }

}
