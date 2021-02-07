package com.example.demo.vo;

import lombok.Data;


@Data
public class ItemVO
{
    private String item_id;

    private String order_item_name;

    private int order_item_qty;

    private Double order_item_cost;
}
