<%@ page import="Model.Top" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.User" %>

<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>

    <title>CPHBusiness Cupcake</title>

    <link href="css/style.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
          integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet"
          type="text/css">
    <link rel="icon" href="img/icon.ico">

</head>
<body>

<%@ include file="includes/navigation.jsp" %>

<!-- Page Content -->
<a name="services"></a>
<div class="content-section-a">
        <div class="container">
            <div class="row">
                <div class="col-lg-2">
                </div>
                <div class="col-lg-8">

                    <%
                        if (loggedin) {
                    %>

                    <%@ include file="includes/profile.jsp" %>

                    <%    } else {
                        out.println("<div><h2>Du er ikke logget ind!</h2></div>");
                    }
                    %>

                </div>
                <div class="col-lg-2">
                </div>
            </div>
        <a name="contact"></a>
            <%@ include file="includes/footer.jsp" %>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>
