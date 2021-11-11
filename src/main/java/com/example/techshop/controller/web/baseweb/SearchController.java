package com.example.techshop.controller.web.baseweb;


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
    ProductCommand productCommand = FormUtil.populate(ProductCommand.class,request);
    productCommand.setListResult(STServiceUtil.getProductService().getSomeFirstProducts());
    request.setAttribute("productItems", productCommand);

    RequestDispatcher dispatcher //
        = request.getServletContext().getRequestDispatcher("/views/web/baseweb/searchResult.jsp");
    dispatcher.forward(request, response);
  }
}
