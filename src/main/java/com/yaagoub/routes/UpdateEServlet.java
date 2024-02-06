package com.yaagoub.routes;

import com.yaagoub.controllers.AIControllers;
import com.yaagoub.controllers.Controllers;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "editE", value = "/editE")
public class UpdateEServlet extends HttpServlet {
    private AIControllers aic ;
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("title", "Actions (edit or Update)");
        HttpSession session = request.getSession();
        // Check if the "username" attribute is set in the session
        String usuario = (String) session.getAttribute("usuario");
        aic = new Controllers();
        if(usuario != null){
            if (request.getParameter("action").equalsIgnoreCase("new")){
                request.setAttribute("action",request.getParameter("action"));

            }
            else if (request.getParameter("action").equalsIgnoreCase("update")){
                request.setAttribute("action",request.getParameter("action"));

                request.setAttribute("emp",aic.getByIdE(Integer.parseInt(request.getParameter("id"))));



            }else {
                response.sendRedirect("/employees?error=action no existe ");
            }
            request.setAttribute("rol",session.getAttribute("rol"));
            request.setAttribute("departments",aic.depAll());
            request.getRequestDispatcher("/Edit_Update_emp.jsp")
                    .forward(request, response);
        }else{

            response.sendRedirect("/departments");
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void destroy() {
    }
}
