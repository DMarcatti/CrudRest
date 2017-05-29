package br.com.crud.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionHandlers extends BaseExceptionHandler {
    public ExceptionHandlers() {
        super(log);
        registerMapping(UserNotFoundException.class, "USER_NOT_FOUND", "User not found", HttpStatus.NOT_FOUND);
    }
}