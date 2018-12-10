<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 20.11.18
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"	%>

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
</head>
<body>
    <form:form method="post" modelAttribute="user">
        <table id="register">
            <tr>
                <td class="name">name</td>
                <td><form:input path="name" cssClass="input"/><form:errors path="name" cssClass="name"/></td>
            </tr>
            <tr>
                <td class="name">email</td>
                <td><form:input path="email" cssClass="input"/><form:errors path="email" cssClass="name"/></td>
            </tr>
            <tr>
                <td class="name">password</td>
                <td><form:password path="password" cssClass="input"/><form:errors path="password" cssClass="name"/></td>
            </tr>
            <tr>
                <td class="name">retype password</td>
                <td><input class="input" type="password" name="repassword"><span class="name">${wrong}</span></td>
            </tr>
            <tr>
                <td></td>
                <td align="center">
                    <input type="submit" value="sign up" class="button submit">
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
