<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.sprintTask.db.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Home</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/shapka.jsp"%>
<div class="mt-4">
    <h3 class="text-center">Welcome to <%=shopName%></h3>
    <h6 class="text-center" style="color: #7a7a7a">Electronic devices with high quality and service</h6>
</div>
<div class="mt-5" style="width:80%; display: flex; justify-content: center;
                                       flex-wrap: wrap; flex-direction: row; margin-left: 9.5%">
    <%
        ArrayList<Items> items= (ArrayList<Items>) request.getAttribute("items");
        if (items!=null){
            for(Items i: items){
    %>
    <div style="width: 5%"></div>
    <div class="card text-center" style="width: 23%; margin-bottom: 4%">
        <div class="card-header">
            <%=i.getName()%>
        </div>
        <div class="card-body">
            <h3 class="card-title" style="color: #007710">$ <%=i.getPrice()%></h3>
            <p class="card-text"><%=i.getDescription()%></p>
            <a href="#" class="btn btn-success" style="width: 90%">Buy Now</a>
        </div>
    </div>
    <div style="width: 5%"></div>
    <%
            }
        }
    %>
</div>
</div>
</div>
</body>
</html>