package com.powernode.mall.service.ex;

public class ShopInfoNotCompleteException extends ServiceException
{
    private static final long serialVersionUID = 1L;

    public ShopInfoNotCompleteException()
    {
        super();
    }

    public ShopInfoNotCompleteException(String message)
    {
        super(message);
    }

    public ShopInfoNotCompleteException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ShopInfoNotCompleteException(Throwable cause)
    {
        super(cause);
    }
}
