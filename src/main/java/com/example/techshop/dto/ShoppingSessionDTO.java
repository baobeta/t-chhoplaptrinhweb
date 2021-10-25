package com.example.techshop.dto;

import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.dto.CustomerDTO;
import com.example.techshop.dto.OrderDetailDTO;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShoppingSessionDTO {

  private int shoppingSessionId;

  private Long total;

  private CustomerDTO customerDTO;

  private List<CartItemDTO> cartItemDTOList;

  private List<OrderDetailDTO> orderDetailDTOList;

}
