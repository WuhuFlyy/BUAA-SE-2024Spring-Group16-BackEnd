package com.powernode.mall.service.ex;

public class VersionNotFoundException extends ServiceException {

    public VersionNotFoundException() {
        super();
    }

    public VersionNotFoundException(String message) {
        super(message);
    }

    public VersionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VersionNotFoundException(Throwable cause) {
        super(cause);
    }

    protected VersionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
