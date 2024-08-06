package com.lewandowski.backend_ballit_championship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lewandowski.backend_ballit_championship.dto.response.ChampionshipTeamResponse;
import com.lewandowski.backend_ballit_championship.service.IChampionshipTeamService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/championship-team")
public class ChampionshipTeamController {
    @Autowired
    private final IChampionshipTeamService championshipTeamService;

    @PutMapping("team-loss")
    public ResponseEntity<?> teamLoss(Long teamId, Long championshipId) {
        championshipTeamService.teamLoss(teamId, championshipId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("plifs")
    public ResponseEntity<?> registerPlifs(Long teamId, Long championshipId) {
        championshipTeamService.registerPlifs(teamId, championshipId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("blot")
    public ResponseEntity<?> registerBlot(Long teamId, Long championshipId) {
        championshipTeamService.registerBlot(teamId, championshipId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("advrungh")
    public ResponseEntity<?> registerAdvrungh(Long teamId, Long championshipId) {
        championshipTeamService.registerAdvrungh(teamId, championshipId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("grusht")
    public ResponseEntity<?> registerGrusht(Long teamId, Long championshipId) {
        championshipTeamService.registerGrusht(teamId, championshipId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("championship-result")
    public List<ChampionshipTeamResponse> getTeamsByPoints(Long championshipId) {
        return championshipTeamService.getTeamsByPoints(championshipId);
    }

    @GetMapping("battle-cry")
    public String getWinnerBattleCry(Long championshipId) {
        return championshipTeamService.getWinnerBattleCry(championshipId);
    }
}
