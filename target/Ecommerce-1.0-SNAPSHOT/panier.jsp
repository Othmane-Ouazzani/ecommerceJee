<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="models.Produit" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Client" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${ sessionScope.client == null}">
    <c:redirect url="/index"/>
</c:if>
<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<!-- BEGIN: Head-->

<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<!-- BEGIN: Head-->

<%@include file="includes/head.jsp" %>
<!-- END: Head-->

<!-- BEGIN: Body-->

<body class="vertical-layout vertical-menu-modern content-detached-left-sidebar ecommerce-application navbar-floating footer-static  " data-open="click"
      data-menu="vertical-menu-modern" data-col="content-detached-left-sidebar">

<%--test if the session not exist--%>
<c:if test="${sessionScope.client == null}">
    <c:redirect url="/index"></c:redirect>
</c:if>
<%--end test if the session not exist--%>


<!-- BEGIN: Header-->
<%@ include file="includes/header.jsp" %>
<!-- END: Header-->
<div class="main-menu menu-fixed menu-light menu-accordion menu-shadow expanded" data-scroll-to-active="true"
     style="touch-action: none; user-select: none; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
    <div class="navbar-header expanded">
        <ul class="nav navbar-nav flex-row">
            <li class="nav-item mr-auto">
                <a class="navbar-brand" href="../../../html/ltr/vertical-menu-template/index.html">
                    <div class="brand-logo"></div>
                    <h2 class="brand-text mb-0">Vuexy</h2>
                </a>
            <li class="nav-item nav-toggle"><a class="nav-link modern-nav-toggle pr-0" data-toggle="collapse"><i
                    class="icon-x d-block d-xl-none font-medium-4 primary toggle-icon feather icon-disc"></i><i
                    class="toggle-icon icon-disc font-medium-4 d-none d-xl-block collapse-toggle-icon primary feather" data-ticon="icon-disc"></i></a></li>
            </a>
            </li>
        </ul>
    </div>
    <!--    <a href="index.html"><i class="feather icon-home"></i><span class="item" data-i18n="Dashboard">Dashboard</span><span class="badge badge badge-warning badge-pill float-right mr-2">2</span></a>-->
    <div class="shadow-bottom"></div>

    <%@ include file="client-menu.jsp" %>

</div>
<!-- BEGIN: Main Menu-->
<!-- END: Main Menu-->

<!-- BEGIN: Content-->
<div class="app-content content">
    <div class="content-overlay"></div>
    <div class="header-navbar-shadow"></div>
    <div class="content-wrapper">
        <div class="content-header row">
            <div class="content-header-left col-md-9 col-12 mb-2">
                <div class="row breadcrumbs-top">
                    <div class="col-12">
                        <h2 class="content-header-title float-left mb-0">Shop</h2>
                        <div class="breadcrumb-wrapper col-12">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="index?page=home">Home</a>
                                </li>
                                <li class="breadcrumb-item"><a href="#">eCommerce</a>
                                </li>
                                <li class="breadcrumb-item active">Shop
                                </li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
            <div class="content-header-right text-md-right col-md-3 col-12 d-md-block d-none">
                <div class="form-group breadcrum-right">

                </div>
            </div>
        </div>
        <div class="content-detached content-center">
            <div class="content-body">
                <form action="#" class="icons-tab-steps checkout-tab-steps wizard-circle">
                    <!-- Checkout Place order starts -->
                    <h6><i class="step-icon step feather icon-shopping-cart"></i>Cart</h6>
                    <fieldset class="checkout-step-1 px-0">
                        <section id="place-order" class="list-view product-checkout">
                            <div class="checkout-items">
                                <%
                                    Cookie[] cookies = request.getCookies();
                                    for(Cookie c: cookies) {
                                        if(c.getName().equals("panier")) {
                                            String[] cookieValue = c.getValue().split("-");
                                            for(String s: cookieValue) {
                                                String[] prodEtClient = s.split("/");
                                                if(prodEtClient[1].equals(((Client) session.getAttribute("client")).getLogin())){
                                                    Produit produit = null;
                                                    for (Produit p: (ArrayList<Produit>) request.getAttribute("listeProduit")) {
                                                        if(prodEtClient[0].equals(p.getId()))
                                                            produit = p;
                                                    }
                                                    out.println("<div class=\"card ecommerce-card\">\n" +
                                                            "                                    <div class=\"card-content\">\n" +
                                                            "                                        <div class=\"item-img text-center\">\n" +
                                                            "                                            <a href=\"app-ecommerce-details.html\">\n" +
                                                            "                                                <img src=\""+produit.getImage()+"  \" width=\"130\" height=\"130\" alt=\"img-placeholder\">\n" +
                                                            "                                            </a>\n" +
                                                            "                                        </div>\n" +
                                                            "                                        <div class=\"card-body\">\n" +
                                                            "                                            <div class=\"item-name\">\n" +
                                                            "                                                "+produit.getNom()+
                                                            "                                                <span></span>\n" +
                                                            "                                                <p class=\"item-company\">By <span class=\"company-name\">Amazon</span></p>\n" +
                                                            "                                                <p class=\"stock-status-in\">In Stock</p>\n" +
                                                            "                                            </div>\n" +
                                                            "                                            <div class=\"item-quantity\">\n" +
                                                            "                                                <p class=\"quantity-title\">Quantity</p>\n" +
                                                            "                                                <div class=\"input-group quantity-counter-wrapper\">\n" +
                                                            "                                                    <input type=\"text\" class=\"quantity-counter\" value=\"1\">\n" +
                                                            "                                                </div>\n" +
                                                            "                                            </div>\n" +
                                                            "                                            <p class=\"delivery-date\">Delivery by, Wed Apr 25</p>\n" +
                                                            "                                            <p class=\"offers\">17% off 4 offers Available</p>\n" +
                                                            "                                        </div>\n" +
                                                            "                                        <div class=\"item-options text-center\">\n" +
                                                            "                                            <div class=\"item-wrapper\">\n" +
                                                            "                                                <div class=\"item-cost\">\n" +
                                                            "                                                    <h6 class=\"item-price\">\n" +
                                                            "                                                        $"+produit.getPrix()+"\n" +
                                                            "                                                    </h6>\n" +
                                                            "                                                    <p class=\"shipping\">\n" +
                                                            "                                                        <i class=\"feather icon-shopping-cart\"></i> Free Shipping\n" +
                                                            "                                                    </p>\n" +
                                                            "                                                </div>\n" +
                                                            "                                            </div>\n" +
                                                            "                                            <div class=\"wishlist remove-wishlist\">\n" +
                                                            "                                                <a href=\""+request.getContextPath()+"/index?action=deleteFromPanier&deleteP="+produit.getId()+"\"><i class=\"feather icon-x align-middle\"></i> Remove</a>\n" +
                                                            "                                            </div>\n" +
                                                            "                                        </div>\n" +
                                                            "                                    </div>\n" +
                                                            "                                </div>");
                                                }
                                            }
                                        }
                                    }
                                %>

                            </div>


                            <div class="checkout-options">
                                <div class="card">
                                    <div class="card-content">
                                        <div class="card-body">
                                            <div class="detail">
                                                <div class="detail-title">
                                                    Nombre des elements
                                                </div>
                                                <div class="detail-amt">
                                                    5
                                                </div>
                                            </div>
                                            <div class="detail">
                                                <div class="detail-title">
                                                    Delivery Charges
                                                </div>
                                                <div class="detail-amt discount-amt">
                                                    Free
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="detail">
                                                <div class="detail-title detail-total">Total</div>
                                                <div class="detail-amt total-amt">$574</div>
                                            </div>
                                            <a href="#" class="btn btn-primary btn-block place-order">PLACE ORDER</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </fieldset>
                    <!-- Checkout Place order Ends -->

                    <!-- Checkout Customer Address Starts -->

                    <!-- Checkout Customer Address Ends -->


                    <!-- Checkout Payment Starts -->

                    <!-- Checkout Payment Starts -->
                </form>

            </div>
        </div>
    </div>
    <!-- END: Content-->

    <div class="sidenav-overlay"></div>
    <div class="drag-target"></div>

    <!-- BEGIN: Footer-->
    <%@include file="includes/footer.jsp" %>

</body>
<!-- END: Body-->

</html>