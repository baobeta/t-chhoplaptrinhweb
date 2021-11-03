package com.example.techshop.service;

import com.example.techshop.dto.ProductDTO;
import com.example.techshop.dto.UserDTO;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.ProductConverter;
import com.example.techshop.utils.convert.UserConverter;
import com.example.techshop.utils.convert.list.ProductListConverter;
import com.example.techshop.utils.convert.list.UserListConverter;
import java.util.List;

public class ProductService {

  public List<ProductDTO> getAllProduct() {
    List<ProductEntity> entities = STRepoUtil.getProductRepo().findAll();
    List<ProductDTO> dtos = ProductListConverter.entity2Dto(entities);
    return dtos;
  }

//  public UserDTO findUser(String email, String password) {
//    UserEntity entity = STRepoUtil.getUserRepo().findUser(email, password);
//    UserDTO dto = UserConverter.entity2Dto(entity);
//    if (dto != null) {
//      return dto;
//    }
//    return null;
//  }
//  public UserDTO findById(Integer id) {
//    UserEntity userEntity = STRepoUtil.getUserRepo().findById(id);
//    UserDTO userDTO = UserConverter.entity2Dto(userEntity);
//    return userDTO;
//  }
//
//  public void saveUser(UserDTO userDTO) {
//    UserEntity userEntity = UserConverter.dto2Entity(userDTO);
//    STRepoUtil.getUserRepo().save(userEntity);
//  }
//
//  public UserDTO updateUser(UserDTO userDTO) {
//    UserEntity userEntity = UserConverter.dto2Entity(userDTO);
//    userEntity = STRepoUtil.getUserRepo().update(userEntity);
//    userDTO = UserConverter.entity2Dto(userEntity);
//    return userDTO;
//  }
//
//  public void deleteUser(List<Integer> ids) {
//    STRepoUtil.getUserRepo().delete(ids);
//  }

}
