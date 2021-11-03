<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 10/27/2021
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="pDetail" value="/pDetail/"/>
<html>
<head>
    <title>Title</title>
    <c:forEach items="${products}" var="pItem">
        <form action="${pDetail}+${pItem.productId}">
        <h2>${pItem.name}</h2>
            <input type="hidden" name="productId" value="${pItem.productId}">
            <input type="submit" value="Xem san pham">
        </form>
    </c:forEach>
</head>
<body>
<h1>Home Page</h1>
</body>
</html>
