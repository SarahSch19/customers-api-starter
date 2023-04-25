<%@ page import="fr.esgi.customer.beans.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Sarah Schlegel
  Date: 25/04/2023
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des clients</title>
</head>
<body>
<h1>Liste des clients</h1>

<%
    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
    for (Customer customer : customers) { %>
<ul>
    <li><% out.println(String.format("Raison sociale : %s", customer.companyName())); %></li>
    <li><% out.println(String.format("Ville : %s", customer.town())); %></li>
    <li><% out.println(String.format("Adresse : %s", customer.address())); %></li>
    <li><% out.println(String.format("Siret : %s", customer.siret())); %></li>
</ul>
<% } %>
</body>
</html>
