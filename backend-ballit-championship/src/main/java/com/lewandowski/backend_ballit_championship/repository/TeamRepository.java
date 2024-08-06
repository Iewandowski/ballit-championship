package com.lewandowski.backend_ballit_championship.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lewandowski.backend_ballit_championship.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
    Optional<Team> findByName(String name);
}
