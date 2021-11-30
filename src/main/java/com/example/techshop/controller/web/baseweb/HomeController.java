package com.example.techshop.controller.web.baseweb;

import com.example.techshop.command.BrandCommand;
import com.example.techshop.command.CategoryCommand;
import com.example.techshop.command.ProductCommand;
import com.example.techshop.dao.repository.CartItemRepo;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.entity.RoleEntity;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    try {
      CategoryCommand categoryCommand = FormUtil.populate(CategoryCommand.class, request);
      ProductCommand productCommand = FormUtil.populate(ProductCommand.class, request);
      setCommandAttribute(categoryCommand, productCommand, request);

      RequestDispatcher dispatcher //
          = this.getServletContext().getRequestDispatcher("/views/web/baseweb/home.jsp");
      dispatcher.forward(request, response);
    }catch (Exception e){
      response.sendRedirect("/error");
    }
  }

  void setCommandAttribute(CategoryCommand categoryCommand,
      ProductCommand productCommand,
      HttpServletRequest request) {
    categoryCommand.setListResult(STServiceUtil.getCategoryService().getAllCategory());
    categoryCommand.setBrandInCate(
        STServiceUtil.getCategoryService().buildBrandInCate(categoryCommand.getListResult()));
    productCommand.setNewProducts(STServiceUtil.getProductService().getNewProducts());
    productCommand.setIsSaleProducts(STServiceUtil.getProductService().getIsSaleProducts());
    request.setAttribute("cateItems", categoryCommand);
    request.setAttribute("productItems", productCommand);
  }


}