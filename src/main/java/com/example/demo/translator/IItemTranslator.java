package com.example.demo.translator;

import com.example.demo.entity.EntityItem;
import com.example.demo.entity.EntityOrder;
import com.example.demo.vo.ItemVO;
import com.example.demo.vo.OrderVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IItemTranslator {
    ItemVO toItemVO(EntityItem entityItem);
    List<ItemVO> toItemVOList(List<EntityItem> entityItemList);
}
