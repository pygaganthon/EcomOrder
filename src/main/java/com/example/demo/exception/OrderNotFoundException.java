package com.example.demo.exception;

public class OrderNotFoundException extends AbstractExceptionWithDetails
{
    public OrderNotFoundException(ErrorCode error, String... additionalInfo)
    {
        super(error, additionalInfo);
    }

    public OrderNotFoundException(ErrorCode error, Throwable ex, String... additionalInfo)
    {
        super(error, ex, additionalInfo);
    }
}
