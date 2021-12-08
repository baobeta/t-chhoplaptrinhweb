package com.example.techshop.controller.admin.user;

import com.example.techshop.command.UserCommand;
import com.example.techshop.dto.RoleDTO;
import com.example.techshop.dto.UserDTO;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.STServiceUtil;
import com.example.techshop.utils.convert.RoleConverter;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/user/edit")
public class EditUserController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    try {
      List<RoleDTO> roles = STServiceUtil.getRoleService().getRole();
      request.setAttribute("roles", roles);
      UserCommand command = FormUtil.populate(UserCommand.class, request);
      if (request.getParameter("userId") != null) {
        Integer id = Integer.valueOf(request.getParameter("userId"));
        UserDTO dto = STServiceUtil.getUserService().findEqualUnique("id", id);
        request.setAttribute("user", dto);
      }
      RequestDispatcher dispatcher
          = this.getServletContext().getRequestDispatcher("/views/admin/user/editUser.jsp");
      dispatcher.forward(request, response);
    } catch (Exception e) {
      response.sendRedirect("/error");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");
    UserCommand command = FormUtil.populate(UserCommand.class, req);
    if (command.getPojo().getUserId() !=0&&command.getPojo().getUserId() !=null ) {
      RoleDTO role = RoleConverter.entity2Dto(
          STRepoUtil.getRoleRepo().findEqualUnique("name", command.getRole()));
      command.getPojo().setRoleDTO(role);
      try {
        STServiceUtil.getUserService().updateUser(command.getPojo());
        resp.sendRedirect("/admin/user?message=updateSuccess");
      } catch (Exception exception) {
        resp.sendRedirect("/admin/user?message=Error");
      }
    } else {
      RoleDTO role = RoleConverter.entity2Dto(
          STRepoUtil.getRoleRepo().findEqualUnique("name", command.getRole()));
      command.getPojo().setRoleDTO(role);
      try {
        command.getPojo().setUserId(null);
        STServiceUtil.getUserService().saveUser(command.getPojo());
        resp.sendRedirect("/admin/user?message=addSuccess");
      } catch (Exception exception) {
        resp.sendRedirect("/admin/user?message=Error");
      }

    }
  }

}
