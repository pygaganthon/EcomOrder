package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ApiModel(description = "Class representing general an order placed")
@Table(name = "OrderForUser")
public class EntityOrder
{



    @Id
    @ApiModelProperty("Order id is unique identifier of an Order")
    @Column(name = "Order_Id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long order_id;

    @Column(name = "OrderPlaced_Time")
    private Date order_placed_time;

    @Column(name = "OrderCancel_Time")
    private Date order_cancel_time;

    @Column(name = "Shipping_Addr_Id")
    private Long ship_address_id;

    @ManyToOne
    @JoinColumn(name = "Shipping_Addr_Id", nullable = false, insertable = false, updatable = false)
    private EntityAddress order_shippingAddress;

//    @Column(name = "Billing_Addr_Id", nullable = false)
//    private Long bill_address_id;
//
//    @ManyToOne
//    @JoinColumn(name = "Billing_Addr_Id", insertable = false, updatable = false)
//    private EntityAddress order_billingAddress;

    @Column(name = "Order_Status")
    private String order_status;

    @Column(name = "Order_Customer_Id")
    private Long order_customer_id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Order_Id")
    private List<EntityItem> entityItemList;

//    @Column(name = "Order_Item_Name", nullable = false)
//    private String order_item_name;
//
//    @Column(name = "Order_Item_Qty", nullable = false)
//    private int order_item_qty;

    @Column(name = "Order_SubTotal")
    private Double order_subtotal;

    @Column(name = "Order_Tax")
    private Double order_tax;

    @Column(name = "Order_Shipp_Charges")
    private Double order_shipping_charges;

    @Column(name = "Order_Total")
    private Double order_total;


//    @Column(name = "Order_Payment_Method", nullable = false)
//    private String order_payment_method;
//
//    @Column(name = "Order_Payment_Date", nullable = false)
//    private Date order_payment_date;
//
//    @Column(name = "Order_Payment_Confirmation_Number", nullable = false)
//    private String order_payment_confirmation_number;

}
