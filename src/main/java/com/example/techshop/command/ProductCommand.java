package com.example.techshop.command;

import com.example.techshop.command.abstractcommand.AbstractCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.ProductDTO;

public class ProductCommand extends AbstractCommand<ProductDTO> {

  public ProductCommand() {
    this.pojo = new ProductDTO();
  }
}
