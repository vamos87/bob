<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 29.11.18
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<html>
<head>
    <title>History</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <hr>
        <table id="register">
            <tr id="summary" style="margin-left: 0%">
                <th width="10%">date</th>
                <th width="30%">bank</th>
                <th width="30%">product</th>
                <th width="20%">value</th>
                <th width="10%" style="text-align: right">action</th>
            </tr>
        <c:forEach items="${histories}" var="history">
            <tr class="product" style="margin-left: 0%; width: 754px">
                <td style="text-align: left" width="20%">${fn:substring(history.date,0,10)}</td>
                <td style="text-align: left" width="20%">${history.purchasedProduct.product.bank.name}</td>
                <td style="text-align: left" width="25%">${history.purchasedProduct.product.name}</td>
                <td style="text-align: right" width="20%">${history.value}</td>
                <td style="text-align: right" width="15%">${history.operation}</td>
            </tr>
        </c:forEach>
        </table>
    <a href="/deletehistory" class="button submit" style="width: 100px">reset</a>
</body>
</html>
