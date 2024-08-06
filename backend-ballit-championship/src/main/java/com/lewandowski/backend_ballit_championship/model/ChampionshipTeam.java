package com.lewandowski.backend_ballit_championship.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChampionshipTeam {
    @EmbeddedId
    private ChampionshipTeamId id;

    @Column
    private boolean status;

    @Column(name = "blots_total", nullable = true)
    private int blotsTotal;

    @Column(name = "plifs_total", nullable = true)
    private int plifsTotal;

    @Column(name = "advrunghs_total", nullable = true)
    private int advrunghsTotal;

    @Column(name = "points_total", nullable = true)
    private int pointsTotal;
}
