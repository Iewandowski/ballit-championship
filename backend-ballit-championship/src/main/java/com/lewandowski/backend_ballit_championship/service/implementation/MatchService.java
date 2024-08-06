package com.lewandowski.backend_ballit_championship.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lewandowski.backend_ballit_championship.exception.MatchNotFound;
import com.lewandowski.backend_ballit_championship.model.Match;
import com.lewandowski.backend_ballit_championship.model.MatchId;
import com.lewandowski.backend_ballit_championship.repository.MatchRepository;
import com.lewandowski.backend_ballit_championship.service.IMatchService;
import com.lewandowski.backend_ballit_championship.service.IPhaseService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MatchService implements IMatchService {

    @Autowired
    private final MatchRepository matchRepository;

    @Autowired
    private final IPhaseService phaseService;

    private final Random random = new Random();

    public void randomizeTeamMatch(Long championshipId, Long matchId, Long[] teams) {
        List<Long> teamList = new ArrayList<>(List.of(teams));
        while (teamList.size() > 1) {
            Long firstTeam = removeRandomElement(teamList);
            Long secondTeam = removeRandomElement(teamList);
            createMatch(championshipId, matchId, firstTeam, secondTeam);
        }
    }

    private Long removeRandomElement(List<Long> list) {
        int index = random.nextInt(list.size());
        return list.remove(index);
    }

    public void createMatch(Long championshipId, Long phaseId, Long firstTeam, Long secondTeam) {
        Match match = Match.builder()
                        .championshipId(championshipId)
                        .phaseId(phaseId)
                        .firstTeam(firstTeam)
                        .secondTeam(secondTeam)
                        .status(true).build();
        matchRepository.save(match);
    }

    public void endMatch(Long championshipId, Long phaseId, Long matchId) {
        MatchId matchIdAux = new MatchId(championshipId, phaseId, matchId);
        Match match = matchRepository.findById(matchIdAux).orElseThrow(MatchNotFound::new);

        match.setStatus(false);
        checkPhaseEnd(championshipId, phaseId);
    }

    private void checkPhaseEnd(Long championshipId, Long phaseId) {
        List<Match> matches = matchRepository.ListOpenMatches(championshipId, phaseId);
        if (matches.isEmpty()) {
            phaseService.endPhase(championshipId, phaseId);
        }
    }
}
