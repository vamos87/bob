<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 25.11.18
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/fragments/header.jsp"/>
    <hr>
    <h2 style="margin-left: 20%">do you really want to remove history?</h2>
        <form method="post" action="/deletehistory" id="register" style="margin-left: 30%">
            <input type="submit" name="button" value="no" class="button submit"/>
            <input type="submit" name="button" value="yes" class="button" style="width: 250px"/>
        </form>
</body>
</html>
