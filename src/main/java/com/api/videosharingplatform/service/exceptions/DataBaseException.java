package com.api.videosharingplatform.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataBaseException extends RuntimeException{
    public DataBaseException (String msg) {
        super(msg);
    }
}
