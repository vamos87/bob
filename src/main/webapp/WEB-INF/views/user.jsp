<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 21.11.18
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"	%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <hr>
    <form:form method="post" modelAttribute="user">
        <table id="register">
            <tr>
                <td class="name">name</td>
                <td><form:input path="name" class="input"/><form:errors path="name" class="name"/></td>
            </tr>
            <tr>
                <td class="name">email</td>
                <td><form:input path="email" class="input"/><form:errors path="email" class="name"/></td>
            </tr>
            <tr>
                <td class="name">password</td>
                <td><form:password path="password" class="input"/><form:errors path="password" class="name"/></td>
            </tr>
            <tr>
                <td class="name">retype password</td>
                <td class="name"><input type="password" name="repassword" class="input">${wrong}</td>
            </tr>
            <tr>
                <td></td>
                <td align="center">
                    <input type="submit" value="edit" class="button submit">
                </td>
            </tr>
        </table>
    </form:form>
    <form action="/deleteuser">
        <input type="submit" value="delete" class="button submit"/>
    </form>
</body>
</html>
