package com.example.techshop.dto;

import com.example.techshop.dto.ProductDTO;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryDTO {
  
  private Integer categoryId;
  
  private String description;

  private String name;

  private List<ProductDTO> productDTOList;
}
