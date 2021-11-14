<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="addBrand" value="/admin/brand/edit"/>
<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
    <!-- BEGIN PAGE HEAD -->
    <div class="page-head">
        <div class="container">
            <!-- BEGIN PAGE TITLE -->
            <div class="page-title">
                <h1>Product Edit <small>create & edit brand</small></h1>
            </div>
        </div>
    </div>
    <!-- END PAGE HEAD -->
    <!-- BEGIN PAGE CONTENT -->
    <div class="page-content">
        <div class="container">
            <ul class="page-breadcrumb breadcrumb">
                <li>
                    <a href="<c:url value="/admin"/>">Home</a><i class="fa fa-circle"></i>
                </li>
                <li class="active">
                    Product Edit
                </li>
            </ul>
            <!-- END PAGE BREADCRUMB -->
            <!-- BEGIN PAGE CONTENT INNER -->
            <div class="row">
                <div class="col-md-12">
                    <div class="portlet light">
                        <div class="portlet-body">
                            <div class="tabbable">
                                <div class="tab-content no-space">
                                    <div class="tab-pane active" id="tab_general">
                                        <div class="form-body">
                                            <c:if test="${brand != null}">
                                                <form action="<c:url value="/admin/brand/edit" />" method="post" style="max-width: 800px; margin: 0 auto">
                                                    <input type="hidden" value="${brand.brandId}" name="pojo.brandId">
                                                    <div class="form-group margin-bottom-10">
                                                        <label class="col-md-2 control-label">Name:
                                                            <span class="required">* </span>
                                                        </label>
                                                        <div class="col-md-10">
                                                            <input type="text" value="${brand.name}" class="form-control" name="pojo.name" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="form-group margin-bottom-10">
                                                        <label class="col-md-2 control-label">Description: <span class="required">
													* </span>
                                                        </label>
                                                        <div class="col-md-10">
                                                            <input class="form-control" value="${brand.description}" name="pojo.description">
                                                        </div>
                                                    </div>
                                                    <div class="text-center m-3">
                                                        <input type="submit" value="Save" class="btn btn-primary m-3"/>
                                                        <input type="button" value="Cancel" class="btn btn-secondary" id="buttonCancel"/>
                                                    </div>
                                                </form>
                                            </c:if>
                                            <c:if test="${brand == null}">
                                                <form action="${addBrand}" method="post" style="max-width: 800px; margin: 0 auto">
                                                    <div class="form-group margin-bottom-10">
                                                        <label class="col-md-2 control-label">Name:
                                                            <span class="required">* </span>
                                                        </label>
                                                        <div class="col-md-10 margin-bottom-10">
                                                            <input type="text" class="form-control" name="pojo.name" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="form-group margin-bottom-10">
                                                        <label class="col-md-2 control-label">Description: <span class="required">
													* </span>
                                                        </label>
                                                        <div class="col-md-10 ">
                                                            <input class="form-control" name="pojo.description">
                                                        </div>
                                                    </div>
                                                        <div class="form-group margin-bottom-10 margin-top-10 text-center ">
                                                            <input type="submit" value="Save" class="btn btn-primary margin-top-10"/>
                                                            <input type="button" value="Cancel" class="btn btn-secondary margin-top-10" id="buttonCancel"/>
                                                        </div>
                                                </form>

                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END PAGE CONTENT INNER -->
        </div>
    </div>
    <!-- END PAGE CONTENT -->
</div>
<!-- END PAGE CONTAINER -->