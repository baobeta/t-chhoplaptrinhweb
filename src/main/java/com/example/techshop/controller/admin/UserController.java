package com.example.techshop.controller.admin;

import com.example.techshop.command.UserCommand;
import com.example.techshop.dto.UserDTO;
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

@WebServlet("/user")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class,request);
        List<UserDTO> users = STServiceUtil.getUserService().Pagingnation(command.getPage(), command.getMaxPageItems());
        command.setTotalItems((STServiceUtil.getUserService().CountUser()/ command.getMaxPageItems())+1);

        request.setAttribute("users",users);


        checkMessage(request);
        request.setAttribute("pojo",command);
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfo.jsp");
        dispatcher.forward(request, response);
    }

    public void checkMessage(HttpServletRequest request) {
        String message = request.getParameter("message");
        if(message != null) {
            if(message.trim().equals("addSuccess")) {
                request.setAttribute("message","Thêm thành viên thành công");
            } else if (message.trim().equals("updateSuccess")){
                request.setAttribute("message","Sửa thành viên thành công");
            } else if (message.trim().equals("delSuccess")) {
                request.setAttribute("message","Xóa thành viên thành công");
            }
        }
    }
}
