package com.example.demo.Constants;

public enum OrderConstants
{
    READY("READY"),
    PREPARING("PREPARING"),
    CREATED("CREATED"),
    CANCELLED("CANCELLED"),
    PAID("PAID");

    private final String orderCode;

    OrderConstants(final String orderCode)
    {
        this.orderCode = orderCode;
    }
}
