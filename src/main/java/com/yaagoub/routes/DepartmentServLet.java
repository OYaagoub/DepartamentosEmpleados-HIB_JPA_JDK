package com.yaagoub.routes;

import com.yaagoub.controllers.AIControllers;
import com.yaagoub.controllers.Controllers;
import com.yaagoub.models.Departement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "departments", value = "/departments")
public class DepartmentServLet extends HttpServlet {
    private String message;
    private AIControllers aic;
    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if (request.getParameter("error")!=null){
            String error = request.getParameter("error");
            request.setAttribute("error",error);
        }

        System.out.println();
        this.aic = new Controllers();
        ArrayList<Departement> dep=new ArrayList<>();
        dep.addAll(aic.depAll());
        dep.forEach(e->{
            System.out.println(e.toString());
        });
        request.setAttribute("departments",dep);
        if (session.getAttribute("id") != null) {
            int depInt = (int) session.getAttribute("id_dep");
            String depString =String.valueOf(depInt);
            request.setAttribute("pertenece",depString);
            request.setAttribute("rol",session.getAttribute("rol"));
            request.setAttribute("isLoginIn", true);
        } else {
            request.setAttribute("isLoginIn", false);
        }
        request.setAttribute("total",dep.size());
        request.getRequestDispatcher("departments.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action= request.getParameter("action");
        this.aic = new Controllers();
        if (action.equalsIgnoreCase("update")){
            Departement pertenece = new Departement();

            if (request.getParameter("deptno") == null || request.getParameter("deptno").isEmpty()) {
                String error ="Dept No. is required.";
                request.setAttribute("error",error);
            }
            pertenece.setDeptno(Integer.parseInt(request.getParameter("deptno")));

            if (request.getParameter("dnombre") == null || request.getParameter("dnombre").isEmpty()) {

                String error ="Department name is required.";
                request.setAttribute("error",error);
            }
            pertenece.setDnombre(request.getParameter("dnombre"));

            if (request.getParameter("loc") == null || request.getParameter("loc").isEmpty()) {
                /*try {
                    throw new Exception("Location is required.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }*/
                String error ="Location is required.";
                request.setAttribute("error",error);


            }
            pertenece.setLoc(request.getParameter("loc"));
            if(request.getAttribute("error")!=null){

                response.sendRedirect("/Edit_Update_dep.jsp?error="+request.getAttribute("error")+"&action=update");
            }else{
                aic.update(pertenece);
                response.sendRedirect("/departments");
            }

        }
        if (action.equalsIgnoreCase("new")) {
            Departement pertenece = new Departement();

            if (request.getParameter("deptno") == null || request.getParameter("deptno").isEmpty()) {
                String error ="Dept No. is required.";
                request.setAttribute("error",error);
            }
            pertenece.setDeptno(Integer.parseInt(request.getParameter("deptno")));

            if (request.getParameter("dnombre") == null || request.getParameter("dnombre").isEmpty()) {
                String error ="Department name is required.";
                request.setAttribute("error",error);
            }
            pertenece.setDnombre(request.getParameter("dnombre"));

            if (request.getParameter("loc") == null || request.getParameter("loc").isEmpty()) {
                String error ="Location is required.";
                request.setAttribute("error",error);
            }
            pertenece.setLoc(request.getParameter("loc"));
            if(request.getAttribute("error")!=null){

                response.sendRedirect("/Edit_Update_dep.jsp?error="+request.getAttribute("error")+"&action=new");
            }else{
                if(aic.getByIdD(pertenece.getDeptno())!=null){
                    response.sendRedirect("/departments?error=no se puede crear el departamento existe");
                }else {
                    aic.insert(pertenece);
                    response.sendRedirect("/departments");
                }

            }


        }

    }
    public void destroy() {
    }
}