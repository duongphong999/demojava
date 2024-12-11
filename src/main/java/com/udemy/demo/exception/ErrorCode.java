package com.udemy.demo.exception;

public enum ErrorCode {
    INVALID_KEY(1001, "Invalid key"),
    USER_EXISTED(1002, "user existed"),
    USERNAME_INVALID(1003, "userName must be at least 3 characters"),
    PASSWORD_INVALID(1004, "password must be at least 8 characters"),
    USERNAME_NOT_EXISTED(1005, "user not existed"),
    UNAUTHENTICATED(1006, "user not existed")
    ;
    
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;

    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

    
}
