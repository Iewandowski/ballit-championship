package com.lewandowski.backend_ballit_championship.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lewandowski.backend_ballit_championship.model.Phase;
import com.lewandowski.backend_ballit_championship.repository.PhaseRepository;
import com.lewandowski.backend_ballit_championship.service.IPhaseService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PhaseService implements IPhaseService {

    @Autowired
    private final PhaseRepository phaseRepository;

    public void createPhase(Long championship_id) {
        Phase phase = Phase.builder()
            .championshipId(championship_id)
            .status(true).build();
        phaseRepository.save(phase);
    }

    public void endPhase(Long championship_id) {
        //select where championship_id = this and status = on
        //Phase phase = phaseRepository.findBy...
        //phase.setStatus(false);
        //phaseRepository.save(phase);
    }
}
