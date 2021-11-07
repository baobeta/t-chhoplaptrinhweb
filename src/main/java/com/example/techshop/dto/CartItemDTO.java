package com.example.techshop.dto;

import com.example.techshop.entity.ProductEntity;
import com.example.techshop.entity.ShoppingSessionEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class CartItemDTO {
  
  private Integer cartItemId;
  
  private Integer quantity;
  
  private ShoppingSessionDTO shoppingSessionDTO;

  private ProductDTO productDTO;
}
