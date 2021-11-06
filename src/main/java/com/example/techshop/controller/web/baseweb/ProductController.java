package com.example.techshop.controller.web.baseweb;

import com.example.techshop.command.BrandCommand;
import com.example.techshop.command.CategoryCommand;
import com.example.techshop.command.ProductCommand;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product-list")
public class ProductController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    CategoryCommand categoryCommand = FormUtil.populate(CategoryCommand.class,request);
    BrandCommand brandCommand = FormUtil.populate(BrandCommand.class,request);
    ProductCommand productCommand = FormUtil.populate(ProductCommand.class,request);
    setCommandAttribute(categoryCommand, brandCommand, productCommand, request);

    RequestDispatcher dispatcher //
        = request.getServletContext().getRequestDispatcher("/views/web/baseweb/productList.jsp");
    dispatcher.forward(request, response);
  }

  void setCommandAttribute(CategoryCommand categoryCommand, BrandCommand brandCommand,
      ProductCommand productCommand,
      HttpServletRequest request) {
    categoryCommand.setListResult(STServiceUtil.getCategoryService().getAllCategory());
    productCommand.setListResult(STServiceUtil.getProductService().getSomeFirstProducts());
    brandCommand.setListResult(STServiceUtil.getBrandService().getAllBrand());
    request.setAttribute("cateItems", categoryCommand);
    request.setAttribute("brandItems", brandCommand);
    request.setAttribute("productItems", productCommand);
  }

}
