package com.example.techshop.service;

import com.example.techshop.dto.ProductDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.ProductConverter;
import com.example.techshop.utils.convert.UserConverter;
import com.example.techshop.utils.convert.list.ProductListConverter;
import com.example.techshop.utils.convert.list.UserListConverter;
import java.util.List;

public class ProductService {



  public List<ProductDTO> getAllProduct() {
    List<ProductEntity> entities = STRepoUtil.getProductRepo().findAll();
    return ProductListConverter.entity2Dto(entities);
  }

  public List<ProductDTO> getProducts(int firstIndex){
    List<ProductEntity> entities = STRepoUtil.getProductRepo().getProducts(firstIndex);
    return ProductListConverter.entity2Dto(entities);
  }

  public List<ProductDTO> getSomeFirstProducts(){
    List<ProductEntity> entities = STRepoUtil.getProductRepo().getProducts(0);
    return ProductListConverter.entity2Dto(entities);
  }
//  public ProductDTO findUser(String email, String password) {
//    ProductEntity entity = STRepoUtil.getProductRepo().findUser(email, password);
//    ProductDTO dto = UserConverter.entity2Dto(entity);
//    if (dto != null) {
//      return dto;
//    }
//    return null;
//  }
  public ProductDTO findById(Integer id) {
    ProductEntity entity = STRepoUtil.getProductRepo().findById(id);
    ProductDTO ProductDTO = ProductConverter.entity2Dto(entity);
    return ProductDTO;
  }
//
//  public void saveUser(ProductDTO ProductDTO) {
//    ProductEntity ProductEntity = UserConverter.dto2Entity(ProductDTO);
//    STRepoUtil.getProductRepo().save(ProductEntity);
//  }
//
//  public ProductDTO updateUser(ProductDTO ProductDTO) {
//    ProductEntity ProductEntity = UserConverter.dto2Entity(ProductDTO);
//    ProductEntity = STRepoUtil.getProductRepo().update(ProductEntity);
//    ProductDTO = UserConverter.entity2Dto(ProductEntity);
//    return ProductDTO;
//  }
//
//  public void deleteUser(List<Integer> ids) {
//    STRepoUtil.getProductRepo().delete(ids);
//  }

}
