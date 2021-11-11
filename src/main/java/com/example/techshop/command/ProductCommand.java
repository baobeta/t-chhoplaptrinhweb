package com.example.techshop.command;

import com.example.techshop.command.abstractcommand.AbstractCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.ProductDTO;

public class ProductCommand extends AbstractCommand<ProductDTO> {

  public ProductCommand() {
    this.pojo = new ProductDTO();
  }

  public String getCategoryDTO() {
    return categoryDTO;
  }

  public void setCategoryDTO(String categoryDTO) {
    this.categoryDTO = categoryDTO;
  }

  public String getBrandDTO() {
    return brandDTO;
  }

  public void setBrandDTO(String brandDTO) {
    this.brandDTO = brandDTO;
  }

  public String categoryDTO;
  public String brandDTO;

  public Integer getIdDelete() {
    return idDelete;
  }

  public void setIdDelete(Integer idDelete) {
    this.idDelete = idDelete;
  }

  private Integer idDelete;
}
