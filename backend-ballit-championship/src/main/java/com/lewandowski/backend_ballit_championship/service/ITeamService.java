package com.lewandowski.backend_ballit_championship.service;

import com.lewandowski.backend_ballit_championship.dto.request.TeamRequest;
import com.lewandowski.backend_ballit_championship.model.Team;

public interface ITeamService {
    Team createTeam(TeamRequest teamRequest);
}