package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportrdMathOperationException extends RuntimeException{
    @Serial
    private static final long serialVersionUID=1L;

    public UnsupportrdMathOperationException(String ex){
        super(ex);

    }




}
