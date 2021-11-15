package com.example.techshop.controller.web.baseweb;

import com.example.techshop.command.ProductCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/get-product-list")
public class ProductListAPI extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ProductCommand command = FormUtil.populate(ProductCommand.class, request);
    setProperties(request, command);
    Map<String, Object> properties = STServiceUtil.getProductService().searchProperties(command);
    List<ProductDTO> productDTOS = STServiceUtil.getProductService().getProducts(properties);
    String viewURL = "/pDetail?pojo.productId=";
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();
    for (ProductDTO product : productDTOS) {
      out.println("<div class=\"col-md-4 col-sm-6 col-xs-12\" >\n"
          + "                                <div class=\"product-item\">\n"
          + "                                    <div class=\"pi-img-wrapper\">\n"
          + "                                        <img src=\"https://static.acer.com/up/Resource/Acer/Laptops/Nitro_5/Image/20190222/Acer-Nitro-5-AN515-54-main.png\"\n"
          + "                                             class=\"img-responsive\" alt=\"Berry Lace Dress\">\n"
          + "                                        <div>\n"
          + "                                            <a href=\"<c:url value='/static/assets/frontend/pages/img/products/model1.jpg'/>\"\n"
          + "                                               class=\"btn btn-default fancybox-button\">Zoom</a>\n"
          + "                                            <a href=\"" + viewURL
          + product.getProductId() + "\"\n"
          + "                                               class=\"btn btn-default fancybox-fast-view\">View</a>\n"
          + "                                        </div>\n"
          + "                                    </div>\n"
          + "                                    <h3><a href=\"shop-item.html\">"
          + product.getName() + "</a></h3>\n"
          + "                                    <div class=\"pi-price\">" + product.getPrice()
          + "                                         </div>\n"
          + "                                    <a href=\"#\" class=\"btn btn-default add2cart\">Add to cart</a>\n"
          + "                                </div>\n"
          + "                            </div>");
    }
  }

  void setProperties(HttpServletRequest request, ProductCommand command) {
    Integer brandId = Integer.parseInt(request.getParameter("brandId"));
    Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
    String searchName = request.getParameter("searchName");
    String sort = request.getParameter("sort");
    if (brandId > 0 && brandId!=null) {
      command.setBrand(STServiceUtil.getBrandService().findById(brandId));
    }
    if (categoryId > 0 && categoryId!=null) {
      command.setCategory(STServiceUtil.getCategoryService().findById(categoryId));
    }
    if (!searchName.isEmpty() && searchName != null) {
      command.setSearchName(searchName);
    }
    if (!sort.isEmpty() && sort != null) {
      command.setSort(sort);
    }
  }
}
