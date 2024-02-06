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

import static java.lang.System.exit;

@WebServlet(name = "delete", value = "/delete")
public class DeleteServlet extends HttpServlet {
    private AIControllers aic ;
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("title", "delete");
        String x=request.getParameter("on");
        String y=request.getParameter("id");
        String error = null;
        aic = new Controllers();
        if(x!=null && !x.isEmpty() &&  y!=null && !y.isEmpty() ){
            if (x.equalsIgnoreCase("dep")){
                if (aic.getByIdRD(Integer.parseInt(y))){
                    response.sendRedirect("/departments");
                }else {
                    error = "id not found";
                    response.sendRedirect("/departments?error="+error);
                }
            }else if (x.equalsIgnoreCase("emp")){
                if (aic.getByIdRE(Integer.parseInt(y))){
                    response.sendRedirect("/departments");

                }else {
                    error = "id not found";
                    response.sendRedirect("/departments?error="+error);
                }
                
            }else{

                response.sendRedirect("/departments?error=action not found");
            }

        }else {
            error ="data not exist";
            response.sendRedirect("/departments?error="+error);
        }
        // Check if the "username" attribute is set in the session





    }


    public void destroy() {
    }
}
