package com.example.demo.translator;

import com.example.demo.entity.EntityOrder;
import com.example.demo.vo.OrderVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IOrderTranslator
{
    OrderVO toOrderVO(EntityOrder entityOrder);

//    EntityOrder toOrderEntity(OrderVO orderVO);
}
