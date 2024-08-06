package com.lewandowski.backend_ballit_championship.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lewandowski.backend_ballit_championship.exception.PhaseNotFoundException;
import com.lewandowski.backend_ballit_championship.model.Phase;
import com.lewandowski.backend_ballit_championship.model.PhaseId;
import com.lewandowski.backend_ballit_championship.repository.PhaseRepository;
import com.lewandowski.backend_ballit_championship.service.IChampionshipService;
import com.lewandowski.backend_ballit_championship.service.IChampionshipTeamService;
import com.lewandowski.backend_ballit_championship.service.IPhaseService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PhaseService implements IPhaseService {

    @Autowired
    private final PhaseRepository phaseRepository;
    @Autowired
    private final IChampionshipTeamService championshipTeamService;
    @Autowired
    private final IChampionshipService championshipService;

    public Phase createPhase(Long championship_id) {
        Phase phase = Phase.builder()
            .championshipId(championship_id)
            .status(true).build();
        return phaseRepository.save(phase);
    }

    public void endPhase(Long championshipId, Long phaseId) {
        PhaseId phaseIdAux = new PhaseId(championshipId, phaseId);
        Phase phase = phaseRepository.findById(phaseIdAux).orElseThrow(PhaseNotFoundException::new);
        phase.setStatus(false);
        phaseRepository.save(phase);
    }

    public void checkChampionshipEnds(Long championshipId) {
        int teamsCount = championshipTeamService.countOpenTeams(championshipId);
        if (teamsCount == 1) {
            championshipService.endChampionship(championshipId);
        }
    }
}
