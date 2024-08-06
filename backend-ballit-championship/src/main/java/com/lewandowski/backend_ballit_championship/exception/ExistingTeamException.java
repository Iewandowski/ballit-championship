package com.lewandowski.backend_ballit_championship.exception;

import org.springframework.http.HttpStatus;

public class ExistingTeamException extends HttpException {
    public ExistingTeamException() {
        super("Nome de equipe já existente", HttpStatus.BAD_REQUEST);
    }
}

