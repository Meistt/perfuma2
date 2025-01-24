package com.perfuma2.interfaces.rest;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class RestResponse {
    private HttpStatus statusCode;
    private String message;

    public RestResponse(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public RestResponse() {
    }
}
