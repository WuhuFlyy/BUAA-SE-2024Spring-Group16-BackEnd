package com.powernode.mall.service.ex;

public class ShopDuplicateException extends ServiceException
{
    public ShopDuplicateException()
    {
        super();
    }

    public ShopDuplicateException(String message)
    {
        super(message);
    }

    public ShopDuplicateException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ShopDuplicateException(Throwable cause)
    {
        super(cause);
    }

    protected ShopDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
