package com.yaagoub.routes;

import com.yaagoub.controllers.AIControllers;
import com.yaagoub.controllers.Controllers;
import com.yaagoub.models.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "logout", value = "/logout")
public class LogoutServlet extends HttpServlet {
    private AIControllers aic ;
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("title", "Login");
        HttpSession session = request.getSession();
        session.invalidate();
        // Check if the "username" attribute is set in the session

        request.getRequestDispatcher("/login.jsp")
                    .forward(request, response);


    }


    public void destroy() {
    }
}
