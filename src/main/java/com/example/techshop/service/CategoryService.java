package com.example.techshop.service;

import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.entity.CategoryEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.CategoryConverter;
import com.example.techshop.utils.convert.BrandConverter;
import com.example.techshop.utils.convert.list.BrandListConverter;
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
  public List<BrandDTO> getBrandByCate(Integer cateId){
    List<BrandEntity> entities = STRepoUtil.getCategoryRepo().getBrandInCate(cateId);
    List<BrandDTO> dtos = BrandListConverter.entity2Dto(entities);
    return dtos;

  }
  public List<CategoryDTO> pagination(Integer pageNumber, Integer pageSize) {
    List<CategoryEntity> entities = STRepoUtil.getCategoryRepo().pagination(pageNumber,pageSize);
    return CategoryListConverter.entity2Dto(entities);
  }

  public Integer countCategory () {
    return STRepoUtil.getCategoryRepo().Count("categoryId");
  }


  public  CategoryDTO  findEqualUnique(String property, Object value) {
    CategoryEntity entity = STRepoUtil.getCategoryRepo().findEqualUnique(property,value);
    CategoryDTO categoryDTO = CategoryConverter.entity2Dto(entity);
    return categoryDTO;
  }

  public void save(CategoryDTO dto) {
    CategoryEntity entity = CategoryConverter.dto2Entity(dto);
    STRepoUtil.getCategoryRepo().save(entity);

  }

  public CategoryDTO update(CategoryDTO dto) {
    CategoryEntity entity = CategoryConverter.dto2Entity(dto);
    entity = STRepoUtil.getCategoryRepo().update(entity);
    return  CategoryConverter.entity2Dto(entity);
  }

  public void delete(List<Integer> ids) {
    STRepoUtil.getCategoryRepo().delete(ids);
  }

}
