<%

    User currUser = null;

    currUser = (User) session.getAttribute("user");

%>

<%@ page contentType="text/html; charset=UTF-8" %>

<div>
    <h2>Du er logget ind, velkommen <% out.println(currUser.getUsername().toUpperCase()); %></h2> <br>

    <h5>Din Saldo: <b><%  if (currUser.getBalance() < 0) { out.println("<font color='red'>" + currUser.getBalance() + "</font>");} else { out.println("<font color='green'>" + currUser.getBalance() + "</font>");}  %></b></h5>
    <br>
    <form class="form" method="post" action="profile">
        <h4>Oplysninger: </h4>
        <h6>
            For at 	&aelig;ndre oplysninger skal du indtaste dit kodeord!
        </h6>
        Nuv&aelig;rende Kode: <input type="password" class="form-control" placeholder="kodeord" name="password" required>
        <hr>
        Email: <input type="text" class="form-control" value="<% out.println(currUser.getEmail()); %>" name="email"> <br>
        Brugernavn: <input type="text" class="form-control" value="<% out.println(currUser.getUsername()); %>" name="username"> <br>
        <input type="submit" class="btn btn-default" value="Indsend Oplysninger" />
        <br>
        <%
        String changesSuccess = null;
        changesSuccess = (String) request.getAttribute("success");

        if (changesSuccess !=null) {
            if (changesSuccess.equals("ok")) {
                out.println("<p style=\"color: limegreen\">Dine oplysninger er ændret!</p>");
            } else {
                out.println("<p style=\"color: red\">Du har angivet forkert kodeord!</p>");
            }
        }
        %>

    </form>
</div>