package com.example.techshop.utils.convert;

import com.example.techshop.dto.CustomerDTO;
import com.example.techshop.dto.CustomerDTO;
import com.example.techshop.entity.CartItemEntity;
import com.example.techshop.entity.CustomerEntity;

public class CustomerConverter {
  
  public static CustomerDTO entity2Dto(CustomerEntity entity) {
    CustomerDTO dto = new CustomerDTO();
    dto.setCustomerId(entity.getCustomerId());
    dto.setEmail(entity.getEmail());
    dto.setFirstName(entity.getFirstName());
    dto.setLastName(entity.getLastName());
    dto.setPassword(entity.getPassword());
    dto.setPhoneNumber(entity.getPhoneNumber());
    return dto;
  }

  public static CustomerEntity dto2Entity(CustomerDTO dto){
    CustomerEntity entity = new CustomerEntity();
    entity.setCustomerId(dto.getCustomerId());
    entity.setEmail(dto.getEmail());
    entity.setFirstName(dto.getFirstName());
    entity.setLastName(dto.getLastName());
    entity.setPassword(dto.getPassword());
    entity.setPhoneNumber(dto.getPhoneNumber());
    return entity;
  }
}
