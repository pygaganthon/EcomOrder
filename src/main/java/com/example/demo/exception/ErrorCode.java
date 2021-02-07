package com.example.demo.exception;

public enum ErrorCode
{
    OK("OK", 200),
    ERROR("ERROR", 500),
    ORDER_BLANK("The Order returned is blank or null.", 1001),
    ORDER_NOT_CREATED("The Order couldnot be created.", 1002),
    PAYMENT_DECLINED("The Payment couldnot be made.", 1003),
    PAYMENT_DETAIL_INCORRECT("The payment details are incorrect", 1004);

    private final String description;
    private final int code;

    ErrorCode(final String description, final int code)
    {
        this.description = description;
        this.code = code;
    }

    public String getDescription()
    {
        return description;
    }

    public int getCode()
    {
        return this.code;
    }

}
