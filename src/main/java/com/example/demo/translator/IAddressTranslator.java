package com.example.demo.translator;

import com.example.demo.entity.EntityAddress;
import com.example.demo.vo.AddressVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAddressTranslator
{
    AddressVO toAddressVO(EntityAddress entityAddress);

    EntityAddress toAddressEntity(AddressVO addressVO);
}