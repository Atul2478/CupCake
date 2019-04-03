<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int amountOfOrders = 0;
    amountOfOrders = (int) request.getAttribute("amountOfOrders");

    ArrayList<Order> userOrders = null;
    userOrders = (ArrayList<Order>) request.getAttribute("userOrders");
%>

<div class="content-section-b">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="card pull-left" style="display:inline-block;">
                    <h3 class="card-header">Bruger Fundet!</h3>
                    <div class="card-body" style="padding: 10px;">
                        <h5 class="card-title"><i>Email: <% out.println(foundUser.getEmail()); %></i></h5>
                        <h5 class="card-title"><i>Brugernavn: <% out.println(foundUser.getUsername()); %></i></h5>
                        <h5 class="card-title"><i>Balance: $ <% out.println(foundUser.getBalance()); %></i></h5>
                        <h5 class="card-title"><i>Antal Ordre: <% out.println(amountOfOrders); %></i></h5>

                        <form method="post" action="/admin" name="form-standard">
                            <input type="hidden" name="money-user-id" value="<%out.println(foundUser.getId());%>" />
                            <input type="text" class="form-control" placeholder="Indsæt penge" style="display: inline-block;max-width:150px" name="change-money" required><input type="submit" class="btn btn-info" style="display: inline-block;margin-left: 5px; margin-bottom: 4px;" value="Indsæt" /><br>
                        </form>
                        <form method="post" action="/admin" name="form-delete">
                        <button class="btn btn-danger" name="delete-user" value="<% out.println(foundUser.getId()); %>">Slet Bruger</button>
                        </form>

                    </div>
                </div>

                <div class="card pull-left" style="display:inline-block;margin-left: 50px;">
                    <h3 class="card-header">Kundens Bestillinger</h3>
                    <div class="card-body">
                        <h5 class="card-title"><i>Her kan du se kundens bestillinger</i></h5>
                        <form action="/admin" method="post">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">Ordre id</th>
                                    <th scope="col">Pris</th>
                                    <th scope="col" style="text-align:center">Handlinger</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%

                                    for (Order o : userOrders) {
                                        out.println("<tr>" +
                                                "<th scope='row'>" + o.getOrder_id() + "</th>" +
                                                "<td> $ " + o.getTotal() + "</td>" +
                                                "<td><button class='btn btn-danger' name='delete' value='" + o.getOrder_id() + "'>Slet</button></td></td>");
                                    }
                                %>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>