package com.example.techshop.command;

import com.example.techshop.command.abstractcommand.AbstractCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
import org.postgresql.jdbc.PgConnection.AbortCommand;

public class CategoryCommand extends AbstractCommand<CategoryDTO> {

  public CategoryCommand() {
    this.pojo = new CategoryDTO();
  }

}
