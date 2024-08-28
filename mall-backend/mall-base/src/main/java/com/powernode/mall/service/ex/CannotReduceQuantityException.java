package com.powernode.mall.service.ex;

public class CannotReduceQuantityException extends ServiceException {
    public CannotReduceQuantityException(String message) {
        super(message);
    }

    public CannotReduceQuantityException(String message, Throwable cause) {
        super(message, cause);
    }

    public CannotReduceQuantityException(Throwable cause) {
        super(cause);
    }

    protected CannotReduceQuantityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CannotReduceQuantityException() {
        super();
    }
}
