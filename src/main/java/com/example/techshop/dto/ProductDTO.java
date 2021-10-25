package com.example.techshop.dto;

import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.dto.OrderItemDTO;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {

  private int productId;

  private String description;

  private String name;

  private Integer price;

  private Integer quantity;

  private String photo;

  private List<CartItemDTO> cartItemDTOList;

  private List<OrderItemDTO> orderItemDTOList;

  private CategoryDTO categoryDTO;

  private BrandDTO brandDTO;

}
