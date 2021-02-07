package com.example.demo.vo;

import com.example.demo.entity.EntityAddress;
import com.example.demo.entity.EntityItem;
import lombok.Data;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.Date;
import java.util.List;

@Data
public class OrderVO
{
    private Long order_id;

    private Date order_placed_time;

    private Date order_cancel_time;

//    private EntityAddress order_shippingAddress;
//
//    private EntityAddress order_billingAddress;

    private String order_status;

    private Long order_customer_id;

    private List<ItemVO> itemVOList;

    private Double order_subtotal;

    private Double order_tax;

    private Double order_shipping_charges;

    private Double order_total;
}
