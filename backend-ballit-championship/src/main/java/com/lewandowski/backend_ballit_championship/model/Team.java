package com.lewandowski.backend_ballit_championship.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Team {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long team_id;

    @Column
    private String name;

    @Column
    private String battle_cry;

    @Column
    private Date foundation_year;
}
