package com.example.techshop.dto;

import com.example.techshop.dto.RoleDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class UserDTO {

  private Integer userId;

  private String email;

  private String password;

  private String firstName;

  private String lastName;

  private String photos;

  private RoleDTO roleDTO;

  @Override
  public String toString() {
    return this.userId.toString() +" - "
        + this.email+" - "
        +this.password+ " - "
        +this.firstName+ " - "
        +this.lastName+" - "
        +this.roleDTO.getName();
  }
}
