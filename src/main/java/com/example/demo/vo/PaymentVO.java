package com.example.demo.vo;

import com.example.demo.entity.EntityAddress;
import com.example.demo.entity.EntityOrder;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentVO
{
    private Long payment_confirmation_number;

    private Long order_id;

    private Date payment_time;

    private Date payment_revert_time;

    private EntityOrder orderEntity;

    private Long bill_address_id;

    private EntityAddress billing_address;

    private String order_payment_method;

    private Date order_payment_date;

    private Double payment_amount;


}
