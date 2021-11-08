<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
  <!-- BEGIN PAGE HEAD -->
  <div class="page-head">
    <div class="container">
      <!-- BEGIN PAGE TITLE -->
      <div class="page-title">
        <h1>Managed User <small>managed user</small></h1>
      </div>
    </div>
  </div>
  <!-- END PAGE HEAD -->
  <!-- BEGIN PAGE CONTENT -->
  <div class="page-content">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <!-- BEGIN EXAMPLE TABLE PORTLET-->
          <div class="portlet light">
            <div class="portlet-title">
              <div class="caption">
                <i class="fa fa-cogs font-green-sharp"></i>
                <span class="caption-subject font-green-sharp bold uppercase">Managed Table</span>
              </div>
              <div class="tools">
                <a href="javascript:;" class="collapse">
                </a>
                </a>
              </div>
            </div>

            <c:if test="${message != null}">
              <div class="alert alert-success text-center">
                <c:out value="${message}"></c:out>
              </div>
            </c:if>

            <div class="portlet-body">
              <div class="table-toolbar">
                <div class="row">
                  <div class="col-md-6">
                    <div class="btn-group">
                      <a class="btn green"href="<c:url value='/admin/user/edit'/>">Thêm User</a>
                    </div>
                  </div>
              </div>
              <table class="table table-striped table-bordered table-hover" id="sample_1">
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
                      <a class="btn green" href="${updateURL}">Sửa</a>
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
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<div style="text-align: center;">
  <nav aria-label="...">
    <ul class="pagination justify-content-center=">

      <li class="page-item ">
        <c:url var="urlPageBegin" value="/admin/user">
          <c:param name="page" value="${(pojo.page-1) < 1 ? 1 : (pojo.page-1) }"/>
        </c:url>
        <a class="page-link" href="${urlPageBegin}">Previous</a>
      </li>
      <c:forEach var = "i" begin = "1" end = "${pojo.totalItems}">
        <c:if test="${i==pojo.page}">
          <li class="page-item active">
            <a class="page-link" href="${i==pojo.page}" >${i} <span class="sr-only"></span></a>
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