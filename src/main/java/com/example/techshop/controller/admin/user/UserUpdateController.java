package com.example.techshop.controller.admin.user;


import com.example.techshop.command.UserCommand;
import com.example.techshop.dto.RoleDTO;
import com.example.techshop.utils.FormUtil;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.STServiceUtil;
import com.example.techshop.utils.convert.RoleConverter;
import com.example.techshop.utils.convert.UserConverter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user-form")
public class UserUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoleDTO> roles=  STServiceUtil.getRoleService().getRole();
        req.setAttribute("roles",roles);
        UserCommand command = FormUtil.populate(UserCommand.class,req);
        Integer id = Integer.valueOf(req.getParameter("userId"));
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/views/admin/user/user-form.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class,req);
        RoleDTO role = RoleConverter.entity2Dto(STRepoUtil.getRoleRepo().findEqualUnique("name",command.getRole()));
        command.getPojo().setRoleDTO(role);
        STServiceUtil.getUserService().saveUser(command.getPojo());
        resp.sendRedirect("/user");
    }
}
