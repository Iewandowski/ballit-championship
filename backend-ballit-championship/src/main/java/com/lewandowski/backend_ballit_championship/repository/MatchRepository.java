package com.lewandowski.backend_ballit_championship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lewandowski.backend_ballit_championship.model.Match;
import com.lewandowski.backend_ballit_championship.model.MatchId;

@Repository
public interface MatchRepository extends JpaRepository<Match, MatchId> {
    @Query("SELECT m FROM Match m WHERE m.championshipId = :championshipId AND m.phaseId = :phaseId AND m.status = true")
    List<Match> ListOpenMatches(Long championshipId, Long phaseId);
}
