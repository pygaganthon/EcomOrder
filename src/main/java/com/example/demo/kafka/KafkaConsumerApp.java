package com.example.demo.kafka;

import com.example.demo.entity.EntityOrder;
import com.example.demo.service.IOrderService;
import lombok.Data;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class KafkaConsumerApp {
    private final IOrderService iOrderService;

    @KafkaListener(topics = "order-test", containerFactory = "orderKafkaListenerFactory")
    public void consumeJson(List<EntityOrder> orders){

        iOrderService.createOrders(orders);
    }
}
