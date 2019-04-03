<!-- Navigation -->
<%@ page import="Model.*" %>

<%
    User user = null;
    user = (User) session.getAttribute("user");

    boolean loggedin = (boolean) session.getAttribute("loggedin");
%>

        <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
            <div class="container topnav">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <img src="../img/logo2.png" height="50" width="172"> <% if (loggedin && user != null) { out.print("<ul class='nav navbar-nav navbar-right'><li><a href='/user.jsp'>" + user.getEmail() + "</a></li></ul>"); } %>
                </div>

                <div class="Collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="../index.jsp">FORSIDE</a>
                        </li>
                        <li>
                            <a href="custom">SHOP</a>
                        </li>
                        <%


                            if (!loggedin) {
                                out.print("<li>" +
                                        "<a href='login'>LOGIN</a>" +
                                        "</li>");
                            } else {
                                User currUser = (User) session.getAttribute("user");

                                int permission = currUser.getPermission();

                                switch (permission) {
                                    case 0:
                                        out.print("<li>" +
                                                "<a href='logud'>LOGUD</a>" +
                                                "</li>");

                                        out.print("<li>" +
                                                "<a href='user.jsp'>PROFIL</a>" +
                                                "</li>");
                                        break;
                                    case 10:
                                        out.print("<li>" +
                                                "<a href='logud'>LOGUD</a>" +
                                                "</li>");

                                        out.print("<li>" +
                                                "<a href='user.jsp'>PROFIL</a>" +
                                                "</li>");

                                        out.print("<li>" +
                                                "<a href='admin'>ADMIN</a>" +
                                                "</li>");
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        out.print("<li>" +
                                                "<a href='logud'>LOGUD</a>" +
                                                "</li>");

                                        out.print("<li>" +
                                                "<a href='user.jsp'>PROFIL</a>" +
                                                "</li>");
                                        break;

                                }

                            }
                        %>
                        <li>
                            <a href="kurv.jsp"><i class="fas fa-shopping-cart" style="margin-top: 2px;"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <a name="about"></a>
        <div class="intro-header">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-message">
                            <h1>Cupcake Shop</h1>
                            <hr class="intro-divider">
                            <h3>CPHBusiness Project</h3>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container -->
        </div>
        <!-- /.intro-header -->
