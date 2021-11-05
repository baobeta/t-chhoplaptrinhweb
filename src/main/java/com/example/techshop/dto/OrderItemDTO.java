package com.example.techshop.dto;

import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderItemDTO {

  private int orderItemsId;

  private Integer quantiy;

  private ProductDTO productDTO;

  private OrderDetailDTO orderDetailDTO;

}
