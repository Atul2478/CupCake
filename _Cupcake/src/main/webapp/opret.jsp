<%--
  Created by IntelliJ IDEA.
  User: Marcus
  Date: 17-03-2019
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CPHBusiness Cupcakes: Log ind</title>

    <link href="css/style.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">

</head>
<body>
<div class="signin-form">
    <tr></tr>
    <tr></tr><tr></tr>
    <center><a href="index.jsp"><img src="img/logo2.png" style="text-align:center;width: 500px" /></a></center>
    <br>

    <div class="container">

        <form class="form-signin" action="opret" method="post">

            <div class="form-group">
                <input type="text"  class="form-control" name="username" value="" placeholder="Brugernavn" />
            </div>

            <div class="form-group">
                <input type="text"  class="form-control" name="email" value="" placeholder="Email" />
            </div>

            <div class="form-group">
                <input type="password" class="form-control" name="password" value="" placeholder="Adgangskode" />
            </div>
            <br>
            <br>
            <br>
            <div class="form-group">
                <input type="submit" class="btn btn-default" value="Opret bruger" />
                <div style="float:right;">
                    Har du allerede en bruge? <a href="login"> Login her!</a>
                </div>
            </div>
        </form>
    </div>
    <div style="text-align:center">
        <h5><b>© 2019 CupCake Factory (CVR: 38267138). Alle rettigheder forbeholdes.</b></h5>
    </div>
</div>
</body>
</html>
