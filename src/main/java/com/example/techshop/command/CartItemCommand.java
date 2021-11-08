package com.example.techshop.command;

import com.example.techshop.command.abstractcommand.AbstractCommand;
import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.dto.CategoryDTO;

public class CartItemCommand extends AbstractCommand<CartItemDTO> {

  public CartItemCommand() {
    this.pojo = new CartItemDTO();
  }

}
