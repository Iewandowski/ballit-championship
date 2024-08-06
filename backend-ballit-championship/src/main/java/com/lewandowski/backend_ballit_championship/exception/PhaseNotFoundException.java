package com.lewandowski.backend_ballit_championship.exception;

import org.springframework.http.HttpStatus;

public class PhaseNotFoundException extends HttpException {
    public PhaseNotFoundException() {
        super("Fase não encontrada", HttpStatus.NOT_FOUND);
    }
}