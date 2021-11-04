package com.example.techshop.controller.admin.product;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/product/edit")
public class EditProductController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
//        List<UserDTO> users = STServiceUtil.getUserService().getUser();
//        request.setAttribute("users",users);
    RequestDispatcher dispatcher
        = this.getServletContext().getRequestDispatcher("/views/admin/product/editProduct.jsp");
    dispatcher.forward(request, response);
  }
}

