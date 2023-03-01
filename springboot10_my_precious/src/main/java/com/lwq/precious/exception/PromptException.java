package com.lwq.precious.exception;

public class PromptException extends RuntimeException{

    private Integer errorCode;

    public PromptException(String message){
        super(message);
    }

    public PromptException(Integer errorCode,String message){
        super(message);
        this.errorCode=errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

}
