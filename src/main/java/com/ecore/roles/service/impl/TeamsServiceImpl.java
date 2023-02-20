package com.ecore.roles.service.impl;

import com.ecore.roles.client.TeamsClient;
import com.ecore.roles.client.model.Team;
import com.ecore.roles.service.TeamsService;
import com.ecore.roles.web.dto.TeamDto;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TeamsServiceImpl implements TeamsService {

    private final TeamsClient teamsClient;

    public TeamsServiceImpl(TeamsClient teamsClient) {
        this.teamsClient = teamsClient;
    }

    public Team getTeam(UUID id) {
        return teamsClient.getTeam(id).getBody();
    }

    public List<TeamDto> getTeams() {
        return teamsClient.getTeams()
                .getBody()
                .stream()
                .map(TeamDto::fromModel)
                .collect(Collectors.toList());
    }
}
