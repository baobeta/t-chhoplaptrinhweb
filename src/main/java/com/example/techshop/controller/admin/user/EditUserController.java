package com.example.techshop.controller.admin.user;

import java.io.IOException;
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
//        List<UserDTO> users = STServiceUtil.getUserService().getUser();
//        request.setAttribute("users",users);
    RequestDispatcher dispatcher
        = this.getServletContext().getRequestDispatcher("/views/admin/user/editUser.jsp");
    dispatcher.forward(request, response);
  }

}
