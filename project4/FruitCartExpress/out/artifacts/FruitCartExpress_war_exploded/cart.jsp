<%@ page import="us.ncrespo.fruit.model.FruitItems" %>
<%@ page import="us.ncrespo.fruit.model.FruitCatalog" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hawke
  Date: 9/26/2018
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <link rel="stylesheet" href="./Includes/css/style.css">
</head>

<body>

<section class="shop">
    <div class="shop__header">
        <h1 class="shop__title">Fruit Cart Express!</h1>
        <p class="shop__text">
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="products.jsp">Products</a></li>
        </ul>
    </div>
</section>

<%
    List<FruitItems> fL = (List<FruitItems>) request.getAttribute("cartItems");
    System.out.println(fL.toString());
    int totalCost = 0;
    for (FruitItems e : fL) { totalCost += e.getPrice(); }
%>


<div id="rcorners">
    <h3>Shopping Cart</h3>
    <form action="bill">
        <table>
            <%

                for (FruitItems e : fL) {

            %>

            <figure class="tile">
                <a href="#"><img src="<%=e.getImage()%>"></a>
                <div><%=e.getName()%> -- <%=e.getPrice()%></div>
            </figure>

            <%
                }
            %>
        </table>
        Total Cost: $<%=totalCost%>
        <input type="submit" value="Complete Order">
    </form>
</div>


</body>
</html>
