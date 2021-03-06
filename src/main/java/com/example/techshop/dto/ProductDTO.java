package com.example.techshop.dto;

import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.dto.OrderItemDTO;
import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {

  private Integer productId;

  private String description;

  private String name;

  private Integer price;

  private Integer quantity;

  private String photo;

  private Timestamp createdDate;

  private boolean sale;

  private List<CartItemDTO> cartItemDTOList;

  private List<OrderItemDTO> orderItemDTOList;

  private CategoryDTO categoryDTO;

  private BrandDTO brandDTO;

}
