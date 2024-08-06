package com.lewandowski.backend_ballit_championship.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatchId implements Serializable {
    private Long championshipId;
    private Long phaseId;
    private Long matchId;
}
