package com.nsl.prac.common;


import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
    private int statusCode;
    private String message;
    private Object data;

    @Builder
    public Response(int statusCode, String message, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public ResponseEntity<Response> ok(Object data) {
        Response response = new Response(HttpStatus.OK.value(), "Success", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
