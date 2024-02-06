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

@WebServlet(name = "edit", value = "/edit")
public class UpdateServlet extends HttpServlet {
    private AIControllers aic ;
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("title", "Actions (edit or Update)");
        HttpSession session = request.getSession();
        // Check if the "username" attribute is set in the session
        String usuario = (String) session.getAttribute("usuario");
        if(usuario != null){
            if (request.getParameter("action").equalsIgnoreCase("new")){
                request.setAttribute("action",request.getParameter("action"));

            }
            else if (request.getParameter("action").equalsIgnoreCase("update")){
                request.setAttribute("action",request.getParameter("action"));
                aic = new Controllers();
                request.setAttribute("dep",aic.getByIdD(Integer.parseInt(request.getParameter("id"))));



            }else {
                response.sendRedirect("/departments?error=action not exist or id not found");
            }

            request.getRequestDispatcher("/Edit_Update_dep.jsp")
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
