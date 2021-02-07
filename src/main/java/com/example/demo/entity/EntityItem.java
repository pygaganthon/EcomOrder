package com.example.demo.entity;

import com.example.demo.entity.compositeKey.OrderItemCompositeKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@ApiModel(description = "Class representing an item to order")
@Table(name = "Item")
public class EntityItem
{
//    @EmbeddedId
//    private OrderItemCompositeKey orderItemCompKey;
    @Id
    @ApiModelProperty("Item id is unique identifier of an item in Menu")
    @Column(name = "Item_Id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long item_id;

    @Column(name = "Item_Name")
    private String order_item_name;

    @Column(name = "Item_Qty")
    private int order_item_qty;

    @Column(name = "Item_Cost")
    private Double order_item_cost;
}
