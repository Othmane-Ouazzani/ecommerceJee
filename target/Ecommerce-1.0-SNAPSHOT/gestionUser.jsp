<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${ sessionScope.client == null}">
    <c:redirect url="/index" />
</c:if>
<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">

<!-- BEGIN: Head-->
<%@include file="includes/head.jsp" %>
<!-- END: Head-->

<!-- BEGIN: Body-->

<body class="vertical-layout vertical-menu-modern content-detached-left-sidebar ecommerce-application navbar-floating footer-static  " data-open="click" data-menu="vertical-menu-modern" data-col="content-detached-left-sidebar">

<!-- BEGIN: Header-->
<nav class="header-navbar navbar-expand-lg navbar navbar-with-menu floating-nav navbar-light navbar-shadow">
    <div class="navbar-wrapper">
        <div class="navbar-container content">
            <div class="navbar-collapse" id="navbar-mobile">
                <div class="mr-auto float-left bookmark-wrapper d-flex align-items-center">
                    <ul class="nav navbar-nav">
                        <li class="nav-item mobile-menu d-xl-none mr-auto"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i class="ficon feather icon-menu"></i></a></li>
                    </ul>
                    <ul class="nav navbar-nav bookmark-icons">
                        <li class="nav-item d-none d-lg-block"><a class="nav-link" href="app-todo.html" data-toggle="tooltip" data-placement="top" title="Todo"><i class="ficon feather icon-check-square"></i></a></li>
                    </ul>

                </div>
                <ul class="nav navbar-nav float-right">

                    <li class="nav-item d-none d-lg-block"><a class="nav-link nav-link-expand"><i class="ficon feather icon-maximize"></i></a></li>
                    <li class="dropdown dropdown-user nav-item"><a class="dropdown-toggle nav-link dropdown-user-link" href="#" data-toggle="dropdown">
                        <div class="user-nav d-sm-flex d-none"><span class="user-name text-bold-600"><c:out value="${client.nom} ${client.prenom}"/></span><span class="user-status">Available</span></div><span><img class="round" src="app-assets/images/portrait/small/avatar-s-11.jpg" alt="avatar" height="40" width="40"></span>
                    </a>
                        <div class="dropdown-menu dropdown-menu-right"><a class="dropdown-item" href="page-user-profile.html"><i class="feather icon-user"></i> Edit Profile</a><a class="dropdown-item" href="app-email.html"><i class="feather icon-mail"></i> My Inbox</a><a class="dropdown-item" href="app-todo.html"><i class="feather icon-check-square"></i> Task</a><a class="dropdown-item" href="app-chat.html"><i class="feather icon-message-square"></i> Chats</a>
                            <div class="dropdown-divider"></div><a class="dropdown-item" href="auth-login.html"><i class="feather icon-power"></i> Logout</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>

<ul class="main-search-list-defaultlist-other-list d-none">
    <li class="auto-suggestion d-flex align-items-center justify-content-between cursor-pointer"><a class="d-flex align-items-center justify-content-between w-100 py-50">
        <div class="d-flex justify-content-start"><span class="mr-75 feather icon-alert-circle"></span><span>No results found.</span></div>
    </a></li>
</ul>
<!-- END: Header-->
<div class="main-menu menu-fixed menu-light menu-accordion menu-shadow expanded" data-scroll-to-active="true" style="touch-action: none; user-select: none; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
    <div class="navbar-header expanded">
        <ul class="nav navbar-nav flex-row">
            <li class="nav-item mr-auto"><a class="navbar-brand" href="../../../html/ltr/vertical-menu-template/index.html">
                <div class="brand-logo"></div>
                <h2 class="brand-text mb-0">Vuexy</h2>
            <li class="nav-item nav-toggle"><a class="nav-link modern-nav-toggle pr-0" data-toggle="collapse"><i class="icon-x d-block d-xl-none font-medium-4 primary toggle-icon feather icon-disc"></i><i class="toggle-icon icon-disc font-medium-4 d-none d-xl-block collapse-toggle-icon primary feather" data-ticon="icon-disc"></i></a></li>

            </a></li>
        </ul>
    </div>
    <!--    <a href="index.html"><i class="feather icon-home"></i><span class="item" data-i18n="Dashboard">Dashboard</span><span class="badge badge badge-warning badge-pill float-right mr-2">2</span></a>-->
    <div class="shadow-bottom"></div>

    <%@ include file="main-menu.jsp" %>

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
                        <h2 class="content-header-title float-left mb-0">DataTables</h2>
                        <div class="breadcrumb-wrapper col-12">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="index.html">Home</a>
                                </li>
                                <li class="breadcrumb-item active">Datatable
                                </li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
            <div class="content-header-right text-md-right col-md-3 col-12 d-md-block d-none">
                <div class="form-group breadcrum-right">
                    <div class="dropdown">
                        <button class="btn-icon btn btn-primary btn-round btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="feather icon-settings"></i></button>
                        <div class="dropdown-menu dropdown-menu-right"><a class="dropdown-item" href="#">Chat</a><a class="dropdown-item" href="#">Email</a><a class="dropdown-item" href="#">Calendar</a></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="content-body">
            <div class="row">
                <div class="col-12">
                    <p>Read full documnetation <a href="https://datatables.net/" target="_blank">here</a></p>
                </div>
            </div>

            <!-- Column selectors with Export Options and print table -->
            <section id="column-selectors">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-content">
                                <div class="card-body card-dashboard">
                                    <p>
                                        <!-- Button trigger modal -->
                                        <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#inlineForm">
                                            + Add New User
                                        </button>

                                        <!-- Modal -->
                                    <div class="modal fade text-left" id="inlineForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel33" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h4 class="modal-title" id="myModalLabel33">Add User form</h4>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <form action="index" method="post">
                                                    <input type="hidden" name="type" value="addUser">
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <input type="text" placeholder="First Name" name="fname" class="form-control">
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="text" placeholder="Last Name" name="lname" class="form-control">
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="email" placeholder="Email" name="email" class="form-control">
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="text" placeholder="Phone number" name="num" class="form-control">
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="password" name="password" placeholder="Password" class="form-control">
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="password" placeholder="Confirm password" name="cpassword" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="submit" class="btn btn-primary" >Add User</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    </p>
                                    <div class="table-responsive">
                                        <table class="table table-striped dataex-html5-selectors">
                                            <thead>
                                            <tr>
                                                <th>First Name</th>
                                                <th>Last Name</th>
                                                <th>Email</th>
                                                <th>Phone Number</th>
                                                <th>Password</th>
                                                <th>Action</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${listeClient}" var="client">
                                                <tr>
                                                    <td>${client.nom}<span hidden id="enom-${client.login.replace('@', '-').replace('.', '-')}">${client.nom}</span></td>
                                                    <td>${client.prenom}<span hidden id="eprenom-${client.login.replace('@', '-').replace('.', '-')}">${client.prenom}</span></td>
                                                    <td>${client.login}<span hidden id="elogin-${client.login.replace('@', '-').replace('.', '-')}">${client.login}</span></td>
                                                    <td>${client.tel}<span hidden id="etel-${client.login.replace('@', '-').replace('.', '-')}">${client.tel}</span></td>
                                                    <td>${client.password}<span hidden id="epassword-${client.login.replace('@', '-').replace('.', '-')}">${client.password}</span></td>
                                                    <td>
                                                        <span class="cursor-pointer editClientButton" id="${client.login}" data-toggle="modal" data-target="#editClientModal"><i class="feather icon-edit"></i></span>
                                                        <span class="cursor-pointer deleteUserButton" id="${client.login}" data-toggle="modal" data-target="#danger"><i class="feather icon-trash"></i></span>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                            <tfoot>
                                            <tr>
                                                <th>First Name</th>
                                                <th>Last Name</th>
                                                <th>Email</th>
                                                <th>Phone Number</th>
                                                <th>Password</th>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Column selectors with Export Options and print table -->

        </div>
    </div>
</div>

<%--edit modal begin--%>
<div class="modal fade text-left" id="editClientModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel33" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalEditClient">Add User form</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="index" method="post">
                <input type="hidden" name="type" value="addUser">
                <div class="modal-body">
                    <div class="form-group">
                        <input type="text" id="enom" placeholder="First Name" name="fname" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="text" id="eprenom" placeholder="Last Name" name="lname" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="email" id="eemail" placeholder="Email" name="email" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="text" id="etel" placeholder="Phone number" name="num" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" id="epassword" name="password" placeholder="Password" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" id="ecpassword" placeholder="Confirm password" name="cpassword" class="form-control">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" >Add User</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--edit modal end--%>

<!-- END: Content-->

<div class="sidenav-overlay"></div>
<div class="drag-target"></div>

<%-- are you sure deleting --%>
<div class="modal fade text-left" id="danger" tabindex="-1" role="dialog" aria-labelledby="myModalLabel120" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header bg-danger white">
                <h5 class="modal-title" id="myModalLabel120">Danger</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <h1>Are you sure? </h1><p>supprimer le client <span id="clientIdDelete"></span></p>
            </div>
            <div class="modal-footer">
                <form action="index" method="post">
                    <input type="hidden" value="deleteClient" name="type">
                    <input id="inputClientEmail" type="hidden" name="clientEmail">
                    <button type="submit" class="btn btn-danger">Accept</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%-- are you sure deleting --%>


<!-- BEGIN: Footer-->
<%@include file="includes/footer.jsp" %>

</body>
<!-- END: Body-->

<script>
    function removeSpecial(myStr) {
        return myStr.replace('@', '-').replace('.', '-');
    }

    $(".deleteUserButton").on("click", function() {
        let email = $(this).attr("id");
        console.log(email)
        document.getElementById("clientIdDelete").innerHTML = email;
        document.getElementById("inputClientEmail").setAttribute("value", email);
    })
    $(".editClientButton").on("click", function() {
        let email = $(this).attr("id");
        let nom = $("#enom-" + removeSpecial(email)).text();
        let prenom = $("#eprenom-" + removeSpecial(email)).text();
        let tel = $("#etel-" + removeSpecial(email)).text();
        let password = $("#epassword-" + removeSpecial(email)).text();

        $("#enom").val(nom);
        $("#eprenom").val(prenom);
        $("#eemail").val(email);
        $("#etel").val(tel);
        $("#epassword").val(password);
        $("#ecpassword").val(password);
    })
</script>

</html>