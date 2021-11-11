package com.example.techshop.controller.web.baseweb;

import com.example.techshop.dto.ProductDTO;
import com.example.techshop.utils.STServiceUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
    int firstIndex = Integer.parseInt(request.getParameter("firstIndex"));
    int page = Integer.parseInt(request.getParameter("page"));
    List<ProductDTO> productDTOS = STServiceUtil.getProductService().getProducts(firstIndex);

    String viewURL ="/pDetail?pojo.productId=";
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
          + "                                            <a href=\""+viewURL+product.getProductId()+"\"\n"
          + "                                               class=\"btn btn-default fancybox-fast-view\">View</a>\n"
          + "                                        </div>\n"
          + "                                    </div>\n"
          + "                                    <h3><a href=\"shop-item.html\">"
          +                                           product.getName() + "</a></h3>\n"
          + "                                    <div class=\"pi-price\">" + product.getPrice()
          + "                                         </div>\n"
          + "                                    <a href=\"#\" class=\"btn btn-default add2cart\">Add to cart</a>\n"
          + "                                </div>\n"
          + "                            </div>");
    }
  }
}
