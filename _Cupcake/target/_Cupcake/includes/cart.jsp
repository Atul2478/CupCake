<%@ page import="Model.Cupcake" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2 class="section-heading">Nuværende Kurv</h2>
<center>
    <form action="/cart" method="post">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Top</th>
                <th scope="col">Bund</th>
                <th scope="col">Antal</th>
                <th scope="col">Pris</th>
                <th scope="col" style="text-align:center">Handlinger</th>
            </tr>
            </thead>
            <tbody>
            <%
                int localId = 0;

                Double totalPrice;

                for (int i = 0; i < kurv.size(); i++) {

                    localId++;

                    out.println("<tr>" +
                        "<th scope='row'>" + localId + "</th>" +
                        "<td>" + kurv.get(i).getTop_name() + "</td>" +
                        "<td>" + kurv.get(i).getBottom_name() + "</td>" +
                        "<td>" + kurv.get(i).getAmount() + "</td>" +
                        "<td><b>$ " + kurv.get(i).getPrice()*kurv.get(i).getAmount() + "</b></td>" +
                        "<td style='text-align:center'><button class='btn btn-danger' style='width: 75px;' name='delete' value='" + i + "'>Slet</button></td>" +
                    "</tr>");

            } %>
            <tr>
                <th scope="row"></th>
                <td></td>
                <td></td>
                <td></td>
                <td style="text-align:right">Pris i alt</td>
                <td style="text-align:center"><b>$ <% out.println(session.getAttribute("totalPrice")); %></b></td>
            </tr>
            <tr>
                <th scope="row"></th>
                <td></td>
                <td></td>
                <td></td>
                <td style="text-align:right"><a class="btn btn-primary" href="custom" style="width: 100px;">Tilf&oslash;j mere</a></td>
                <td style="text-align:center"><button class="btn btn-success" style="width: 100px;" name="order" value="doOrder">Fuldf&oslash;r k&oslash;b</button></td>
            </tr>
            </tbody>
        </table>
    </form>
</center>