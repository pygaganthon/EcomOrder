package com.example.demo.service.impl;

import com.example.demo.dao.IAddressDAO;
import com.example.demo.dao.IPaymentDAO;
import com.example.demo.entity.EntityAddress;
import com.example.demo.service.IAddressService;
import com.example.demo.translator.IAddressTranslator;
import com.example.demo.vo.AddressVO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class AddressServiceImpl implements IAddressService
{
    private final IAddressDAO iAddressDAO;
//    private final IAddressTranslator iAddressTranslator;

    @Override public void insertAddress(EntityAddress entityAddress)
    {
//        EntityAddress entityAddress = iAddressTranslator.toAddressEntity(addressVO);
        iAddressDAO.save(entityAddress);
    }
}
