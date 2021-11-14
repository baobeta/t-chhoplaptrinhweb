<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
    <!-- BEGIN PAGE HEAD -->
    <div class="page-head">
        <div class="container">
            <!-- BEGIN PAGE TITLE -->
            <div class="page-title">
                <h1>Manage category <small>Category listing</small></h1>
            </div>
            <!-- END PAGE TITLE -->
        </div>
    </div>
    <!-- END PAGE HEAD -->
    <!-- BEGIN PAGE CONTENT -->
    <div class="page-content">
        <div class="container">
            <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
            <ul class="page-breadcrumb breadcrumb">
                <li>
                    <a href="#">Home</a><i class="fa fa-circle"></i>
                </li>
                <li>
                    <a href="ecommerce_products.html">Features</a>
                    <i class="fa fa-circle"></i>
                </li>
                <li class="active">
                    Manage Category
                </li>
            </ul>
            <!-- END PAGE BREADCRUMB -->
            <c:if test="${message != null}">
                <div class="alert alert-success text-center">
                    <c:out value="${message}"></c:out>
                </div>
            </c:if>
            <!-- BEGIN PAGE CONTENT INNER -->
            <div class="row">
                <div class="col-md-12">
                    <!-- Begin: life time stats -->
                    <div class="portlet light">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-gift font-green-sharp"></i>
                                <span class="caption-subject font-green-sharp bold uppercase">Category</span>
                                <span class="caption-helper">manage category...</span>
                            </div>
                            <div class="col-md-6">
                                <div class="btn-group">
                                    <a class="btn green"href="<c:url value='/admin/category/edit'/>">Thêm loại hàng</a>
                                </div>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="table-container">
                                <table class="table table-striped table-bordered table-hover" id="datatable_products">
                                    <thead>
                                    <tr role="row" class="heading">
                                        <th width="20%">
                                            ID
                                        </th>
                                        <th width="50%">
                                            Category name
                                        </th>
                                        <th width="30%">
                                            Description
                                        </th>

                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="category" items="${categorys}">
                                        <tr>
                                            <td>${category.categoryId}</td>
                                            <td>${category.name}</td>
                                            <td>${category.description}</td>
                                            <td>
                                                <c:url value="/admin/category/edit" var="updateURL">
                                                    <c:param name="categoryId" value="${category.categoryId}"/>
                                                    <c:param name="page" value="1"/>
                                                </c:url>
                                                <a class="btn green" href="${updateURL}">Sửa</a>
                                                <form action="<c:url value="/admin/category/delete"/>" method="post">
                                                    <input type="hidden" name="idDelete" value="${category.categoryId}"/>
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
                    <!-- End: life time stats -->
                </div>
            </div>
            <div style="text-align: center;">
                <nav aria-label="...">
                    <ul class="pagination justify-content-center=">

                        <li class="page-item ">
                            <c:url var="urlPageBegin" value="/admin/category">
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
                                    <c:url var="urlPage" value="/admin/category">
                                        <c:param name="page" value="${i}"/>
                                    </c:url>
                                    <a class="page-link" href="${urlPage}">${i}</a>
                                </li>
                            </c:if>
                        </c:forEach>
                        <li class="page-item">
                            <c:url var="urlPageEnd" value="/admin/category">
                                <c:param name="page" value="${(pojo.page+1)> pojo.totalItems ? pojo.totalItems : (pojo.page+1) }"/>
                            </c:url>
                            <a class="page-link" href="${urlPageEnd}">Next</a>
                        </li>

                    </ul>
                </nav>
            </div>
            <!-- END PAGE CONTENT INNER -->
        </div>
    </div>
    <!-- END PAGE CONTENT -->
</div>
<!-- END PAGE CONTAINER -->