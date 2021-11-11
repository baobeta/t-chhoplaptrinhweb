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
    CategoryCommand categoryCommand = FormUtil.populate(CategoryCommand.class, request);
    BrandCommand brandCommand = FormUtil.populate(BrandCommand.class, request);
    ProductCommand productCommand = FormUtil.populate(ProductCommand.class, request);
    setCommandAttribute(categoryCommand, brandCommand, productCommand, request);

    RequestDispatcher dispatcher //
        = this.getServletContext().getRequestDispatcher("/views/web/baseweb/home.jsp");
    dispatcher.forward(request, response);
  }


  void setCommandAttribute(CategoryCommand categoryCommand, BrandCommand brandCommand,
      ProductCommand productCommand,
      HttpServletRequest request) {
    categoryCommand.setListResult(STServiceUtil.getCategoryService().getAllCategory());
    categoryCommand.setBrandInCate(buildBrandInCate(categoryCommand));
    productCommand.setListResult(STServiceUtil.getProductService().getAllProduct());
    brandCommand.setListResult(STServiceUtil.getBrandService().getAllBrand());
    request.setAttribute("cateItems", categoryCommand);
    request.setAttribute("brandItems", brandCommand);
    request.setAttribute("productItems", productCommand);
  }

  Map<CategoryDTO, List<BrandDTO>> buildBrandInCate(CategoryCommand command) {
    Map<CategoryDTO, List<BrandDTO>> brandInCate = new HashMap<CategoryDTO, List<BrandDTO>>();
    for (CategoryDTO category : command.getListResult()) {
      brandInCate.put(category,
          STServiceUtil.getCategoryService().getBrandByCate(category.getCategoryId()));
    }
    return brandInCate;
  }
}