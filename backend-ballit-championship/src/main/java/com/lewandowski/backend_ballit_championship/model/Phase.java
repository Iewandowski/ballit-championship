package com.lewandowski.backend_ballit_championship.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@IdClass(PhaseId.class)
public class Phase {
    @Id
    @Column(name = "championship_id")
    private Long championshipId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "phase_id", insertable = false, updatable = false)
    private Long phaseId;

    @Column
    private boolean status;
}
