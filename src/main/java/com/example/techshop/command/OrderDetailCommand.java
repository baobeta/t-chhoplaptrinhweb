package com.example.techshop.command;

import com.example.techshop.command.abstractcommand.AbstractCommand;
import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.dto.OrderDetailDTO;

import com.example.techshop.dto.OrderItemDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDetailCommand extends AbstractCommand<OrderDetailDTO> {
  public OrderDetailCommand(){
    this.pojo = new OrderDetailDTO();
  }
  private int total;
  private Integer cusId;
  private Boolean isPaid;
  private Integer year ;
  private String value = "";
  Map<OrderDetailDTO, List<OrderItemDTO>> itemsByCus;
}