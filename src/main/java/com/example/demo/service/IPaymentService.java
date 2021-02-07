package com.example.demo.service;

import com.example.demo.entity.EntityPayment;
import com.example.demo.vo.PaymentVO;

public interface IPaymentService
{
    EntityPayment makePayment(EntityPayment entityPayment);
}
