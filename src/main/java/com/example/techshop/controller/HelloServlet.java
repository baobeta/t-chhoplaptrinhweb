package com.example.techshop.controller;

import com.example.techshop.dao.repository.CartItemRepo;
import com.example.techshop.entity.RoleEntity;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet("/test")
public class HelloServlet extends HttpServlet {

  CartItemRepo cartItemRepo = new CartItemRepo();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
  }
}