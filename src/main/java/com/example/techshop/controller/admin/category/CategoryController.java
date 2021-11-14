package com.example.techshop.controller.admin.category;


import com.example.techshop.command.BrandCommand;
import com.example.techshop.command.CategoryCommand;
import com.example.techshop.dto.BrandDTO;
import com.example.techshop.dto.CategoryDTO;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/category")
public class CategoryController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryCommand command = FormUtil.populate(CategoryCommand.class,req);
        List<CategoryDTO> listCategory = STServiceUtil.getCategoryService().pagination(command.getPage(), command.getMaxPageItems());
        command.setTotalItems((STServiceUtil.getCategoryService().countCategory()/ command.getMaxPageItems())+1);
        checkMessage(req);
        req.setAttribute("categorys",listCategory);
        req.setAttribute("pojo",command);
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/views/admin/category/categoryManager.jsp");
        dispatcher.forward(req, resp);
    }

    public void checkMessage(HttpServletRequest request) {
        String message = request.getParameter("message");
        if(message != null) {
            if(message.trim().equals("addSuccess")) {
                request.setAttribute("message","Thêm phân loại thành công");
            } else if (message.trim().equals("updateSuccess")){
                request.setAttribute("message","Sửa phân loại thành công");
            } else if (message.trim().equals("delSuccess")) {
                request.setAttribute("message","Xóa phân loại thành công");
            }
        }
    }
}
