package com.lewandowski.backend_ballit_championship.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Championship {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "championship_id")
    private Long championshipId;

    @Column
    private LocalDateTime date;

    @Column
    private boolean status;
}
