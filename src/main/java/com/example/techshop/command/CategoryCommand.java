package com.example.techshop.command;

import com.example.techshop.command.abstractcommand.AbstractCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.utils.STServiceUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCommand extends AbstractCommand<CategoryDTO> {

  public CategoryCommand() {
    this.pojo = new CategoryDTO();
  }
  private Map<CategoryDTO, List<BrandDTO>> brandInCate;

  private Integer idDelete;

}
