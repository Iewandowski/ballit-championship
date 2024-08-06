package com.lewandowski.backend_ballit_championship.service;

import com.lewandowski.backend_ballit_championship.model.Phase;

public interface IPhaseService {
    Phase createPhase(Long championship_id);
    void endPhase(Long championshipId, Long phaseId);
}
