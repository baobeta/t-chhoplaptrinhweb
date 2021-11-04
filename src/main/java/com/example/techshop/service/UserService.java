package com.example.techshop.service;

import com.example.techshop.command.UserCommand;
import com.example.techshop.dto.UserDTO;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.UserConverter;
import com.example.techshop.utils.convert.list.UserListConverter;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

  public UserDTO findUser(String email, String password) {
    UserEntity entity = STRepoUtil.getUserRepo().findUser(email, password);
    UserDTO dto = UserConverter.entity2Dto(entity);
    if (dto != null) {
      return dto;
    }
    return null;
  }
  public List<UserDTO> getUser() {
    List<UserEntity> entities = STRepoUtil.getUserRepo().findAll();
    List<UserDTO> dtos = UserListConverter.entity2Dto(entities);
    return dtos;
  }

  public UserDTO findById(Integer id) {
    UserEntity userEntity = STRepoUtil.getUserRepo().findById(id);
    UserDTO userDTO = UserConverter.entity2Dto(userEntity);
    return userDTO;
  }

  public void saveUser(UserDTO userDTO) {
    UserEntity userEntity = UserConverter.dto2Entity(userDTO);
    STRepoUtil.getUserRepo().save(userEntity);
  }

  public UserDTO updateUser(UserDTO userDTO) {
    UserEntity userEntity = UserConverter.dto2Entity(userDTO);
    userEntity = STRepoUtil.getUserRepo().update(userEntity);
    userDTO = UserConverter.entity2Dto(userEntity);
    return userDTO;
  }

  public void deleteUser(List<Integer> ids) {
    STRepoUtil.getUserRepo().delete(ids);
  }

  public UserDTO findEqualUnique(String property, Object value) {
    UserEntity userEntity = STRepoUtil.getUserRepo().findEqualUnique(property,value);
    UserDTO userDTO = UserConverter.entity2Dto(userEntity);
    return userDTO;

  }

  public List<UserDTO> Pagingnation(Integer pageNumber, Integer pageSize) {
    List<UserEntity> listEntity = STRepoUtil.getUserRepo().pagination(pageNumber,pageSize);
    return UserListConverter.entity2Dto(listEntity);
  }
  public Integer CountUser() {
    return STRepoUtil.getUserRepo().Count("userId");
  }

}
