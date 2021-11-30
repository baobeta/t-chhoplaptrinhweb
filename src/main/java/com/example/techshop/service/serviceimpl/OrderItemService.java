package com.example.techshop.service.serviceimpl;

import com.example.techshop.command.OrderDetailCommand;
import com.example.techshop.dao.repository.OrderItemRepo;
import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.dto.OrderItemDTO;
import com.example.techshop.entity.CartItemEntity;
import com.example.techshop.entity.OrderItemEntity;
import com.example.techshop.service.iservice.IOrderItemService;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.list.CartItemListConverter;
import com.example.techshop.utils.convert.list.OrderItemListConverter;

import java.util.List;

public class OrderItemService implements IOrderItemService {

  public void convertCartItemToOrderItem(OrderDetailCommand command) {
    STRepoUtil.getOrderItemRepo().convertCartItemToOrderItem(command);
  }

  public List<OrderItemDTO> findByOrderDetail(Integer id) {
    List<OrderItemEntity> entities = STRepoUtil.getOrderItemRepo().getOrderItemsByOrderId(id);
    return OrderItemListConverter.entity2Dto(entities);
  }

}
