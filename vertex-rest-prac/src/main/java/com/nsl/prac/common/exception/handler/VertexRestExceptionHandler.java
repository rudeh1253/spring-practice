package com.nsl.prac.common.exception.handler;

import com.nsl.prac.common.exception.EntityNotFoundException;
import com.nsl.prac.common.exception.response.VertexRestExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class VertexRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<VertexRestExceptionResponse> handleEntityNotFoundException(EntityNotFoundException e) {
        VertexRestExceptionResponse response = VertexRestExceptionResponse.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
