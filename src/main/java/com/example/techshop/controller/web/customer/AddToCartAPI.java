package com.example.techshop.controller.web.customer;

import com.example.techshop.common.CoreConstant;
import com.example.techshop.utils.STServiceUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/add-to-cart")
public class AddToCartAPI extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      Integer productId = Integer.parseInt(request.getParameter("productId"));
      Integer cusId = Integer.parseInt(request.getParameter("cusId"));
      if (cusId != -1) {
        STServiceUtil.getCartItemService().addProductToCart(cusId, productId);
      }
    } catch (Exception e) {
      response.sendRedirect("/error");
    }
  }
}
