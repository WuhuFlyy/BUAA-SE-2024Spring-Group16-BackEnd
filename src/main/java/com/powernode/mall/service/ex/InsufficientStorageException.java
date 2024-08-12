package com.powernode.mall.service.ex;

public class InsufficientStorageException extends ServiceException {
    public InsufficientStorageException() {
        super();
    }

    public InsufficientStorageException(String message) {
        super(message);
    }

    public InsufficientStorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientStorageException(Throwable cause) {
        super(cause);
    }

    protected InsufficientStorageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
