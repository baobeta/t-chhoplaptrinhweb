package com.example.techshop.service;

import com.example.techshop.command.OrderDetailCommand;
import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.entity.CartItemEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.list.CartItemListConverter;
import java.util.List;

public class OrderItemService {

  public void convertCartItemToOrderItem(OrderDetailCommand command){
    STRepoUtil.getOrderItemRepo().convertCartItemToOrderItem(command);
  }

}
