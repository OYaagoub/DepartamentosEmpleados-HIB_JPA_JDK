package com.yaagoub.routes;

import com.yaagoub.controllers.AIControllers;
import com.yaagoub.controllers.Controllers;
import com.yaagoub.models.Departement;
import com.yaagoub.models.Employee;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "defaultServlet", value = "/defaultServlet")
public class DefaultServlet extends HttpServlet {

    private AIControllers aic;
    public void init() {

    }



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {



        this.aic = new Controllers();
        Departement dept1 = new Departement(10,"CONTABILIDAD","SEVILLA");
        Departement dept2 = new Departement(20,"INVESTIGACIÓN","MADRID");
        Departement dept3 = new Departement(30,"VENTAS","BARCELONA");
        Departement dept4 = new Departement(40,"PRODUCCIÓN","BILBAO");
        Departement[] arrDep ={dept1,dept2,dept3,dept4};
        int s=0;
        for (Departement Departements : arrDep) {
            boolean x = this.aic.insert(Departements);
            if (x==true){
                s++;
            }

            System.out.println(x);
        }
        if (s==4){
            System.out.println("entra");
        Employee emp1 = new Employee(1, "SÁNCHEZ", 1040.0F, 0.0F, "Administrator", dept3);
        Employee emp2 = new Employee(2, "ARROYO", 1500.0F, 390.0F, "Administrator", dept3);
        Employee emp3 = new Employee(3, "SALA", 1625.0F, 650.0F, "normal", dept3);
        Employee emp4 = new Employee(4, "JIMÉNEZ", 2900.0F, 0.0F, "normal", dept1);
        Employee emp5 = new Employee(5, "MARTÍN", 1600.0F, 1020.0F, "normal", dept1);
        Employee emp6 = new Employee(6, "NEGRO", 1005.0F, 0.0F, "normal", dept1);
        Employee emp7 = new Employee(7, "CEREZO", 2885.0F, 0.0F, "Administrator", dept2);
        Employee emp8 = new Employee(8, "GIL", 3000.F, 0.0F, "normal", dept2);
        Employee emp9 = new Employee(9, "REY", 1100.0F, 0.0F, "normal", dept2);
        Employee emp10 = new Employee(10, "TOVAR", 1350.0F, 0.0F, "normal", dept4);
        Employee emp11 = new Employee(11, "ALONSO", 1430.0F, 0.0F, "normal", dept4);
        Employee emp12 = new Employee(12, "MUÑOZ", 1490.0F, 0.0F, "Administrator", dept4);
        Employee[] arrEmp = {emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10, emp11, emp12};
        for (Employee empleado : arrEmp) {
            boolean x = this.aic.insertE(empleado);
            System.out.println(x);
        }}

        response.sendRedirect("/departments");
    }

    public void destroy() {
    }
}