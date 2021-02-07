package com.example.demo.entity.compositeKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@SuppressWarnings("serial")
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemCompositeKey implements Serializable
{
    @Column(name = "Order_Id", nullable = false)
    private long order_id;

    @Column(name = "Item_Id", nullable = false)
    private String item_id;
}
