package com.example.techshop.dao.idao;

import com.example.techshop.entity.BrandEntity;
import com.example.techshop.entity.CategoryEntity;
import java.util.List;

 public interface ICategoryRepo {
   List<BrandEntity> getBrandInCate(Integer cateId);

   CategoryEntity findCategoryByName(String name);

}
