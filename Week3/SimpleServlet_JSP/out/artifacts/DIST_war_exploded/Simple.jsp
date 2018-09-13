<%@ page import="edu.wctc.simple.Students" %>
<%@ page import="edu.wctc.simple.Individual" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.wctc.simple.FindColumns" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Simple Web Page</h1>
<form method="get" action="simple">
    <input type="text" name="acctnum">
    <input type="submit" value="submit">
</form>

<% Students theStudents = new Students();

    ArrayList<Individual> result;

    result = theStudents.findStudents(FindColumns.ACCTNUM, request.getParameter("acctnum"));

    for (Individual i: result) { %>
<p><%=(i.getAccountNumber() + " " + i.getFname() + " " + i.getLname())%></p>
<%}%>

<%result = theStudents.findStudents(FindColumns.LNAME, "Mar");

    for (Individual i: result) {%>
<p><%=(i.getAccountNumber() + " " + i.getFname() + " " + i.getLname())%></p>
<%}%>

</body>
</html>
