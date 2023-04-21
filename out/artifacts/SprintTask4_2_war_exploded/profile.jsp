<%@ page import="kz.bitlab.sprintTask.db.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Profile</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/shapka.jsp"%>
<%
    Users user= (Users)request.getAttribute("user");
%>
<div class="mt-4">
    <h3 class="text-center">Hello, User <%=user.getFullName()%></h3>
    <h6 class="text-center" style="color: #7a7a7a">This is your profile page!</h6>
</div>
</body>
</html>