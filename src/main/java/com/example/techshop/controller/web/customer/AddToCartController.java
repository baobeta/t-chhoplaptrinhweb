package com.example.techshop.controller.web.customer;

import com.example.techshop.utils.STServiceUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/add-to-cart")
public class AddToCartController extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Integer productId = Integer.parseInt(req.getParameter("productId"));
    Integer cusId = Integer.parseInt(req.getParameter("cusId"));
    boolean successfulAdding = false;
    if (cusId != -1) {
      successfulAdding = STServiceUtil.getCartItemService().addProductToCart(cusId, productId);
    }
    if (successfulAdding) {
      System.out.println("them thanh cong");
    } else {
      System.out.println("them that bai");
    }
  }
}
