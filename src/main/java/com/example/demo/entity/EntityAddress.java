package com.example.demo.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ApiModel(description = "Class representing general address , Shipping Address or Billing Address")
@Table(name = "Address")
public class EntityAddress
{
    @Id
    @ApiModelProperty("address Id is unique identifier of Address")
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Address_Id", nullable = false)
    private Long address_id;

    @Column(name = "Line_1", nullable = false)
    private String line1;

    @Column(name = "Line_2")
    private String line2;

    @Column(name = "ZipCode", nullable = false)
    private String zipCode;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "State", nullable = false)
    private String state;

    @Column(name = "Country", nullable = false)
    private String country;

//    @OneToMany(mappedBy = "order_shippingAddress", fetch = FetchType.LAZY)
//    private List<EntityOrder> orderEntities;
//
//    @OneToMany(mappedBy = "billing_address",fetch = FetchType.LAZY)
//    private List<EntityPayment> paymentEntities;
}
