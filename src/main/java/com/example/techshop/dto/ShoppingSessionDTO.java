package com.example.techshop.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShoppingSessionDTO {

  private int shoppingSessionId;

  private int total;

  private UserDTO userDTO;

  private List<CartItemDTO> cartItemDTOList;

}
