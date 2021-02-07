package com.example.demo.service;

import com.example.demo.entity.EntityOrder;
import com.example.demo.vo.OrderVO;

import java.util.List;

public interface IOrderService
{
    OrderVO getOrderById(Long orderId);

    EntityOrder placeOrder(EntityOrder entityOrder);

    EntityOrder cancelOrderById(Long orderId);

    void createOrders(List<EntityOrder> orders);
}
