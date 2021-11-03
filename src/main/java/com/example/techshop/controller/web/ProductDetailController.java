package com.example.techshop.controller.web;

import com.example.techshop.command.ProductCommand;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.utils.FormUtil;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/pDetail/*")
public class ProductDetailController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ProductCommand productCommand = FormUtil.populate(ProductCommand.class,request);
    productCommand.getPojo();

    RequestDispatcher dispatcher //
        = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productDetail.jsp");
    dispatcher.forward(request, response);
  }
}
