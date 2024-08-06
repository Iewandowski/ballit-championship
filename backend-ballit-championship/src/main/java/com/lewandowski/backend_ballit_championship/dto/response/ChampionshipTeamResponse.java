package com.lewandowski.backend_ballit_championship.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChampionshipTeamResponse {
    private String name;
    private int blotsTotal;
    private int plifsTotal;
    private int advrunghsTotal;
    private int pointsTotal;

}
