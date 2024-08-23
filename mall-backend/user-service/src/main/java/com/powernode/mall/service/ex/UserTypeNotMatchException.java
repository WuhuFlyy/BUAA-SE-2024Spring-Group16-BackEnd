package com.powernode.mall.service.ex;

public class UserTypeNotMatchException extends ServiceException {
    public UserTypeNotMatchException() {
        super();
    }

    public UserTypeNotMatchException(String message) {
        super(message);
    }

    public UserTypeNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserTypeNotMatchException(Throwable cause) {
        super(cause);
    }

    protected UserTypeNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
