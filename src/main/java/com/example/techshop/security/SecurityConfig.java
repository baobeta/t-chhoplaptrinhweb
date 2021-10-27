package com.example.techshop.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {
  public static final String ROLE_ADMIN = "ADMIN";
  public static final String ROLE_CUSTOMER = "CUSTOMER";

  // String: Role
  // List<String>: urlPatterns.
  private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

  static {
    init();
  }

  private static void init() {

    // Cấu hình cho vai trò "EMPLOYEE".
    List<String> adminUrlPattern = new ArrayList<String>();

    adminUrlPattern.add("/admin");
    adminUrlPattern.add("/employeeTask");

    mapConfig.put(ROLE_ADMIN, adminUrlPattern);

    // Cấu hình cho vai trò "MANAGER".
    List<String> cusUrlPattern = new ArrayList<String>();

    cusUrlPattern.add("/home");
    cusUrlPattern.add("/managerTask");

    mapConfig.put(ROLE_CUSTOMER, cusUrlPattern);
  }

  public static Set<String> getAllAppRoles() {
    return mapConfig.keySet();
  }

  public static List<String> getUrlPatternsForRole(String role) {
    return mapConfig.get(role);
  }

}
