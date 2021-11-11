package com.example.techshop.service;

import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.entity.CategoryEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.CategoryConverter;
import com.example.techshop.utils.convert.list.CategoryListConverter;
import java.util.List;

public class CategoryService {
  public List<CategoryDTO> getAllCategory() {
    List<CategoryEntity> entities = STRepoUtil.getCategoryRepo().findAll();
    List<CategoryDTO> dtos = CategoryListConverter.entity2Dto(entities);
    return dtos;
  }

  public CategoryDTO findById(Integer id) {
    CategoryDTO dto = new CategoryDTO();
    CategoryEntity categoryEntity = STRepoUtil.getCategoryRepo().findById(id);
    dto = CategoryConverter.entity2Dto(categoryEntity);
    return dto;
  }
  

}
