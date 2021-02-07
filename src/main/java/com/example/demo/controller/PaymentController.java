package com.example.demo.controller;


import com.example.demo.entity.EntityPayment;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.exception.PaymentNotMadeException;
import com.example.demo.service.IPaymentService;
import com.example.demo.vo.PaymentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Api("Set of endpoints for CRUD operations on Payments")
public class PaymentController extends BaseRestController
{

    @Autowired
    private IPaymentService iPaymentService;

    @PostMapping("/pay")
    @ApiOperation("Make payment the order placed")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Payment made successfully"),
            @ApiResponse(code = 404, message = "Payment couldnot not made !") })
    public ResponseEntity<Void> payForOrder(@RequestBody EntityPayment entityPayment){
        try{
            EntityPayment paymentEntityResponse = iPaymentService.makePayment(entityPayment);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch( Exception e){
                throw new PaymentNotMadeException(ErrorCode.PAYMENT_DECLINED, "Payment Dint go through.");
        }

    }


}
