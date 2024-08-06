package com.lewandowski.backend_ballit_championship.service.implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lewandowski.backend_ballit_championship.dto.request.TeamRequest;
import com.lewandowski.backend_ballit_championship.exception.ExistingTeamException;
import com.lewandowski.backend_ballit_championship.model.Team;
import com.lewandowski.backend_ballit_championship.repository.TeamRepository;
import com.lewandowski.backend_ballit_championship.service.ITeamService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TeamService implements ITeamService {
    private final TeamRepository teamRepository;


    @Override
    public Team createTeam(TeamRequest teamRequest) {
        Optional<Team> existingTeam = teamRepository.findByName(teamRequest.getName());

        if (existingTeam.isPresent()) {
            throw new ExistingTeamException();
        }

        Team newTeam = Team.builder()
            .name(teamRequest.getName())
            .battleCry(teamRequest.getBattle_cry())
            .foundationYear(teamRequest.getFoundation_year()).build();

            return teamRepository.save(newTeam);
    }
    
}
