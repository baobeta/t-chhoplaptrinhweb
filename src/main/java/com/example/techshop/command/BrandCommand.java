package com.example.techshop.command;

import com.example.techshop.command.abstractcommand.AbstractCommand;
import com.example.techshop.dto.BrandDTO;

public class BrandCommand extends AbstractCommand<BrandDTO> {

  public BrandCommand() {
    this.pojo = new BrandDTO();
  }


}
