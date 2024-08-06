package com.lewandowski.backend_ballit_championship.exception;

import org.springframework.http.HttpStatus;

public class ChampionshipNotFound extends HttpException {
    public ChampionshipNotFound() {
        super("Campeonato não encontrado", HttpStatus.NOT_FOUND);
    }
}