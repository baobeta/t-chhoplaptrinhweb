package com.example.techshop.command;

import com.example.techshop.command.abstractcommand.AbstractCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.UserDTO;

public class UserCommand extends AbstractCommand<UserDTO> {
    String role;
    public UserCommand (){
        this.pojo = new UserDTO();
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
