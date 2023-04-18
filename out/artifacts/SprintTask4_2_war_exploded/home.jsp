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
        <div class="mt-5">
            <div style="display: flex; flex-direction: row; justify-content: space-between; margin-top: 5%">
                    <div class="space">

                    </div>
                    <div style="display: flex; flex-direction: row; flex-wrap: wrap; justify-content: center">
                        <%
                            ArrayList<Items> items= (ArrayList<Items>) request.getAttribute("items");
                            if (items!=null){
                                for(Items i: items){
                        %>
                        <div class="card text-center">
                            <div class="card-header">
                                <%=i.getName()%>
                            </div>
                            <div class="card-body">
                                <h3 class="card-title">$ <%=i.getPrice()%></h3>
                                <p class="card-text"><%=i.getDescription()%></p>
                                <a href="#" class="btn btn-primary">Buy Now</a>
                            </div>
                        </div>
                        <%
                                }
                            }
                        %>
                    </div>
        </div>
    </div>
</body>
</html>
