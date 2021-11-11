package com.example.techshop.service;

import com.example.techshop.command.CategoryCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.entity.CategoryEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.STServiceUtil;
import com.example.techshop.utils.convert.CategoryConverter;
import com.example.techshop.utils.convert.BrandConverter;
import com.example.techshop.utils.convert.list.BrandListConverter;
import com.example.techshop.utils.convert.list.CategoryListConverter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  public List<BrandDTO> getBrandByCate(Integer cateId) {
    List<BrandEntity> entities = STRepoUtil.getCategoryRepo().getBrandInCate(cateId);
    List<BrandDTO> dtos = BrandListConverter.entity2Dto(entities);
    return dtos;
  }

  public Map<CategoryDTO, List<BrandDTO>> buildBrandInCate(CategoryCommand command) {
    Map<CategoryDTO, List<BrandDTO>> brandInCate = new HashMap<CategoryDTO, List<BrandDTO>>();
    for (CategoryDTO category : command.getListResult()) {
      brandInCate.put(category,
          STServiceUtil.getCategoryService().getBrandByCate(category.getCategoryId()));
    }
    return brandInCate;
  }


}
