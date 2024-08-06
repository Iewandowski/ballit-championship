package com.lewandowski.backend_ballit_championship.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lewandowski.backend_ballit_championship.dto.response.ChampionshipTeamResponse;
import com.lewandowski.backend_ballit_championship.model.ChampionshipTeam;

public interface ChampionshipTeamRepository extends JpaRepository<ChampionshipTeam, Long> {
    @Query("SELECT ct FROM ChampionshipTeam ct WHERE ct.id.teamId = :teamId AND ct.id.championshipId = :championshipId")
    ChampionshipTeam findByTeamAndChamp(Long teamId, Long championshipId);

    @Query("SELECT t.name, ct.blotsTotal, ct.plifsTotal, ct.advrunghsTotal, ct.pointsTotal "
        + "FROM ChampionshipTeam ct JOIN Team t ON ct.id.teamId = t.teamId WHERE ct.id.championshipId = :championshipId "
        + "ORDER BY ct.pointsTotal DESC")
    List<ChampionshipTeamResponse> ListByPoints(Long championshipId);

    @Query("SELECT t.battleCry FROM ChampionshipTeam ct JOIN Team t " 
        + "ON ct.id.teamId = t.teamId WHERE ct.id.championshipId = :championshipId "
        + "ORDER BY ct.pointsTotal DESC")
    String FindFirstByChampionshipId(Long championshipId);

    @Query("SELECT COUNT(ct) FROM ChampionshipTeam ct WHERE ct.id.championshipId = :championshipId AND ct.status = true")
    int countOpenTeams(Long championshipId);
}
