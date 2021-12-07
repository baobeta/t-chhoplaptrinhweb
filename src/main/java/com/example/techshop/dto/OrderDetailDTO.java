package com.example.techshop.dto;

import java.sql.Timestamp;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailDTO implements Comparable<OrderDetailDTO> {
  
  private Integer orderDetailId;

  private int total;

  private Boolean ispaid;

  private Timestamp createdDate;

  private List<OrderItemDTO> orderItemDTOList;

  private UserDTO userDTO;

  private String phoneNumber;

  private String address;


  @Override
  public int compareTo(OrderDetailDTO o) {
    return (this.orderDetailId - o.getOrderDetailId());
  }
}
