<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 18.11.18
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Portfolio</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <hr>
            <div>
                <table id="summary">
                    <tr>
                        <td style="align: left">deposits: ${deposits} pln</td>
                        <td style="align: right">credits: ${credits} pln</td>
                    </tr>
                </table>
            </div>
            <div style="margin-left: 25%">
                <c:forEach items="${instrumentTypes}" var="item">
                    <div class="prodType">
                        <table>
                            <tr class="product">
                                <td width="40%" style="text-align: left; padding-left: 10%">${item.name}: </td>
                                <td width="40%" style="text-align: right">${item.sum} pln </td>
                                <td width="10%"style="text-align: center"><a href="/add/${item.id}">add</a></td>
                                <td width="10%"><a href="/more/${item.id}">more</a></td>
                            </tr>
                        </table>
                    </div>
                    <div>
                        <table class="product" style="margin-left: 15px" >
                            <c:forEach items="${products}" var="prod">
                                <c:if test="${prod.product.instrumentType.id == item.id}">
                                    <tr>
                                        <td width="20%" style="text-align: left">${prod.product.bank.name}</td>
                                        <td width="35%" style="text-align: left">${prod.product.name}</td>
                                        <td width="20%" style="text-align: right">${prod.value} pln</td>
                                        <td width="15%" style="text-align: center"><a href="/edit/${prod.id}">edit</a></td>
                                        <td width="10%"><a href="/delete/${prod.id}">delete</a></td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </table>
                    </div>
                </c:forEach>
            </div>
    <hr>
    <a href="/resetportfolio" class="button">reset</a> <a href="/history" class="button">history</a> <a href="/user" class="button">user</a>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/static/app.js" type="text/javascript"></script>
</body>
</html>


