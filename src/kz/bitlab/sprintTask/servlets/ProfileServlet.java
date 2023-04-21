package kz.bitlab.sprintTask.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprintTask.db.DBConnection;
import kz.bitlab.sprintTask.db.Users;

import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException{
        Long id=Long.parseLong(request.getParameter("id"));
        Users user= DBConnection.getUser(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}
