package com.nsl.prac.common.exception.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class VertexRestExceptionResponse {
    private int statusCode;
    private String message;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd@HH:mm",
            locale = "Asian/Seoul",
            timezone = "Asian/Seoul"
    )
    private Date timestamp;
    
    @Builder
    public VertexRestExceptionResponse(int statusCode, String message, Date timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
    }
}
