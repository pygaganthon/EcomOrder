package com.example.demo.exception;

public class PaymentNotMadeException extends AbstractExceptionWithDetails
{
    public PaymentNotMadeException(ErrorCode error, String... additionalInfo)
    {
        super(error, additionalInfo);
    }

    public PaymentNotMadeException(ErrorCode error, Throwable ex, String... additionalInfo)
    {
        super(error, ex, additionalInfo);
    }
}
