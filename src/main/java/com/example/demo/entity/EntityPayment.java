package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@ApiModel(description = "Class representing Payment Info for an order")
@Table(name = "Payment")
public class EntityPayment
{

    @Id
    @ApiModelProperty("Payment Confirmation Number is unique identifier of every payment made")
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Payment_Conf_No")
    private Long payment_confirmation_number;

    @Column(name = "Order_Id")
    private Long orderId;

    @Column(name = "Payment_Time")
    private Date payment_time;

    @Column(name = "Payment_Revert_Time")
    private Date payment_revert_time;

    @ManyToOne
    @JoinColumn(name = "Order_Id", insertable = false, updatable = false)
    private EntityOrder entityOrder;

    @Column(name = "Billing_Addr_Id")
    private Long bill_address_id;

    @ManyToOne
    @JoinColumn(name = "Billing_Addr_Id", insertable = false, updatable = false)
    private EntityAddress billing_address;

    @Column(name = "Order_Payment_Method")
    private String order_payment_method;

    @Column(name = "Order_Payment_Date")
    private Date order_payment_date;

    @Column(name = "Order_Payment_Amount")
    private Double order_payment_amount;



    //    @Column(name = "Order_Payment_Confirmation_Number", nullable = false)
//    private String order_payment_confirmation_number;
}
