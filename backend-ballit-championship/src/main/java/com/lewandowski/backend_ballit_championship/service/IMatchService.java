package com.lewandowski.backend_ballit_championship.service;

public interface IMatchService {
    void randomizeTeamMatch(Long championshipId, Long matchId, Long[] teams);
    void createMatch(Long championshipId, Long phaseId, Long firstTeam, Long secondTeam);
    void endMatch(Long championshipId, Long phaseId, Long matchId);
}
