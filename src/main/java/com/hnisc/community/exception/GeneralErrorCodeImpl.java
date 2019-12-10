package com.hnisc.community.exception;

/**
 * @author lh141
 */
public enum GeneralErrorCodeImpl implements GeneralErrorCode {

    POST_NOT_FOUND("问题不存在或已被删除~~~");

    private String message;

    GeneralErrorCodeImpl(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
