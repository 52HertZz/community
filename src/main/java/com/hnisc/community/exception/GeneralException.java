package com.hnisc.community.exception;

/**
 * @author lh141
 * 通用异常
 */
public class GeneralException extends RuntimeException {
    private String message;

    public GeneralException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public GeneralException(GeneralErrorCode generalErrorCode) {
        this.message = generalErrorCode.getMessage();
    }
}
