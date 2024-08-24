package com.powernode.mall.service.ex;

public class ProductDataIllegalException extends ServiceException {
    public ProductDataIllegalException() {
        super();
    }

    public ProductDataIllegalException(String message) {
        super(message);
    }

    public ProductDataIllegalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductDataIllegalException(Throwable cause) {
        super(cause);
    }

    protected ProductDataIllegalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
