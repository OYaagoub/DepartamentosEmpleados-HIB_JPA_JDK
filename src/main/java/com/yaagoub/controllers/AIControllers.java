package com.yaagoub.controllers;

import com.yaagoub.models.Departement;
import com.yaagoub.models.Employee;

import java.util.List;

public interface AIControllers {
    List<Departement> depAll();
    void update(Departement x);
    boolean insert(Departement x);
    Departement getByIdD(int id);
    boolean checkRol(Employee x);
    List<Employee> empAll();
    void update(Employee x);
    boolean insertE(Employee x);
    boolean getByIdRE(int id);
    boolean getByIdRD(int id);
    Employee getByIdE(int id);
    boolean validationLogin(String usuario,int pass);
}
