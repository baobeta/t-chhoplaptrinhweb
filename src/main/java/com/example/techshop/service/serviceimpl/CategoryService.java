package com.example.techshop.service.serviceimpl;

import com.example.techshop.command.CategoryCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.entity.CategoryEntity;
import com.example.techshop.service.iservice.ICategoryService;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.STServiceUtil;
import com.example.techshop.utils.convert.CategoryConverter;
import com.example.techshop.utils.convert.list.BrandListConverter;
import com.example.techshop.utils.convert.list.CategoryListConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CategoryService implements ICategoryService {

  public List<CategoryDTO> getAllCategory() {
    List<CategoryEntity> entities = STRepoUtil.getCategoryRepo().findAll();
    List<CategoryDTO> dtos = CategoryListConverter.entity2Dto(entities);
    return dtos;
  }

  public CategoryDTO getCategoryByName(String name) {
    CategoryEntity category = STRepoUtil.getCategoryRepo().findCategoryByName(name);
    return CategoryConverter.entity2Dto(category);
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

  public Map<CategoryDTO, List<BrandDTO>> buildBrandInCate(List<CategoryDTO> categoryDTOS) {
    Map<CategoryDTO, List<BrandDTO>> brandInCate = new HashMap<CategoryDTO, List<BrandDTO>>();
    for (CategoryDTO category : categoryDTOS) {
      brandInCate.put(category,
          STServiceUtil.getCategoryService().getBrandByCate(category.getCategoryId()));
    }
    TreeMap<CategoryDTO, List<BrandDTO>> sortedList = new TreeMap<>();
    sortedList.putAll(brandInCate);
    return sortedList;
  }

  public List<CategoryDTO> pagination(Integer pageNumber, Integer pageSize) {
    List<CategoryEntity> entities = STRepoUtil.getCategoryRepo().pagination(pageNumber, pageSize);
    return CategoryListConverter.entity2Dto(entities);
  }

  public List<CategoryDTO> pagination(Integer pageNumber, Integer pageSize, String col,
      String value) {
    List<CategoryEntity> entities = STRepoUtil.getCategoryRepo()
        .pagination(pageNumber, pageSize, col, value);
    return CategoryListConverter.entity2Dto(entities);
  }


  public Integer countCategory() {
    return STRepoUtil.getCategoryRepo().Count("categoryId");
  }

  public Integer countCategory(String col, String value) {
    return STRepoUtil.getCategoryRepo().Count("categoryId", col, value);
  }

  public CategoryDTO findEqualUnique(String property, Object value) {
    CategoryEntity entity = STRepoUtil.getCategoryRepo().findEqualUnique(property, value);
    CategoryDTO categoryDTO = CategoryConverter.entity2Dto(entity);
    return categoryDTO;
  }

  public void save(CategoryDTO dto) throws Exception {
    CategoryEntity entity = CategoryConverter.dto2Entity(dto);
    entity = STRepoUtil.getCategoryRepo().save(entity);
    if (entity == null) {
      throw new Exception("Not save");
    }

  }

  public CategoryDTO update(CategoryDTO dto) throws Exception {
    CategoryEntity entity = CategoryConverter.dto2Entity(dto);
    entity = STRepoUtil.getCategoryRepo().update(entity);
    if (entity == null) {
      throw new Exception("Not update");
    }
    return CategoryConverter.entity2Dto(entity);
  }

  public void delete(List<Integer> ids) {
    STRepoUtil.getCategoryRepo().delete(ids);
  }

}
