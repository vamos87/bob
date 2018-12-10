<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 20.11.18
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <hr>
    <form method="post">
        <table id="register">
            <tr>
                <td class="name">type</td>
                <td>
                    <select disabled class="input">
                        <option>${purchasedProduct.product.instrumentType.name}</option>
                    </select>
                </td>

            </tr>
            <tr>
                <td class="name">bank and name</td>
                <td>
                    <select name="prod" class="input">
                        <c:forEach items="${products}" var="product">
                            <option value="${product.id}"
                                <c:if test="${product.id == purchasedProduct.product.id}">
                                    selected="selected"
                                </c:if>
                            >${product}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="name">value</td>
                <td><input type="number" min="0" step="0.01" name="value" value="${purchasedProduct.value}" class="input"/></td>
            </tr>
            <tr>
                <td class="name">short note</td>
                <td><input type="text" maxlength="100" name="note" value="${purchasedProduct.note}" class="input"/></td>
            </tr>
            <tr>
                <td></td>
                <td align="center">
                    <input type="submit" value="edit" class="button submit">
                </td>
            </tr>
        </table>
        <input hidden value="${purchasedProduct.id}" name="id">
    </form>
</body>
</html>
