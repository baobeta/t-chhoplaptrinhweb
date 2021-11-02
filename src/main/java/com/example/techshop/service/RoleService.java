package com.example.techshop.service;

import com.example.techshop.dto.RoleDTO;
import com.example.techshop.entity.RoleEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.RoleConverter;
import com.example.techshop.utils.convert.UserConverter;

import java.util.ArrayList;
import java.util.List;

public class RoleService {

    public List<RoleDTO> getRole() {
        List<RoleDTO> dtos = new ArrayList<>();
        List<RoleEntity> entitys = STRepoUtil.getRoleRepo().findAll();
        for(RoleEntity entity :entitys) {
            dtos.add(RoleConverter.entity2Dto(entity));
        }
        return dtos;
    }

    public void saveRole(RoleDTO dto) {
        RoleEntity entity = RoleConverter.dto2Entity(dto);
        STRepoUtil.getRoleRepo().save(entity);
    }
    public RoleDTO updateRole(RoleDTO dto) {
        RoleEntity entity = RoleConverter.dto2Entity(dto);
        entity = STRepoUtil.getRoleRepo().update(entity);
        dto = RoleConverter.entity2Dto(entity);
        return dto;
    }
    public void deleteRole(List<Integer> ids) {
        STRepoUtil.getRoleRepo().delete(ids);
    }

}
