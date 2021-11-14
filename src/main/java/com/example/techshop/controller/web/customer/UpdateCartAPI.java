package com.example.techshop.controller.web.customer;

import com.example.techshop.utils.STServiceUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/update-cart")
public class UpdateCartAPI extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Integer cusId = Integer.parseInt(request.getParameter("cusId"));
    Integer productId = Integer.parseInt(request.getParameter("productId"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    STServiceUtil.getCartItemService().updateCartItem(cusId,productId,quantity);
  }
}
