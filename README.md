# EcomOrder
- Placing bulk orders using Kafka Producer Subscriber.
- Containerized service using docker.
- Made blueprints of APIs using Swagger.
- Proper ErrorCodes and Exceptions Defined.
- PostGreSql as DB   


#Orders 
[
  {
    "entityItemList": [
      {
        "order_item_cost": 12,
        "order_item_name": "Pulaw",
        "order_item_qty": 2
      },
      {
        "order_item_cost": 7.5,
        "order_item_name": "Faluda",
        "order_item_qty": 2
      }
    ],
    "order_customer_id": 1,
    "order_shipping_charges": 2.3,
    "order_tax": 1.5,
    "ship_address_id": 1
  },
    {
    "entityItemList": [
      {
        "order_item_cost": 6,
        "order_item_name": "Dosa",
        "order_item_qty": 2
      },
      {
        "order_item_cost": 9.5,
        "order_item_name": "Idli",
        "order_item_qty": 1
      }
    ],
    "order_customer_id": 2,
    "order_shipping_charges": 6.3,
    "order_tax": 1.9,
    "ship_address_id": 2
  }
]

#Address
{       
	  "city": "Plano",
    "country": "USA",
    "line1": "Bake Street",
    "line2": "34",
    "state": "Texas",
    "zipCode": "77775"
}

#Payment
{
  "bill_address_id": 1,
  "orderId": 3,
  "order_payment_amount": 20.8,
  "order_payment_method": "CREDIT CARD"
}
    
    
