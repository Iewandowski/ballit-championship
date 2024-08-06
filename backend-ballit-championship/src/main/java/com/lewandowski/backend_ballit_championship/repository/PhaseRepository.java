package com.lewandowski.backend_ballit_championship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lewandowski.backend_ballit_championship.model.Phase;
import com.lewandowski.backend_ballit_championship.model.PhaseId;

@Repository
public interface PhaseRepository extends JpaRepository<Phase, PhaseId> {
    
}
