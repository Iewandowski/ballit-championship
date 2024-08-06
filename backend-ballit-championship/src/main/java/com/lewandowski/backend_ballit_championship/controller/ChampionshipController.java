package com.lewandowski.backend_ballit_championship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lewandowski.backend_ballit_championship.service.IChampionshipService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/championship")
public class ChampionshipController {
    @Autowired
    private final IChampionshipService championshipService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> startChampionship(Long[] teams) {
        championshipService.startChampionship(teams);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
