
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Top" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.User" %>


<%
    ArrayList<Order> orders = null;

    orders = (ArrayList<Order>) request.getAttribute("orders");

    ArrayList<User> users = null;

    users = (ArrayList<User>) request.getAttribute("users");
%>

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
<div class="content-section-a">
    <div class="container">
        <div class="row">
            <div class="col-lg-5 col-sm-6">
                <h2 class="section-heading">Velkommen til Admin Panelet</h2>
            </div>
        </div>
    </div>
</div>

    <%
        boolean searched = (boolean) request.getAttribute("searched");
        User foundUser = null;
        foundUser = (User) request.getAttribute("changeUser");

        User searchedUser = null;
        searchedUser = (User) request.getAttribute("searchedUser");

        if (!searched && foundUser == null && searchedUser == null) { %>
            <%@include file="includes/admin_panel.jsp" %>
        <% } else if (searched && searchedUser != null) { %>
            <%@include file="includes/admin_search.jsp" %>
        <% } else if (foundUser != null) { %>
            <%@include file="includes/admin_change.jsp" %>
        <% } %>

        <%@ include file="includes/footer.jsp" %>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>