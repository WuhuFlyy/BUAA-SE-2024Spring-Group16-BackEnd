package com.powernode.mall.service.ex;

public class ShopNotFoundException extends ServiceException
{
    private static final long serialVersionUID = 1L;

    public ShopNotFoundException()
    {
        super();
    }

    public ShopNotFoundException(String message)
    {
        super(message);
    }

    public ShopNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ShopNotFoundException(Throwable cause)
    {
        super(cause);
    }
}
