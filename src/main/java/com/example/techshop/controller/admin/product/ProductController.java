package com.example.techshop.controller.admin.product;

import com.example.techshop.dto.ProductDTO;
import com.example.techshop.dto.UserDTO;
import com.example.techshop.utils.STServiceUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/product")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ProductDTO> listProduct = STServiceUtil.getProductService().getAllProduct();
        request.setAttribute("products",listProduct);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/views/admin/product/productManager.jsp");
        dispatcher.forward(request, response);
    }
}
