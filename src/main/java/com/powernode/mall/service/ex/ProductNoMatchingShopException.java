package com.powernode.mall.service.ex;

public class ProductNoMatchingShopException extends ServiceException {
    public ProductNoMatchingShopException() {
        super();
    }

    public ProductNoMatchingShopException(String message) {
        super(message);
    }

    public ProductNoMatchingShopException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNoMatchingShopException(Throwable cause) {
        super(cause);
    }

    protected ProductNoMatchingShopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
