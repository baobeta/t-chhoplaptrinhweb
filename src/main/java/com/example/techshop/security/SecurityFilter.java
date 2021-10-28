package com.example.techshop.security;

import com.example.techshop.dto.UserDTO;
import com.example.techshop.utils.AppUtils;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.Filter;

@WebFilter("/*")
public class SecurityFilter implements Filter {
  public SecurityFilter() {
  }

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) resp;

    String servletPath = request.getServletPath();

    // Thông tin người dùng đã được lưu trong Session
    // (Sau khi đăng nhập thành công).
    UserDTO loginedUser = AppUtils.getLoginedUser(request.getSession());

    if (servletPath.equals("/login")) {
      chain.doFilter(request, response);
      return;
    }

    HttpServletRequest wrapRequest = request;

    if (loginedUser != null) {
      // User Name
      String userName = loginedUser.getEmail();

      // Các vai trò (Role).
      List<String> roles = Collections.singletonList(loginedUser.getRoleDTO().getName());

      // Gói request cũ bởi một Request mới với các thông tin userName và Roles.
      wrapRequest = (HttpServletRequest) new UserRoleRequestWrapper(userName, roles, request);
    }

    // Các trang bắt buộc phải đăng nhập.
    if (SecurityUtils.isSecurityPage(request)) {

      // Nếu người dùng chưa đăng nhập,
      // Redirect (chuyển hướng) tới trang đăng nhập.
      if (loginedUser == null) {

        String requestUri = request.getRequestURI();

        // Lưu trữ trang hiện tại để redirect đến sau khi đăng nhập thành công.
        int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);

        response.sendRedirect( "/login?redirectId=" + redirectId);
        return;
      }

      // Kiểm tra người dùng có vai trò hợp lệ hay không?
      boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
      if (!hasPermission) {

        RequestDispatcher dispatcher //
            = request.getServletContext().getRequestDispatcher("/WEB-INF/views/accessDeniedView.jsp");
        dispatcher.forward(request, response);
        return;
      }
    }

    chain.doFilter(wrapRequest, response);
  }

  @Override
  public void init(FilterConfig fConfig) throws ServletException {

  }

}
