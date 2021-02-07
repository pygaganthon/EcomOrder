package com.example.demo.controller;

import com.example.demo.entity.EntityAddress;
import com.example.demo.service.IAddressService;
import com.example.demo.vo.AddressVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class AddressController extends BaseRestController
{
    private final IAddressService iAddressService;

    @PostMapping(value = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "create a new address for a customer",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(code = 200, message = "Customer address created successfully.")
    public void addAddress(@RequestBody EntityAddress entityAddress){

        iAddressService.insertAddress(entityAddress);
    }
}
