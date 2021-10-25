package com.example.techshop.utils.convert;

import com.example.techshop.dto.OrderItemDTO;
import com.example.techshop.entity.OrderItemEntity;

public class OrderItemConverter {

  public static OrderItemDTO entity2Dto(OrderItemEntity entity) {
    OrderItemDTO dto = new OrderItemDTO();
    dto.setOrderItemsId(entity.getOrderItemsId());
    dto.setQuantiy(entity.getQuantiy());
    dto.setCustomerDTO(CustomerConverter.entity2Dto(entity.getCustomerEntity()));
    dto.setProductDTO(ProductConverter.entity2Dto(entity.getProductEntity()));
    dto.setOrderDetailDTO(OrderDetailConverter.entity2Dto(entity.getOrderDetailEntity()));
    return dto;
  }

  public static OrderItemEntity dto2Entity(OrderItemDTO dto){
    OrderItemEntity entity = new OrderItemEntity();
    entity.setOrderItemsId(dto.getOrderItemsId());
    entity.setQuantiy(dto.getQuantiy());
    entity.setCustomerEntity(CustomerConverter.dto2Entity(dto.getCustomerDTO()));
    entity.setProductEntity(ProductConverter.dto2Entity(dto.getProductDTO()));
    entity.setOrderDetailEntity(OrderDetailConverter.dto2Entity(dto.getOrderDetailDTO()));
    return entity;
  }

}
