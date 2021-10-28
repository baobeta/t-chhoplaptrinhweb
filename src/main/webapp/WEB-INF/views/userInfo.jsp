<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 10/27/2021
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Infor</title>
</head>
<body>
<h1>User Infor</h1>
<h1>${sessionScope.loginedUser.toString()}</h1>
</body>
</html>
