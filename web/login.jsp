<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Login</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="exclamation-triangle-fill" viewBox="0 0 16 16">
        <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"></path>
    </symbol>
</svg>
<%@include file="vendor/shapka.jsp"%>
<%
    String error=request.getParameter("error");
    if(error!=null){
%>
<div class="container" style="margin-top: 1%"></div>
<div class="alert alert-danger d-flex align-items-center" role="alert" style="height: 60px; width: 50.5%; margin-left: 25%;">
    <svg class="bi flex-shrink-0 me-2" role="img" aria-label="Danger:" style="width: 20px;">
        <use xlink:href="#exclamation-triangle-fill"></use></svg>
    <div>
        Incorrect <b>email</b> and <b>password</b>!
    </div>
</div>
<%
    }
%>
<div class="container mt-3">
    <div class="card" style="width: 75%; margin-left: 13%;">
        <div class="card-header">
            Login Page
        </div>
        <form action="/login" method="post">
            <div class="card-body">
                <p class="card-text">
                <div class="mb-3 row">
                    <label class="col-sm-2 col-form-label">Email: </label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" name="user_email">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control "name="user_password">
                    </div>
                </div>
                <button type="submit" class="btn btn-success">Login</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>