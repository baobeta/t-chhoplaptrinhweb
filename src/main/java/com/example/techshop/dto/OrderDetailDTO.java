package com.example.techshop.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailDTO {
  
  private Integer orderDetailsId;

  private int total;

  private Boolean ispaid;

  private List<OrderItemDTO> orderItemDTOList;

  private UserDTO userDTO;

}
