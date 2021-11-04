<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Infor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>
<body>
<h1>User Infor</h1>
<h1>${sessionScope.loginedUser.toString()}</h1>

<c:if test="${message != null}">
    <div class="alert alert-success text-center">
        <c:out value="${message}"></c:out>
    </div>
</c:if>

<div class="container">
    <h2>Hover Rows</h2>
    <p>The .table-hover class enables a hover state on table rows:</p>
    <a class="btn btn-primary"href="<c:url value='/user-form'/>">Thêm User</a>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Email</th>
            <th>Password</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Photo</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td><img src="${user.photos}"  alt="" id="image" style="width:200px;height:300px;"></td>
                <td>${user.roleDTO}</td>
                <td>
                    <c:url value="/user-form" var="updateURL">
                        <c:param name="userId" value="${user.userId}"/>
                        <c:param name="page" value="1"/>
                    </c:url>
                    <a class="btn btn-secondary" href="${updateURL}">Sửa</a>
                    <form action="<c:url value="/user-delete"/>" method="post">
                        <input type="hidden" name="idDelete" value="${user.userId}"/>
                        <button type="submit" class="btn btn-primary">Xóa</button>
                    </form>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<div>
    <nav aria-label="...">
        <ul class="pagination justify-content-center flex-wrap">

            <li class="page-item disabled">
                <c:url var="urlPageBegin" value="/admin/user">
                    <c:param name="page" value="${(pojo.page-1) < 1 ? 1 : (pojo.page-1) }"/>
                </c:url>
                <a class="page-link" href="${urlPageBegin}" tabindex="-1">Previous</a>
            </li>
            <c:forEach var = "i" begin = "1" end = "${pojo.totalItems}">
                <c:if test="${i==pojo.page}">
                    <li class="page-item active">
                        <a class="page-link" href="${i==pojo.page}">${i} <span class="sr-only"></span></a>
                    </li>
                </c:if>
                <c:if test="${i!=pojo.page}">
                    <li class="page-item">
                        <c:url var="urlPage" value="/admin/user">
                            <c:param name="page" value="${i}"/>
                        </c:url>
                        <a class="page-link" href="${urlPage}">${i}</a>
                    </li>
                </c:if>
            </c:forEach>
            <li class="page-item">
                <c:url var="urlPageEnd" value="/admin/user">
                    <c:param name="page" value="${(pojo.page+1)> pojo.totalItems ? pojo.totalItems : (pojo.page+1) }"/>
                </c:url>
                <a class="page-link" href="${urlPageEnd}">Next</a>
            </li>

        </ul>
    </nav>
</div>

</body>
</html>
