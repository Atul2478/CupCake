<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.*" %>
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
                <div class="col-lg-2"></div>
                <div class="col-lg-8 col-sm-9">
                    <h2 class="section-heading" style="margin-top:15px">Her kan du se vores udvalg</h2>
                    <p class="lead">Tilføj en custom cupcake til kurv her eller kig igennem vores udvalg af cupcakes <3</p>


                    <form action="cart" method="post">
                        <div class="form-group">
                            <div style="display: inline-block;padding: 5px;">
                                <label for="top">Select Top</label>
                                <select class="form-control" id="top" name="top">
                                    <option disabled selected>Toplistens valgmuligheder</option>
                                    <%
                                        ArrayList<Top> toplist = (ArrayList<Top>) request.getAttribute("toplist");

                                        if (toplist != null) {

                                            for (int i = 0; i < toplist.size(); i++) {

                                                int top_id = toplist.get(i).getId();
                                                String name = toplist.get(i).getName();
                                                Double price = toplist.get(i).getPrice();

                                                out.println("<option value='" + top_id + "'>" + top_id + ". " + name + " ~ " + price + "</option>");
                                            }
                                        } else {
                                            out.println("<option>Ingen options!</option>");
                                        }
                                    %>
                                </select>
                            </div>
                            <div style="display: inline-block;padding: 5px;">
                                <label for="bottom">Select Bottom</label>
                                <select class="form-control" id="bottom" name="bottom">
                                    <option disabled selected>Bundlistens valgmuligheder</option>
                                    <%
                                        ArrayList<Bottom> bottomlist = (ArrayList<Bottom>) request.getAttribute("bottomlist");

                                        if (bottomlist != null) {

                                            for (int i = 0; i < bottomlist.size(); i++) {

                                                int bottom_id = bottomlist.get(i).getId();
                                                String name = bottomlist.get(i).getName();
                                                Double price = bottomlist.get(i).getPrice();

                                                out.println("<option value='" + bottom_id + "'>" + bottom_id + ". " + name + " ~ " + price + "</option>");
                                            }
                                        } else {
                                            out.println("<option>Ingen options!</option>");
                                        }
                                    %>
                                </select>
                            </div>
                            <div style="display: inline-block;padding: 5px;">
                                <label for="amount">Select Top</label>
                                <select class="form-control" id="amount" name="amount">
                                    <option disabled selected>Antal</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                </select>
                            </div>
                            <div style="margin:auto;position:relative;left: 5px;">
                                <button type="submit" class="btn btn-primary">Føj til kurv</button>
                                <!-- <button type="submit" class="btn btn-info">Køb nu</button> -->
                            </div>
                        </div>
                    </form>


                </div>
                <div class="col-lg-2"></div>
            </div>

            <div class="col-lg-2"></div>

            <br><br>

            <div class="card card-lg-8">
                <div class="card-body">
                    <div class="card-title"><h3>Vores Shop</h3></div>

                    <div class="card" style="width: 20%;display:inline-block;border-color: #000000; border: #000000 2px;">
                        <img class="card-img-top" src="img/DoubleChocolate.png" alt="Card image cap" style="width: 90%; margin: auto;">
                        <div class="card-body">
                            <h5 class="card-title">Double Chocolate</h5>
                            <p class="card-text">En dobbelt omgang af chokolade er den perfekts kombination af en muffins top og bund, begge af chokolade.</p>
                            <a href="#" class="btn btn-primary">Læg i kurv</a>
                        </div>
                    </div>

                    <div class="card" style="width: 20%;display:inline-block">
                        <img class="card-img-top" src=".../100px180/" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>

                    <div class="card" style="width: 20%;display:inline-block">
                        <img class="card-img-top" src=".../100px180/" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>

                    <div class="card" style="width: 20%;display:inline-block">
                        <img class="card-img-top" src=".../100px180/" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>


                </div>
            </div>
            <div class="col-lg-2"></div>
        </div>
    </div>
    <a name="contact"></a>
        <%@ include file="includes/footer.jsp" %>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</form>
</body>

</html>