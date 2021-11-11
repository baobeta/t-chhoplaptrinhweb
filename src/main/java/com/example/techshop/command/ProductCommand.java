package com.example.techshop.command;

import com.example.techshop.command.abstractcommand.AbstractCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCommand extends AbstractCommand<ProductDTO> {

  private String categoryDTO;
  private String brandDTO;
  private Integer idDelete;
  private BrandDTO brand;
  private CategoryDTO category;

  public ProductCommand() {
    this.pojo = new ProductDTO();
    this.brand = new BrandDTO();
    this.category = new CategoryDTO();
  }

}
