package com.ecore.roles.web.dto;

import com.ecore.roles.client.model.Team;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class TeamDto {

    @JsonProperty
    private UUID id;

    @JsonProperty
    private String name;

    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID teamLeadId;

    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<UUID> teamMemberIds;

    public static TeamDto fromModel(Team team) {
        if (team == null) {
            return null;
        }
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .teamLeadId(team.getTeamLeadId())
                .teamMemberIds(team.getTeamMemberIds())
                .build();
    }
}
