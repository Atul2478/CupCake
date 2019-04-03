<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="content-section-c">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">

                <div class="card" style="display:inline-block;">
                    <h3 class="card-header">Panel</h3>
                    <div class="card-body">
                        <h5 class="card-title"><i>Her kan du administrere kunder</i></h5>
                        <p class="card-text">Nedenunder er en liste over alle kunder og mulighed for at ændre i dem.</p>
                        <form method="post" action="/admin">
                            <input style="display:inline-block;width:70%;" class="form-control" type="text" name="find-user" id="find-user" placeholder="Søg efter email eller kunde nr." /> <input type="submit" style="display:inline-block;margin-left: 5px; margin-bottom: 4px;" class="btn btn-primary" value="Søg">
                        </form>

                        <form action="/admin" method="post">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Adgang</th>
                                    <th scope="col">Brugernavn</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Balance</th>
                                    <th scope="col" style="text-align:center">Handlinger</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    if (users != null) {
                                        for (User u : users) {
                                            out.println("<tr>" +
                                                    "<th scope='row'>" + u.getId() + "</th>" +
                                                    "<td>" + u.getPermission() + "</td>" +
                                                    "<td>" + u.getUsername() + "</td>" +
                                                    "<td>" + u.getEmail() + "</td>" +
                                                    "<td> $ " + u.getBalance() + "</td>" +
                                                    "<td><button class='btn btn-success' name='change' value='" + u.getEmail() + "'>Se Kunde</button></td></td>");
                                        }
                                    }
                                %>
                                </tbody>
                            </table>
                        </form>

                    </div>
                </div>
                <div class="card pull-right" style="display:inline-block;">
                    <h3 class="card-header">Bestillinger</h3>
                    <div class="card-body">
                        <h5 class="card-title"><i>Her kan du se alle bestillinger</i></h5>
                        <form action="/admin" method="post">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Kunde Nr.</th>
                                    <th scope="col">Pris</th>
                                    <th scope="col" style="text-align:center">Handlinger</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    if (orders != null) {
                                        for (Order o : orders) {
                                            out.println("<tr>" +
                                                    "<th scope='row'>" + o.getOrder_id() + "</th>" +
                                                    "<td>" + o.getUser_id() + "</td>" +
                                                    "<td> $ " + o.getTotal() + "</td>" +
                                                    "<td><button class='btn btn-danger' name='delete' value='" + o.getOrder_id() + "'>Slet</button></td></td>");
                                        }
                                    }
                                %>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>