package com.example.techshop.controller.admin;


import com.example.techshop.dto.UserDTO;
import com.example.techshop.utils.STServiceUtil;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<UserDTO> users = STServiceUtil.getUserService().getUser();
    request.setAttribute("users",users);
    RequestDispatcher dispatcher
        = this.getServletContext().getRequestDispatcher("/views/admin.jsp");
    dispatcher.forward(request, response);
  }
}