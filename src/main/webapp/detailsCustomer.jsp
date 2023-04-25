<%@ page import="fr.esgi.customer.beans.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Sarah Schlegel
  Date: 25/04/2023
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détails d'un client</title>
</head>
<body>
<h1>Détails d'un client</h1>
<% Customer customer = (Customer) request.getAttribute("customer"); %>
<ul>
    <li>Raison sociale : <% out.println(customer.companyName()); %></li>
    <li><% out.println(String.format("Ville : %s", customer.town())); %></li>
    <li><% out.println(String.format("Adresse : %s", customer.address())); %></li>
    <li><% out.println(String.format("Siret : %s", customer.siret())); %></li>
</ul>
</body>
</html>
