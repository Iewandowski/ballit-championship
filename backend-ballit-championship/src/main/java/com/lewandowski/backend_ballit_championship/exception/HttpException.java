package com.lewandowski.backend_ballit_championship.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class HttpException extends RuntimeException {

    private final HttpStatus status;

    public HttpException(final String message, final HttpStatus httpStatus) {
        super(message);
        this.status = httpStatus;
    }

    public HttpException(final String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
