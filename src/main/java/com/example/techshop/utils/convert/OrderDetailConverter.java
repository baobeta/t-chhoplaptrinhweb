package com.example.techshop.utils.convert;

import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.entity.OrderDetailEntity;

public class OrderDetailConverter {

  public static OrderDetailDTO entity2Dto(OrderDetailEntity entity) {
    OrderDetailDTO dto = new OrderDetailDTO();
    dto.setOrderDetailsId(entity.getOrderDetailsId());
    dto.setIspaid(entity.getIspaid());
    dto.setTotal(entity.getTotal());
    dto.setUserDTO(UserConverter.entity2Dto(entity.getUserEntity()));
    dto.setCustomerDTO(CustomerConverter.entity2Dto(entity.getCustomerEntity()));
    return dto;
  }

  public static OrderDetailEntity dto2Entity(OrderDetailDTO dto){
    OrderDetailEntity entity = new OrderDetailEntity();
    entity.setOrderDetailsId(dto.getOrderDetailsId());
    entity.setIspaid(dto.getIspaid());
    entity.setTotal(dto.getTotal());
    entity.setUserEntity(UserConverter.dto2Entity(dto.getUserDTO()));
    entity.setCustomerEntity(CustomerConverter.dto2Entity(dto.getCustomerDTO()));
    return entity;
  }
}
