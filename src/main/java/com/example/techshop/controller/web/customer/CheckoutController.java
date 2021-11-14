package com.example.techshop.controller.web.customer;

import com.example.techshop.command.OrderDetailCommand;
import com.example.techshop.command.OrderItemCommand;
import com.example.techshop.dto.CartItemDTO;
import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.dto.UserDTO;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    UserDTO cus = (UserDTO) request.getSession().getAttribute("loginedUser");
    List<CartItemDTO> cartItems = new ArrayList<CartItemDTO>();
    Integer cusId = cus != null ? cus.getUserId() : -1;
    if (cusId == -1) {
      cartItems = STServiceUtil.getCartItemService().inCookieCartItems(request);
    } else {
      STServiceUtil.getCartItemService().addCartInCookieToCus(cusId, request, response);
      cartItems = STServiceUtil.getCartItemService().getCartItemsByCusId(cusId);
    }
    request.setAttribute("cartItems", cartItems);
    RequestDispatcher dispatcher //
        = request.getServletContext().getRequestDispatcher("/views/web/customer/checkout.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    OrderDetailCommand order = FormUtil.populate(OrderDetailCommand.class,request);
    STServiceUtil.getOrderItemService().convertCartItemToOrderItem(order);

    response.sendRedirect("/home");
  }
}
