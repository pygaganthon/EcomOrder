package com.example.demo.service.impl;


import com.example.demo.Constants.OrderConstants;
import com.example.demo.dao.IOrderDAO;
import com.example.demo.entity.EntityAddress;
import com.example.demo.entity.EntityItem;
import com.example.demo.entity.EntityOrder;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.translator.IItemTranslator;
import com.example.demo.translator.IOrderTranslator;
import com.example.demo.vo.ItemVO;
import com.example.demo.vo.OrderVO;
import com.example.demo.service.IOrderService;
import lombok.AllArgsConstructor;
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
public class OrderServiceImpl implements IOrderService
{
    private final IOrderDAO iOrderDAO;

    private final IOrderTranslator iOrderTranslator;
    private final IItemTranslator iItemTranslator;

    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);



    public OrderVO getOrderById(Long orderId)
    {
        Optional<EntityOrder> entityOrder = iOrderDAO.findById(orderId);
        if(entityOrder.isPresent()) {
            OrderVO orderVO = iOrderTranslator.toOrderVO(entityOrder.get());
            orderVO.setItemVOList(iItemTranslator.toItemVOList(entityOrder.get().getEntityItemList()));
            return orderVO;
        }
        else {
            logger.error("Order was not found for the Id ");
            throw new OrderNotFoundException(ErrorCode.ORDER_BLANK, orderId.toString());
        }
    }


    @Override public EntityOrder placeOrder(EntityOrder entityOrder)
    {


        entityOrder.setOrder_subtotal(getSubTotal(entityOrder));
        entityOrder.setOrder_total(getTotal(entityOrder));
        entityOrder.setOrder_placed_time(new Date());
        entityOrder.setOrder_status(OrderConstants.CREATED.toString());

        EntityOrder orderEntityResponse = iOrderDAO.save(entityOrder);
        logger.info("Order created , order Id : " + orderEntityResponse.getOrder_id());
        return orderEntityResponse;
    }

    private Double getTotal(EntityOrder entityOrder)
    {
        Double itemcost = getSubTotal(entityOrder);
        Double tax = entityOrder.getOrder_tax();
        Double shippingcharges = entityOrder.getOrder_shipping_charges();
        return itemcost+tax+shippingcharges;
    }

    private Double getSubTotal(EntityOrder entityOrder)
    {
        Double tot = 0.0;
        for(EntityItem item : entityOrder.getEntityItemList())
        {
            tot += item.getOrder_item_cost()*item.getOrder_item_qty();
        }

        return tot;
    }

    @Override public EntityOrder cancelOrderById(Long orderId)
    {
        Optional<EntityOrder> entityOrderResponse = iOrderDAO.findById(orderId);
        if(entityOrderResponse.isPresent()){
            EntityOrder entityOrder = entityOrderResponse.get();
            entityOrder.setOrder_status(OrderConstants.CANCELLED.toString());
            entityOrder.setOrder_cancel_time(new Date());
            return iOrderDAO.save(entityOrder);
        } else{
            logger.error("Order was not found for the Id ");
            throw new OrderNotFoundException(ErrorCode.ORDER_BLANK, orderId.toString());
        }
    }

    @Override
    public void createOrders(List<EntityOrder> orders) {
        for(EntityOrder order: orders){
            placeOrder(order);
        }
    }
}

