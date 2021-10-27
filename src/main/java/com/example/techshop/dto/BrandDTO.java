package com.example.techshop.dto;

import com.example.techshop.entity.ProductEntity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class BrandDTO {

  private int brandId;

  private String description;

  private String name;

  private List<ProductDTO> productDTOList;

}
