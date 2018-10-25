<%@ page import="us.ncrespo.fruit.model.FruitItems" %>
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
            <li><a href="cart">View Cart</a></li>
        </ul>
    </div>

    <%
        List<FruitItems> fL = (List)request.getAttribute("fruitSomething");
        for (FruitItems e : fL) {
    %>
    <div class="shop__products">
        <div class="products">
            <div class="products__item">
                <article class="product">
                    <h1 class="product__title"><%=e.getName()%></h1>
                    <img src="<%=e.getImage()%>">
                    <p class="product__text">
                       <%=e.getDescription()%><br><br>
                        <strong>$<%=e.getPrice()%></strong>
                    </p>
                    <form action="addToCart"><button name="cartItem" value="<%=e.getID()%>">Add to cart</button></form>

                </article>

            </div>
        </div>
    </div>
    <%
        }
    %>
</section>
</body>
</html>
