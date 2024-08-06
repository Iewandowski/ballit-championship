package com.lewandowski.backend_ballit_championship.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Entity
@IdClass(MatchId.class)
public class Match {
    @Id
    @Column(name = "championship_id")
    private Long championshipId;

    @Id
    @Column(name = "phase_id")
    private Long phaseId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "match_id")
    private Long matchId;

    @Column(name = "first_team")
    private Long firstTeam;

    @Column(name = "second_team")
    private Long secondTeam;

    @Column
    private boolean status;
}
