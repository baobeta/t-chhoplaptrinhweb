package com.example.techshop.dto;

import com.example.techshop.dto.UserDTO;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoleDTO {

  private Integer roleId;

  private String name;

  private String description;

  private List<UserDTO> userDTOList;

}
