package kz.bitlab.sprintTask.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprintTask.db.DBConnection;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException{
        String email=request.getParameter("user_email");
        String password=request.getParameter("user_password");
        if (DBConnection.checkLogin(email, password)){
            response.sendRedirect("/");
        }else{
            response.sendRedirect("/login?error");
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
