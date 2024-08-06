package com.lewandowski.backend_ballit_championship.service.implementation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lewandowski.backend_ballit_championship.exception.ChampionshipNotFound;
import com.lewandowski.backend_ballit_championship.exception.ChampionshipTeamQtyException;
import com.lewandowski.backend_ballit_championship.exception.TeamNotFound;
import com.lewandowski.backend_ballit_championship.model.Championship;
import com.lewandowski.backend_ballit_championship.model.Phase;
import com.lewandowski.backend_ballit_championship.repository.ChampionshipRepository;
import com.lewandowski.backend_ballit_championship.repository.TeamRepository;
import com.lewandowski.backend_ballit_championship.service.IChampionshipService;
import com.lewandowski.backend_ballit_championship.service.IChampionshipTeamService;
import com.lewandowski.backend_ballit_championship.service.IMatchService;
import com.lewandowski.backend_ballit_championship.service.IPhaseService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ChampionshipService implements IChampionshipService{

    @Autowired
    private final ChampionshipRepository championshipRepository;
    @Autowired
    private final TeamRepository teamRepository;
    @Autowired
    private final IChampionshipTeamService championshipTeamService;
    @Autowired
    private final IPhaseService phaseService;
    @Autowired
    private final IMatchService matchService;

    @Override
    public void startChampionship(Long[] teams) {
        if (teams.length < 8) {
            throw new ChampionshipTeamQtyException("devem haver mais de 7 equipes participantes");
        }
        if (teams.length > 16) {
            throw new ChampionshipTeamQtyException("devem haver menos de 16 equipes participantes");
        }
        if (teams.length % 2 != 0) {
            throw new ChampionshipTeamQtyException("deve haver um número par de participantes");
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        Championship championship = Championship.builder()
        .date(currentDateTime)
        .status(true).build();

        for (Long team : teams) {
            teamRepository.findById(team).orElseThrow(TeamNotFound::new);
            championshipTeamService.AddTeam(championship.getChampionshipId(), team);
        }

        Phase phase = phaseService.createPhase(championship.getChampionshipId());

        matchService.randomizeTeamMatch(championship.getChampionshipId(), phase.getPhaseId(), teams);

        championshipRepository.save(championship);
    }

    public void endChampionship(Long championshipId) {
        Championship championship = championshipRepository.findById(championshipId).orElseThrow(ChampionshipNotFound::new);
        championship.setStatus(false);
        championshipRepository.save(championship);
    }
}
