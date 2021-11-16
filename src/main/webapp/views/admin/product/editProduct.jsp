<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>


<c:url var="addProduct" value="/admin/product/edit"/>
<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
    <!-- BEGIN PAGE HEAD -->
    <div class="page-head">
        <div class="container">
            <!-- BEGIN PAGE TITLE -->
            <div class="page-title">
                <h1>Product Edit <small>create & edit product</small></h1>
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
                                                <c:if test="${product != null}">
                                                    <form action="<c:url value="/admin/product/edit" />" method="post" style="max-width: 800px; margin: 0 auto">
                                                       <input type="hidden" value="${product.productId}" name="pojo.productId">
                                                        <div class="form-group margin-bottom-10">
                                                            <label class="col-md-2 control-label">Name:
                                                                <span class="required">* </span>
                                                            </label>
                                                            <div class="col-md-10">
                                                                <input type="text" value="${product.name}" class="form-control" name="pojo.name" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group margin-bottom-10">
                                                            <label class="col-md-2 control-label">Description: <span class="required">
													* </span>
                                                            </label>
                                                            <div class="col-md-10">
                                                                <input class="form-control" value="${product.description}" name="pojo.description">
                                                            </div>
                                                        </div>
                                                        <div class="form-group margin-bottom-10">
                                                            <label class="col-md-2 control-label">Price
                                                                <span class="required"> * </span></label>
                                                            <div class="col-md-10">
                                                                <input type="text" class="form-control" value="${product.price}" name="pojo.price" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group margin-bottom-10">
                                                            <label class="col-md-2 control-label">Quantity: <span class="required">* </span></label>
                                                            <div class="col-md-10">
                                                                <input type="text" class="form-control" value="${product.quantity}" name="pojo.quantity" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group margin-bottom-10">
                                                            <label class="col-md-2 control-label">Photo: </label>
                                                            <div class="col-md-10">
                                                                <div>
                                                                    <input type="file" id="file" accept=".jpg, .png">
                                                                    <progress id="progress_bar" value="0" max="100"></progress>
                                                                </div>
                                                                <div>
                                                                    <img src="${product.photo}"  alt="" id="image" style="width:300px;height:400px;">
                                                                    <input type="hidden" name="pojo.photo" id="pathImage" value=""/>
                                                                    <script src="<c:url value='/static/uploadImageUserFirebase.js'/>" type="text/javascript"></script>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group margin-bottom-10">
                                                            <label class="col-md-2 control-label">Category: <span class="required">
													* </span>
                                                            </label>
                                                            <div class="col-md-10 ">
                                                                <select class="table-group-action-input form-control input-medium" name="categoryDTO">
                                                                    <c:forEach var="category" items="${categorys}">
                                                                        <c:if test="${product.categoryDTO.categoryId == category.categoryId}">
                                                                            <option  selected value="${category.categoryId}">${category.name}</option>
                                                                        </c:if>
                                                                        <c:if test="${product.categoryDTO.categoryId != category.categoryId}">
                                                                            <option value="${category.categoryId}" >${category.name}</option>
                                                                        </c:if>
                                                                    </c:forEach>

                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group margin-bottom-10">
                                                            <label class="col-md-2 control-label">Brand: <span class="required">
													* </span>
                                                            </label>
                                                            <div class="col-md-10">
                                                                <select class="table-group-action-input form-control input-medium" name="brandDTO">
                                                                    <c:forEach var="brand" items="${brands}">
                                                                        <c:if test="${product.brandDTO.brandId == brand.brandId}">
                                                                            <option selected value="${brand.brandId}" >${brand.name}</option>
                                                                        </c:if>
                                                                        <c:if test="${product.brandDTO.brandId != brand.brandId}">
                                                                            <option value="${brand.brandId}" >${brand.name}</option>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="text-center m-3">
                                                            <input type="submit" value="Save" class="btn btn-primary m-3"/>
                                                            <input type="button" value="Cancel" class="btn btn-secondary" id="buttonCancel"/>
                                                        </div>
                                                    </form>
                                                </c:if>
                                                <c:if test="${product == null}">
                                                    <form action="${addProduct}" method="post" style="max-width: 800px; margin: 0 auto">
                                                        <div class="form-group">
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
                                                            <div class="col-md-10">
                                                                <input class="form-control" name="pojo.description">
                                                            </div>
                                                        </div>
                                                        <div class="form-group margin-bottom-10">
                                                            <label class="col-md-2 control-label">Price
                                                                <span class="required"> * </span></label>
                                                            <div class="col-md-10">
                                                                <input type="text" class="form-control" name="pojo.price" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group margin-bottom-10">
                                                            <label class="col-md-2 control-label">Quantity: <span class="required">* </span></label>
                                                            <div class="col-md-10">
                                                                <input type="text" class="form-control" name="pojo.quantity" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group margin-bottom-10">
                                                            <label class="col-md-2 control-label">Photo: </label>
                                                            <div class="col-md-10">
                                                                <div>
                                                                    <input type="file" id="file" accept=".jpg, .png">
                                                                    <progress id="progress_bar" value="0" max="100"></progress>
                                                                </div>
                                                                <div>
                                                                    <img src=""  alt="" id="image" style="width:300px;height:400px;">
                                                                    <input type="hidden" name="pojo.photo" id="pathImage" value=""/>
                                                                    <script src="<c:url value='/static/uploadImageUserFirebase.js'/>" type="text/javascript"></script>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group margin-bottom-10">
                                                            <label class="col-md-2 control-label">Category: <span class="required">
													* </span>
                                                            </label>
                                                            <div class="col-md-10">
                                                                <select class="table-group-action-input form-control input-medium" name="categoryDTO">
                                                                    <c:forEach var="category" items="${categorys}">
                                                                            <option value="${category.categoryId}" >${category.name}</option>
                                                                    </c:forEach>

                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-md-2 control-label">Brand: <span class="required">
													* </span>
                                                            </label>
                                                            <div class="col-md-10">
                                                                <select class="table-group-action-input form-control input-medium" name="brandDTO">
                                                                    <c:forEach var="brand" items="${brands}">
                                                                            <option value="${brand.brandId}" >${brand.name}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                            <div class="text-center m-3">
                                                                <input type="submit" value="Save" class="btn btn-primary m-3"/>
                                                                <input type="button" value="Cancel" class="btn btn-secondary" id="buttonCancel"/>
                                                            </div>
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