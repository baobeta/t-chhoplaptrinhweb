package com.example.techshop.controller.admin.user;

import com.example.techshop.command.UserCommand;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STServiceUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user-delete")
public class UserDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class,req);
        if(command.getIdDelete()!=null) {
            List ids = new ArrayList();
            ids.add(command.getIdDelete());
            STServiceUtil.getUserService().deleteUser(ids);
            resp.sendRedirect("/user?message=delSuccess");
        }
        else {
            resp.sendRedirect("/user");
        }

    }
}
