package io.mshanobject.springbootdemo.model;

import lombok.Data;

@Data
public class ErrorMsg {
    private String errorCode;
    private String message;
    private String TechnicalMessage;
}
