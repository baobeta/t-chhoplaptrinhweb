<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<!-- BEGIN FOOTER -->
<div id="footer" class="footer">
    <div class="container">
        <div class="row">
            <!-- BEGIN COPYRIGHT -->
            <div class="col-md-6 col-sm-6 padding-top-10">
                ©Group13. ALL Rights Reserved.
            </div>
            <!-- END COPYRIGHT -->
            <!-- BEGIN PAYMENTS -->
            <div class="col-md-6 col-sm-6">
                <ul class="list-unstyled list-inline pull-right">
                    <li><img
                            src="<c:url value='/static/assets/frontend/layout/img/payments/western-union.jpg'/>"
                            alt="We accept Western Union" title="We accept Western Union"></li>
                    <li><img
                            src="<c:url value='/static/assets/frontend/layout/img/payments/american-express.jpg'/>"
                            alt="We accept American Express" title="We accept American Express">
                    </li>
                    <li><img
                            src="<c:url value='/static/assets/frontend/layout/img/payments/MasterCard.jpg'/>"
                            alt="We accept MasterCard" title="We accept MasterCard"></li>
                    <li><img
                            src="<c:url value='/static/assets/frontend/layout/img/payments/PayPal.jpg'/>"
                            alt="We accept PayPal" title="We accept PayPal"></li>
                    <li><img
                            src="<c:url value='/static/assets/frontend/layout/img/payments/visa.jpg'/>"
                            alt="We accept Visa" title="We accept Visa"></li>
                </ul>
            </div>
            <!-- END PAYMENTS -->
        </div>
    </div>
</div>
<!-- END FOOTER -->
