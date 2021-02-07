package com.example.demo.kafka;

import com.example.demo.entity.EntityOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class KafkaProducerApp {
    private final KafkaTemplate<String, List<EntityOrder>> kfkatemp;

    public void sendToTopic(String topic, List<EntityOrder> orders) {
        kfkatemp.send(topic, orders);
    }
}
