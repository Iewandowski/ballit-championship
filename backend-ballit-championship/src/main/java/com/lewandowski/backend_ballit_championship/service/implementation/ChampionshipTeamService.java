package com.lewandowski.backend_ballit_championship.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lewandowski.backend_ballit_championship.dto.response.ChampionshipTeamResponse;
import com.lewandowski.backend_ballit_championship.model.ChampionshipTeam;
import com.lewandowski.backend_ballit_championship.model.ChampionshipTeamId;
import com.lewandowski.backend_ballit_championship.repository.ChampionshipTeamRepository;
import com.lewandowski.backend_ballit_championship.service.IChampionshipTeamService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ChampionshipTeamService implements IChampionshipTeamService {

    @Autowired
    private ChampionshipTeamRepository championshipTeamRepository;
    @Override
    public void AddTeam(Long championshipId, Long teamId) {
        ChampionshipTeamId championshipTeamId = new ChampionshipTeamId(teamId, championshipId);
        ChampionshipTeam championshipTeam = ChampionshipTeam.builder()
            .id(championshipTeamId)
            .status(true)
            .plifsTotal(0)
            .blotsTotal(0)
            .advrunghsTotal(0)
            .pointsTotal(0).build();
        championshipTeamRepository.save(championshipTeam);
    }

    public void teamLoss(Long teamId, Long championshipId) {
        ChampionshipTeam team = championshipTeamRepository.findByTeamAndChamp(teamId, championshipId);
        team.setStatus(false);
        championshipTeamRepository.save(team);
    }

    public void registerPlifs(Long teamId, Long championshipId) {
        ChampionshipTeam team = championshipTeamRepository.findByTeamAndChamp(teamId, championshipId);
        int plifsCount = team.getPlifsTotal() + 1;
        team.setPlifsTotal(plifsCount);
        championshipTeamRepository.save(team);
        updateTotalScore(team);
    }
    
    public void registerBlot(Long teamId, Long championshipId) {
        ChampionshipTeam team = championshipTeamRepository.findByTeamAndChamp(teamId, championshipId);
        int blotsCount = team.getBlotsTotal() + 5;
        team.setBlotsTotal(blotsCount);
        championshipTeamRepository.save(team);
        updateTotalScore(team);
    }

    public void registerAdvrungh(Long teamId, Long championshipId) {
        ChampionshipTeam team = championshipTeamRepository.findByTeamAndChamp(teamId, championshipId);
        int advrunghsCount = team.getAdvrunghsTotal() - 10;
        team.setAdvrunghsTotal(advrunghsCount);
        championshipTeamRepository.save(team);
        updateTotalScore(team);
    }

    private void updateTotalScore(ChampionshipTeam team) {
        int totalScore = team.getBlotsTotal() + team.getPlifsTotal() + team.getAdvrunghsTotal();
        team.setPointsTotal(totalScore);
        championshipTeamRepository.save(team);
    }

    public void registerGrusht(Long teamId, Long championshipId) {
        ChampionshipTeam team = championshipTeamRepository.findByTeamAndChamp(teamId, championshipId);
        int grusht = team.getAdvrunghsTotal() + 3;
        team.setPointsTotal(grusht);
        championshipTeamRepository.save(team);
    }

    public List<ChampionshipTeamResponse> getTeamsByPoints(Long championshipId) {
        return championshipTeamRepository.ListByPoints(championshipId);
    }

    public String getWinnerBattleCry(Long championshipId) {
        return championshipTeamRepository.FindFirstByChampionshipId(championshipId);
    }
}
