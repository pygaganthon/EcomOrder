package com.example.demo.service.impl;

import com.example.demo.Constants.OrderConstants;
import com.example.demo.dao.IOrderDAO;
import com.example.demo.dao.IPaymentDAO;
import com.example.demo.entity.EntityOrder;
import com.example.demo.entity.EntityPayment;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.exception.PaymentNotMadeException;
import com.example.demo.service.IPaymentService;
import com.example.demo.translator.IOrderTranslator;
import com.example.demo.translator.IPaymentTranslator;
import com.example.demo.vo.PaymentVO;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class PaymentServiceImpl implements IPaymentService
{
    private final IPaymentDAO iPaymentDAO;

    private final IOrderDAO iOrderDAO;

//    private final IPaymentTranslator iPaymentTranslator;

    private Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Override public EntityPayment makePayment(EntityPayment entityPayment)
    {
        List<EntityPayment> paymentEntities = iPaymentDAO.findAllByOrderId(entityPayment.getOrderId());


        if(paymentEntities != null && !paymentEntities.isEmpty()){
            Double alreadyPaid = paymentEntities.stream().map(EntityPayment::getOrder_payment_amount).reduce(0.0, Double::sum);
            Optional<EntityOrder> optionalOrder = iOrderDAO.findById(entityPayment.getOrderId());

            if(!optionalOrder.isPresent()){
                logger.error(ErrorCode.ORDER_BLANK.getDescription());
                throw new OrderNotFoundException(ErrorCode.ORDER_BLANK);
            }

            double total = alreadyPaid + entityPayment.getOrder_payment_amount();

            EntityOrder entityOrder = optionalOrder.get();
            if(total > entityOrder.getOrder_total()){
                logger.error(ErrorCode.PAYMENT_DETAIL_INCORRECT.getDescription());
                throw new PaymentNotMadeException(ErrorCode.PAYMENT_DETAIL_INCORRECT);
            }

            if(total == entityOrder.getOrder_total()){
                entityOrder.setOrder_status(OrderConstants.PAID.toString());
                iOrderDAO.save(entityOrder);
            }
        }
        entityPayment.setPayment_time(new Date());
        return iPaymentDAO.save(entityPayment);
    }
}




















