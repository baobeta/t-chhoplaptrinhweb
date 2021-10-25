package com.example.techshop.utils.convert;

import com.example.techshop.dto.ShoppingSessionDTO;
import com.example.techshop.entity.ShoppingSessionEntity;

public class ShoppingSessionConverter {

  public static ShoppingSessionDTO entity2Dto(ShoppingSessionEntity entity) {
    ShoppingSessionDTO dto = new ShoppingSessionDTO();
    dto.setCustomerDTO(CustomerConverter.entity2Dto(entity.getCustomerEntity()));
    dto.setShoppingSessionId(entity.getShoppingSessionId());
    dto.setTotal(entity.getTotal());
    return dto;
  }

  public static ShoppingSessionEntity dto2Entity(ShoppingSessionDTO dto){
    ShoppingSessionEntity entity = new ShoppingSessionEntity();
    entity.setCustomerEntity(CustomerConverter.dto2Entity(dto.getCustomerDTO()));
    entity.setShoppingSessionId(dto.getShoppingSessionId());
    entity.setTotal(dto.getTotal());
    return entity;
  }

}
