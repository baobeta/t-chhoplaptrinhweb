package com.example.techshop.service;

import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.BrandConverter;
import com.example.techshop.utils.convert.ProductConverter;
import com.example.techshop.utils.convert.list.BrandListConverter;
import com.example.techshop.utils.convert.list.ProductListConverter;

import java.util.ArrayList;
import java.util.List;

public class BrandService {
  public List<BrandDTO> getAllBrand() {
    List<BrandEntity> entities = STRepoUtil.getBrandRepo().findAll();
    List<BrandDTO> dtos = BrandListConverter.entity2Dto(entities);
    return dtos;
  }

  public BrandDTO findById(Integer id) {
     BrandDTO dto = new BrandDTO();
     BrandEntity entity = STRepoUtil.getBrandRepo().findById(id);
     dto = BrandConverter.entity2Dto(entity);
     return dto;
  }
  public List<BrandDTO> pagination(Integer pageNumber, Integer pageSize) {
      List<BrandEntity> entities = STRepoUtil.getBrandRepo().pagination(pageNumber,pageSize);
      return BrandListConverter.entity2Dto(entities);
  }
  public Integer countBrand () {
      return STRepoUtil.getBrandRepo().Count("brandId");
  }

    public  BrandDTO  findEqualUnique(String property, Object value) {
        BrandEntity brandEntity = STRepoUtil.getBrandRepo().findEqualUnique(property,value);
        BrandDTO brandDTO = BrandConverter.entity2Dto(brandEntity);
        return brandDTO;
    }

    public void save(BrandDTO dto) {
      BrandEntity entity = BrandConverter.dto2Entity(dto);
      STRepoUtil.getBrandRepo().save(entity);

    }

    public BrandDTO update(BrandDTO dto) {
      BrandEntity entity = BrandConverter.dto2Entity(dto);
      entity = STRepoUtil.getBrandRepo().update(entity);
      return BrandConverter.entity2Dto(entity);
    }

    public void delete(List<Integer> ids) {
      STRepoUtil.getBrandRepo().delete(ids);
    }

}
