package com.example.demo.controller;


import com.example.demo.entity.EntityOrder;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.OrderNotCreatedException;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.kafka.KafkaProducerApp;
import com.example.demo.vo.OrderVO;
import com.example.demo.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

import static com.example.demo.exception.ErrorCode.ORDER_NOT_CREATED;

@RestController
@Api("Set of endpoints for CRUD operations on order/orders")
public class OrderController extends BaseRestController
{

    @Autowired
    private IOrderService ordrSvc;

    @Autowired
    private KafkaProducerApp kafkaProducerApp;

    @GetMapping(path = "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns order by id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieved Order successfully")
    , @ApiResponse(code = 400, message = "The request is invalid. Please perform the correct operation.") })
    public ResponseEntity<OrderVO> getOrder(@PathVariable("id") Long orderId) throws ResponseStatusException
    {
        try
        {
            OrderVO orderVO = ordrSvc.getOrderById(orderId);
            return ResponseEntity.ok(orderVO);
        } catch(OrderNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order Not Found");
        }
    }

    @PostMapping(value = "/order")
    @ApiOperation(value = "places a new order", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Order placed successfully."),
            @ApiResponse(code = 400, message = "Invalid Request for placing order.")
    })
    public ResponseEntity<EntityOrder> placeOrder(@RequestBody EntityOrder entityOrder) throws ResponseStatusException
    {
        try {
            EntityOrder orderEntityResponse = ordrSvc.placeOrder(entityOrder);
            return ResponseEntity.ok(orderEntityResponse);
        }
        catch (Exception e) {
            throw new OrderNotCreatedException(ErrorCode.ORDER_NOT_CREATED, "Order not placed. Try Again!");
        }
    }

    @PostMapping(value = "/order/{id}/cancel")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Order cancelled successfully ."),
            @ApiResponse(code = 400, message = "The request is invalid. Please perform the correct operation.")})
    public ResponseEntity<EntityOrder> cancelOrder(@PathVariable("id") Long orderId) {
        try
        {
            EntityOrder orderEntityResponse = ordrSvc.cancelOrderById(orderId);
            return ResponseEntity.ok(orderEntityResponse);
        } catch(OrderNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order Not Found");
        }
    }

    @PostMapping(value = "/order/bulk")
    @ApiOperation(value = "create orders in bulk")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Order createdsuccessfully ."),
            @ApiResponse(code = 400, message = "The request is invalid. Please perform the correct operation.")})
    public void placeOrders(@RequestBody List<EntityOrder> orders){
        kafkaProducerApp.sendToTopic("order-test",orders);
    }
}
