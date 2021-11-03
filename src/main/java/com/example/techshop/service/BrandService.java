package com.example.techshop.service;

import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.BrandConverter;
import com.example.techshop.utils.convert.list.BrandListConverter;
import com.example.techshop.utils.convert.list.ProductListConverter;
import java.util.List;

public class BrandService {
  public List<BrandDTO> getAllBrand() {
    List<BrandEntity> entities = STRepoUtil.getBrandRepo().findAll();
    List<BrandDTO> dtos = BrandListConverter.entity2Dto(entities);
    return dtos;
  }
}
