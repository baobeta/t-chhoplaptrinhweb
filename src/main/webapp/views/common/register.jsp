<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url value="/login" var="login"/>
<c:url value="/register" var="register"/>
<div class="main">
    <div class="container">
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <!-- BEGIN SIDEBAR -->
            <div class="sidebar col-md-3 col-sm-3">
                <ul class="list-group margin-bottom-25 sidebar-menu">
                    <li class="list-group-item clearfix"><a href="${login}"><i
                            class="fa fa-angle-right"></i><fmt:message key="login"
                                                                       bundle="${lang}"/> </a></li>
                </ul>
            </div>
            <!-- END SIDEBAR -->

            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-9">
                <h1><fmt:message
                        key="createAccount" bundle="${lang}"/></h1>
                <div class="content-form-page">
                    <div class="row">
                        <div class="col-md-7 col-sm-7">
                            <form action="${register}" method="post" class="form-horizontal" role="form">
                                <fieldset>
                                    <legend>THÔNG TIN CÁ NHÂN</legend>
                                    <!--HO -->
                                    <div class="form-group">
                                        <label for="firstname"
                                               class="col-lg-4 control-label"><fmt:message
                                                key="firstName" bundle="${lang}"/> <span
                                                class="require">*</span></label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" id="firstname" name="pojo.firstName"
                                                   required>
                                        </div>
                                    </div>
                                    <!--TEN-->
                                    <div class="form-group">
                                        <label for="lastname"
                                               class="col-lg-4 control-label"><fmt:message
                                                key="lastName" bundle="${lang}"/><span
                                                class="require">*</span></label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" id="lastname" name="pojo.lastName"
                                                   required>
                                        </div>
                                    </div>
                                    <!--EMAIL -->
                                    <div class="form-group">
                                        <label for="email" class="col-lg-4 control-label">EMAIL
                                            <span class="require">*</span></label>
                                        <div class="col-lg-8">
                                            <input type="email" class="form-control" id="email" name="pojo.email"
                                                   required>
                                        </div>
                                    </div>
                                </fieldset>
                                <fieldset>
                                    <legend>MẬT KHẨU CỦA BẠN</legend>
                                    <!--PASSWORD -->
                                    <div class="form-group">
                                        <label for="pass"
                                               class="col-lg-4 control-label"><fmt:message
                                                key="password" bundle="${lang}"/>
                                            <span class="require"></span></label>
                                        <div class="col-lg-8">
                                            <input type="password" class="form-control" name="pojo.password"
                                                   id="pass" required>
                                        </div>
                                    </div>
                                    <!--RE PASSWORD-->
                                    <div class="form-group">
                                        <label for="re_pass"
                                               class="col-lg-4 control-label"><fmt:message
                                                key="rePassWord" bundle="${lang}"/><span
                                                class="require" id="check_matching"></span></label>
                                        <div class="col-lg-8">
                                            <input type="password" class="form-control"
                                                   id="re_pass" required>
                                        </div>
                                    </div>
                                </fieldset>
                                <div class="row">
                                    <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                                        <button type="submit" class="btn btn-primary" id="signup">
                                            <fmt:message
                                                    key="createAccount" bundle="${lang}"/>
                                        </button>
                                        <button type="button" class="btn btn-default"><fmt:message
                                                key="cancel" bundle="${lang}"/>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="col-md-4 col-sm-4 pull-right">
                            <div class="form-info">
                                <h2><em>Important</em> Information</h2>
                                <p>Lập Trình WEB</p>
                                <p>LOVE Cô MAI ANH THER</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>