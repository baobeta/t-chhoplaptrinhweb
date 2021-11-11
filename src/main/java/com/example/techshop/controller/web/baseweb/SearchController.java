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

@WebServlet("/search")
public class SearchController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    CategoryCommand categoryCommand = FormUtil.populate(CategoryCommand.class, request);
    ProductCommand productCommand = FormUtil.populate(ProductCommand.class, request);
    setCommandAttribute(categoryCommand, productCommand, request);

    RequestDispatcher dispatcher //
        = request.getServletContext().getRequestDispatcher("/views/web/baseweb/searchResult.jsp");
    dispatcher.forward(request, response);
  }

  void setCommandAttribute(CategoryCommand categoryCommand,
      ProductCommand productCommand,
      HttpServletRequest request) {
    categoryCommand.setListResult(STServiceUtil.getCategoryService().getAllCategory());
    categoryCommand.setBrandInCate(
        STServiceUtil.getCategoryService().buildBrandInCate(categoryCommand));

    Integer brandId = productCommand.getBrand().getBrandId();
    Integer categoryId = productCommand.getCategory().getCategoryId();

    productCommand.setListResult(
        STServiceUtil.getProductService()
            .getSomeFirstProducts(brandId, categoryId));
    request.setAttribute("cateItems", categoryCommand);
    request.setAttribute("productItems", productCommand);
  }
}
