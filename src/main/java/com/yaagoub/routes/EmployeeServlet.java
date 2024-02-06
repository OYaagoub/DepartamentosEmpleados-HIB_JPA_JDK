package com.yaagoub.routes;

import com.yaagoub.controllers.AIControllers;
import com.yaagoub.controllers.Controllers;
import com.yaagoub.models.Departement;
import com.yaagoub.models.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "employees", value = "/employees")
public class EmployeeServlet extends HttpServlet {
    private AIControllers aic ;

    public void init(

    ) {
        this.aic = new Controllers();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idString = request.getParameter("id");
        HttpSession session = request.getSession();

        List<Employee> emp= new ArrayList<Employee>();
        if(idString!=null){


            aic.empAll().forEach(d->{
                if (d.getDep().getDeptno()==Integer.parseInt(request.getParameter("id"))){
                    emp.add(d);
                }

            });

        }else {
            emp.addAll(aic.empAll());
        }
        request.setAttribute("pertenece",session.getAttribute("id"));
        request.setAttribute("total",emp.size());
        request.setAttribute("rol",session.getAttribute("rol"));
        request.setAttribute("emplds",emp);
        request.getRequestDispatcher("/employees.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action= request.getParameter("action");
        if (action.equalsIgnoreCase("update")){
            Departement pertenece ;
            pertenece=aic.getByIdD(Integer.parseInt(request.getParameter("dep")));
            Employee e =new Employee(Integer.parseInt(request.getParameter("empno")),
                    request.getParameter("apellido"),
                    Float.parseFloat(request.getParameter("salario")),
                    Float.parseFloat(request.getParameter("comision")),
                    request.getParameter("rol"),
                    pertenece );
            aic.update(e);
        }
        if (action.equalsIgnoreCase("new")){
            Departement pertenece ;
            pertenece=aic.getByIdD(Integer.parseInt(request.getParameter("dep")));
            Employee e =new Employee(Integer.parseInt(request.getParameter("empno")),
                    request.getParameter("apellido"),
                    Float.parseFloat(request.getParameter("salario")),
                    Float.parseFloat(request.getParameter("comision")),
                    request.getParameter("rol"),
                    pertenece );
            System.out.println(e);
            aic.insertE(e);

        }
        response.sendRedirect("/departments");
    }

    public void destroy() {
    }
}