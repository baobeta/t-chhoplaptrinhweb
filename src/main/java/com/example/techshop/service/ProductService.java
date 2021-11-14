package com.example.techshop.service;

import com.example.techshop.command.ProductCommand;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.ProductConverter;
import com.example.techshop.utils.convert.UserConverter;
import com.example.techshop.utils.convert.list.ProductListConverter;
import com.example.techshop.utils.convert.list.UserListConverter;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder.In;

public class ProductService {

  public List<ProductDTO> getAllProduct() {
    List<ProductEntity> entities = STRepoUtil.getProductRepo().findAll();
    List<ProductDTO> dtos = ProductListConverter.entity2Dto(entities);
    return dtos;
  }

  public void save(ProductDTO productDTO) {
    ProductEntity entity = ProductConverter.dto2Entity(productDTO);
    STRepoUtil.getProductRepo().save(entity);
  }

  public ProductDTO productUpdate(ProductDTO dto) {
    ProductEntity entity = ProductConverter.dto2Entity(dto);
    entity = STRepoUtil.getProductRepo().update(entity);
    dto = ProductConverter.entity2Dto(entity);
    return dto;
  }

  public void deleteProduct(List<Integer> ids) {
    STRepoUtil.getProductRepo().delete(ids);
  }

  public List<ProductDTO> getProducts( Map<String, Object> properties){
    List<ProductEntity> entities = STRepoUtil.getProductRepo().searchResult(properties);
    return ProductListConverter.entity2Dto(entities);
  }

  public List<ProductDTO> getSomeFirstProducts(ProductCommand command, Map<String, Object> properties){
    command.setFirstIndex(0);
    List<ProductEntity> entities = STRepoUtil.getProductRepo().searchResult(properties);
    return ProductListConverter.entity2Dto(entities);
  }

  public Map<String,Object> searchProperties(ProductCommand command){
    return STRepoUtil.getProductRepo().searchProperties(command);
  }

  public  ProductDTO  findEqualUnique(String property, Object value) {
    ProductEntity productEntity = STRepoUtil.getProductRepo().findEqualUnique(property,value);
    ProductDTO productDTO = ProductConverter.entity2Dto(productEntity);
    return productDTO;
  }

  public List<ProductDTO> pagingnation(Integer pageNumber, Integer pageSize) {
    List<ProductEntity> entities = STRepoUtil.getProductRepo().pagination(pageNumber,pageSize);
    return ProductListConverter.entity2Dto(entities);

  }



  public Integer CountProduct() {
    return STRepoUtil.getProductRepo().Count("productId");
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
