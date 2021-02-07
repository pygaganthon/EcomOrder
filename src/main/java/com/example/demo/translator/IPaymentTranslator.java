package com.example.demo.translator;

import com.example.demo.entity.EntityPayment;
import com.example.demo.vo.PaymentVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPaymentTranslator
{
    PaymentVO toPaymentVO(EntityPayment entityPayment);

    EntityPayment toPaymentEntity(PaymentVO paymentVO);
}
