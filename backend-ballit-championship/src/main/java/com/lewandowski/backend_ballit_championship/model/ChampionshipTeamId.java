package com.lewandowski.backend_ballit_championship.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class ChampionshipTeamId implements Serializable {
    @Column(name = "team_id")
    private Long teamId;
    @Column(name = "championship_id")
    private Long championshipId;
}
