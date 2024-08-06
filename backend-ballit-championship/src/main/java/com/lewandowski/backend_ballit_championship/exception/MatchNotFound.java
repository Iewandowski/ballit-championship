package com.lewandowski.backend_ballit_championship.exception;

import org.springframework.http.HttpStatus;

public class MatchNotFound extends HttpException {
    public MatchNotFound() {
        super("Partida não encontrada", HttpStatus.NOT_FOUND);
    }
}