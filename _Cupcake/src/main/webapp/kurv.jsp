<%@ page import="Model.Top" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="Model.Orderline" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

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
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                <%
                    ArrayList<Cupcake> kurv = null;

                    kurv = (ArrayList<Cupcake>) session.getAttribute("kurv");

                    if (kurv != null && !kurv.isEmpty()) { %>
                        <%@ include file="includes/cart.jsp" %>
                   <% } else {
                        out.println("<h2>Din kurv er tom!</h2> <br> <a class=\"btn btn-primary\" href=\"custom\" style=\"width: 100px;\">Shop nu</a>");
                   } %>
            </div>
        </div>
        <div class="col-lg-2"></div>
        <a name="contact"></a>
            <%@ include file="includes/footer.jsp" %>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>