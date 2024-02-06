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

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    private AIControllers aic ;
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("title", "Login");
        HttpSession session = request.getSession();
        // Check if the "username" attribute is set in the session
        String usuario = (String) session.getAttribute("usuario");
        if(usuario != null){

            response.sendRedirect("/departments");
        }else{
            request.getRequestDispatcher("/login.jsp")
                    .forward(request, response);
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pass = request.getParameter("pass");
        String usuario = request.getParameter("usuario");
        this.aic = new Controllers();

        if(aic.validationLogin(usuario, Integer.parseInt(pass))){

            Employee e = aic.getByIdE(Integer.parseInt(pass));

            HttpSession session = request.getSession(); // Get the existing session or create a new one
            // Set an attribute in the session
            session.setAttribute("usuario", usuario);

            System.out.println(e);
            session.setAttribute("id", e.getEmpno());
            session.setAttribute("id_dep", e.getDep().getDeptno());
            session.setAttribute("rol", aic.checkRol(e));
            response.sendRedirect("/departments");
            // Retrieve an attribute from the session
            //String username = (String) session.getAttribute("username");

        }else{
            request.setAttribute("error", "pass o usuario incorrecto");
            doGet(request,response);
        }
    }

    public void destroy() {
    }
}
