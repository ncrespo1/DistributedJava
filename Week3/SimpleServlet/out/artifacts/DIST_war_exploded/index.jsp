<html>
<body>
<h1>Simple Servlet</h1>
<h2>Column Search</h2>

<%--<form method="get" action="simple">--%>
    <%--<input type="text" name="acctnum">--%>
    <%--<input type="submit" value="submit">--%>
<%--</form>--%>

<form method="get" action="simple">
    <input type="radio" name="column" value="ACCTNUM">ACCTNUM<br>
    <input type="radio" name="column" value="FNAME">FNAME<br>
    <input type="radio" name="column" value="LNAME">LNAME<br>
    <input type="radio" name="column" value="EMAIL">EMAIL<br>
    <input type="radio" name="column" value="IPADDR">IPADDR<br>
    <input type="text" name="search" value="Search">
    <input type="submit" value="submit">
</form>

</body>
</html>