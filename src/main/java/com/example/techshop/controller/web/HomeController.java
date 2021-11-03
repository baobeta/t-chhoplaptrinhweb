package com.example.techshop.controller.web;

import com.example.techshop.command.ProductCommand;
import com.example.techshop.dao.repository.CartItemRepo;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.RoleEntity;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;
import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet("/home")
public class HomeController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

//    ProductCommand productCommand = FormUtil.populate(ProductCommand.class,request);
//    productCommand.setListResult(STServiceUtil.getProductService().getAllProduct());
//    request.setAttribute("items",productCommand);

    RequestDispatcher dispatcher //
        = this.getServletContext().getRequestDispatcher("/views/home.jsp");
    dispatcher.forward(request, response);
  }
}