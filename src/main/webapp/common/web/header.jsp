<c:url var="home" value="/home"/>
<c:url var="login" value="/login"/>
<c:url var="logout" value="/logout"/>
<c:url var="search" value="/search"/>
<c:url var="cart" value="/cart"/>
<c:url var="register" value="/register"/>

<div class="pre-header">
    <div class="container">
        <div class="row">
            <!-- BEGIN TOP BAR LEFT PART -->
            <div class="col-md-6 col-sm-6 additional-shop-info">
                <ul class="list-unstyled list-inline">
                    <li><i class="fa fa-phone"></i><span>0918975776</span></li>
                    <li><i class="fa fa-envelope-o"></i><span>techshopservlet@gmail.com</span></li>
                    <!-- END LANGS -->
                </ul>
            </div>
            <!-- END TOP BAR LEFT PART -->
            <!-- BEGIN TOP BAR MENU -->
            <div class="col-md-6 col-sm-6 additional-nav">
                <ul class="list-unstyled list-inline pull-right">

                    <c:if test="${sessionScope.loginedUser != null}">
                        <li><a href="#">${sessionScope.loginedUser.lastName}</a></li>
                        <li><a href="${logout}"><fmt:message key="logout" bundle="${lang}"/></a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.loginedUser == null}">
                        <li><a href="${register}"><fmt:message key="register" bundle="${lang}"/></a>
                        </li>
                        <li><a href="${login}"><fmt:message key="login" bundle="${lang}"/> </a></li>
                    </c:if>
                </ul>
            </div>
            <!-- END TOP BAR MENU -->
        </div>
    </div>
</div>
<!-- END TOP BAR -->

<!-- BEGIN HEADER -->
<div class="header">
    <div class="container">
        <a class="site-logo" href="${home}"><img
                src="<c:url value='/static/assets/frontend/layout/img/logos/logo-shop-red.png'/>"
                alt="Metronic Shop UI"></a>

        <!-- BEGIN CART -->
        <div class="top-cart-block">
            <div class="top-cart-info">
                <a href="${cart}" class="top-cart-info-count">${applicationScope.pQuantity}
                    <fmt:message key="product" bundle="${lang}"/></a>
            </div>
            <a class="fa fa-shopping-cart" href="${cart}"></a>
        </div>
        <!--END CART -->

        <!-- BEGIN NAVIGATION -->
        <div class="header-navigation">
            <ul>
                <!-- BEGIN TOP SEARCH -->
                <li class="menu-search">
                    <span class="sep"></span>
                    <i class="fa fa-search search-btn"></i>
                    <div class="search-box">
                        <form action="${search}">
                            <div class="input-group">
                                <input type="text" placeholder="Search" class="form-control">
                                <span class="input-group-btn">
                      <button class="btn btn-primary" type="submit">Search</button>
                    </span>
                            </div>
                        </form>
                    </div>
                </li>
                <!-- END TOP SEARCH -->
            </ul>
        </div>
        <!-- END NAVIGATION -->
    </div>
</div>
<!-- Header END -->