package com.example.techshop.dto;

import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.dto.ShoppingSessionDTO;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDTO {

  private int customerId;

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private String phoneNumber;

  private List<OrderDetailDTO> orderDetailDTOList;

}
