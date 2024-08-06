package com.lewandowski.backend_ballit_championship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lewandowski.backend_ballit_championship.dto.request.TeamRequest;
import com.lewandowski.backend_ballit_championship.service.ITeamService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    private ITeamService teamService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(@Valid @RequestBody TeamRequest teamRequest) {
        teamService.createTeam(teamRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
