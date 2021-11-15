package com.example.techshop.controller.login;

import com.example.techshop.command.UserCommand;
import com.example.techshop.dto.RoleDTO;
import com.example.techshop.dto.UserDTO;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher
        = this.getServletContext().getRequestDispatcher("/views/common/register.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    UserCommand command = FormUtil.populate(UserCommand.class,request);
    UserDTO user = command.getPojo();
    user.setRoleDTO(STServiceUtil.getRoleService().getRoleByName("CUSTOMER"));
    STServiceUtil.getUserService().register(user);
    response.sendRedirect("/login");
  }
}
