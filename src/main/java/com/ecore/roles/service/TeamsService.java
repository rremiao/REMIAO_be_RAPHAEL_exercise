package com.ecore.roles.service;

import com.ecore.roles.client.model.Team;
import com.ecore.roles.web.dto.TeamDto;

import java.util.List;
import java.util.UUID;

public interface TeamsService {

    Team getTeam(UUID id);

    List<TeamDto> getTeams();
}
