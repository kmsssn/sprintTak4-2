package kz.bitlab.sprintTask.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprintTask.db.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException{
        String email=request.getParameter("user_email");
        String password=request.getParameter("user_password");
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection= DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/sprinttask4-2",
                        "root",
                        "root");
                statement = connection.prepareStatement(
                        "SELECT * FROM users WHERE email=? AND password=?"
                );
                statement.setString(1, email);
                statement.setString(2, password);
                resultSet=statement.executeQuery();
                if(resultSet.next()){
                    Long userId=resultSet.getLong("id");
                    response.sendRedirect("/profile?id="+userId);
                }else {
                    response.sendRedirect("login?error");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                resultSet.close();
                statement.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
