<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Login</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
    <%@include file="vendor/shapka.jsp"%>
    <%
        String error=request.getParameter("error");
        if(error!=null){
    %>
    <h1>Error!!</h1>
    <%
        }
    %>
    <form action="/login" method="post">
      <label class="form-label">Email: </label>
      <input type="email" class="form-control" name="user_email">
      <label class="form-label">Password: </label>
      <input type="password" class="form-control "name="user_password">
      <button type="submit">Log in</button>
    </form>
</body>
</html>
