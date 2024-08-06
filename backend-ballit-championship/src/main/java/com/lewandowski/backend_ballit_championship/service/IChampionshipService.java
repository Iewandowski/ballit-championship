package com.lewandowski.backend_ballit_championship.service;

public interface IChampionshipService {
    public void startChampionship(Long[] teams);
    void endChampionship(Long championshipId);
}
