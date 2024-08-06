package com.lewandowski.backend_ballit_championship.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lewandowski.backend_ballit_championship.model.Match;
import com.lewandowski.backend_ballit_championship.repository.MatchRepository;
import com.lewandowski.backend_ballit_championship.service.IMatchService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MatchService implements IMatchService {

    @Autowired
    private final MatchRepository matchRepository;
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

    public void createMatch(Long championshipId, Long matchId, Long firstTeam, Long secondTeam) {
        Match match = Match.builder()
                        .championshipId(championshipId)
                        .matchId(matchId)
                        .firstTeam(firstTeam)
                        .secondTeam(secondTeam)
                        .status(true).build();
        matchRepository.save(match);
    }
}
