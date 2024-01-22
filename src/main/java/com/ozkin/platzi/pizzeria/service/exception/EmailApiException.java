package com.ozkin.platzi.pizzeria.service.exception;

public class EmailApiException extends RuntimeException{
    public EmailApiException(){
        super("error sending email");
    }
}
