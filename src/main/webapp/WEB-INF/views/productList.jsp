<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 28.11.18
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>More</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <hr>
    <table id="register">
        <tr id="summary" style="margin-left: 0%; text-align: left">
            <th width="30%">popularity</th>
            <th width="30%">bank</th>
            <th width="30%">name</th>
            <th width="10%"></th>
        </tr>
    <c:forEach items="${productList}" var="product">
        <tr class="product" style="margin-left: 0%; width: 754px; text-align: left">
            <td width="30%" style="padding-left: 8%">${product.popularity}</td>
            <td width="25%">${product.bank.name}</td>
            <td width="35%">${product.name}</td>
            <td width="10%"><a href="/addMore/${product.id}">add</a></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
