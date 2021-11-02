package com.example.techshop.dto;

import com.example.techshop.dto.UserDTO;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class RoleDTO {

  private Integer roleId;

  private String name;

  private String description;

  private List<UserDTO> userDTOList;

  @Override
  public String toString() {
    return this.name;
  }
}
