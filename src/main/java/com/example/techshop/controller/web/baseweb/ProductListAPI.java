package com.example.techshop.controller.web.baseweb;

import com.example.techshop.command.ProductCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.dto.ProductDTO;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
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

    try {
      ProductCommand command = FormUtil.populate(ProductCommand.class, request);
      setProperties(request, command);
      Map<String, Object> properties = STServiceUtil.getProductService().searchProperties(command);
      List<ProductDTO> productDTOS = (List<ProductDTO>) STServiceUtil.getProductService().getProducts(properties)[0];
      String viewURL = "/pDetail?pojo.productId=";
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();

      for (ProductDTO product : productDTOS) {
        out.println("<div class=\"col-md-4 col-sm-6 col-xs-12\">\n"
            + "                                <div class=\"product-item\">\n"
            + "                                    <div class=\"pi-img-wrapper\">\n"
            + "                                        <img src=\"" + product.getPhoto() + "\"\n"
            + "                                             style=\"height: 165px;margin-left: auto;margin-right: auto;\"\n"
            + "                                             class=\"img-responsive\" alt=\"Berry Lace Dress\">\n"
            + "                                        <div>\n"
            + "                                            <a href=\"" + product.getPhoto() + "\"\n"
            + "                                               class=\"btn btn-default fancybox-button\">Zoom</a>\n"
            + "                                            <a href=\"" + viewURL
            + product.getProductId() + "\"\n"
            + "                                               class=\"btn btn-default fancybox-fast-view\">"
            + "Xem" + "</a>\n"
            + "                                        </div>\n"
            + "                                    </div>\n"
            + "                                    <h3><a href=\"shop-item.html\">"
            + product.getName() + "</a></h3>\n"
            + "\n"
            + "                                    <div class=\"pi-price\">" + formatCurrency(
            product.getPrice()) + "\n"
            + "                                    </div>\n");
        if (product.isSale()) {
          out.println("<div class=\"sticker sticker-sale\"></div>");
        }
        out.println("                                </div>\n"
            + "                            </div>");

      }
    }catch (Exception e) {
      response.sendRedirect("/error");
    }
  }
  void setProperties(HttpServletRequest request, ProductCommand command) {
    Integer brandId = Integer.parseInt(request.getParameter("brandId"));
    Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
    String searchName = request.getParameter("searchName");
    String sort = request.getParameter("sort");
    if (brandId != null && brandId > 0) {
      command.setBrand(STServiceUtil.getBrandService().findById(brandId));
    }
    if (categoryId != null && categoryId > 0 ) {
      command.setCategory(STServiceUtil.getCategoryService().findById(categoryId));
    }
    if (searchName != null && !searchName.isEmpty()) {
      command.setSearchName(searchName);
    }
    if (sort != null && !sort.isEmpty()) {
      command.setSort(sort);
    }
  }

  public String formatCurrency(Integer price) {
    Locale locale = new Locale("vi", "VN");
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
    numberFormat.setMaximumFractionDigits(0);
    return numberFormat.format(price);
  }

  public int getTotalPages(List<ProductDTO> products, ProductCommand command){
    int totalPages = 0;
    int productsSize = products.size();
    int maxPageItems = command.getMaxPageItems();

    totalPages = productsSize/maxPageItems;
    if(productsSize%maxPageItems!=0){
      totalPages+=1;
    }
    return totalPages;
  }
}
