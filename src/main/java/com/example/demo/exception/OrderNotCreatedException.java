package com.example.demo.exception;

public class OrderNotCreatedException extends AbstractExceptionWithDetails
{
        public OrderNotCreatedException(ErrorCode error, String... additionalInfo)
        {
            super(error, additionalInfo);
        }

        public OrderNotCreatedException(ErrorCode error, Throwable ex, String... additionalInfo)
        {
            super(error, ex, additionalInfo);
        }

}
