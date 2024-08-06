package com.lewandowski.backend_ballit_championship.service;

import java.util.List;

import com.lewandowski.backend_ballit_championship.dto.response.ChampionshipTeamResponse;

public interface IChampionshipTeamService {
    void AddTeam(Long championshipId, Long teamId);
    void teamLoss(Long teamId, Long championshipId);
    void registerPlifs(Long teamId, Long championshipId);
    void registerBlot(Long teamId, Long championshipId);
    void registerAdvrungh(Long teamId, Long championshipId);
    void registerGrusht(Long teamId, Long championshipId);
    List<ChampionshipTeamResponse> getTeamsByPoints(Long championshipId);
    String getWinnerBattleCry(Long championshipId);
    int countOpenTeams(Long championshipId);
} 
