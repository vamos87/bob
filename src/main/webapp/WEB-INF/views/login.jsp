<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 20.11.18
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
</head>
<body>
    <form method="post" action="/login">
        <table id="register">
            <tr>
                <td class="name">email</td>
                <td><input type="email" name="email"  class="input"></td>
            </tr>
            <tr>
                <td class="name">password</td>
                <td><input type="password" name="password"  class="input"></td>
            </tr>
            <tr>
                <td></td>
                <td align="center">
                    <input type="submit" value="sign in" class="button submit">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
