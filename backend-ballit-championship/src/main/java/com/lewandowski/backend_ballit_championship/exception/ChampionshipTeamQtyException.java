package com.lewandowski.backend_ballit_championship.exception;

import org.springframework.http.HttpStatus;

public class ChampionshipTeamQtyException extends HttpException {
    public ChampionshipTeamQtyException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}