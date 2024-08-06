package com.lewandowski.backend_ballit_championship.exception;

import org.springframework.http.HttpStatus;

public class TeamNotFound extends HttpException {
    public TeamNotFound() {
        super("Time não encontrado", HttpStatus.NOT_FOUND);
    }
}