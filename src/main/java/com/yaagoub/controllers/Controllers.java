package com.yaagoub.controllers;

import com.yaagoub.models.Departement;
import com.yaagoub.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Controllers implements AIControllers {
    private EntityManagerFactory em;
    private EntityManager emf;
    public Controllers() {


        this.em = Persistence.createEntityManagerFactory("OSM");

    }

    @Override
    public List<Departement> depAll() {
        this.emf = this.em.createEntityManager();
        String sql ="from Departement d";
        List<Departement> x=this.emf.createQuery(sql).getResultList();
        emf.close();
        return x;
    }

    @Override
    public void update(Departement x) {
        this.emf = this.em.createEntityManager();

        if (x != null) {
            // Begin transaction and update the employee
            emf.getTransaction().begin();
            emf.merge(x); // Use merge() for updates
            emf.getTransaction().commit();
            emf.close();

        } else {
            System.out.println("Departement not found");
            emf.close();
        }

    }

    @Override
    public boolean insert(Departement x) {
        this.emf = this.em.createEntityManager();
        EntityTransaction transaction = null;
        boolean success = false;

        try {

            transaction = emf.getTransaction();
            transaction.begin();
            emf.persist(x);
            transaction.commit();
            success = true;
            emf.close();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Log the exception
            e.printStackTrace();
        } finally {
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }

        return success;
    }



    @Override
    public Departement getByIdD(int id) {
        this.emf = this.em.createEntityManager();
        Departement x=this.emf.find(Departement.class , id);
        emf.close();
        return x;
    }
    @Override
    public boolean checkRol(Employee x) {
        if (x.getRol().equalsIgnoreCase("administrator")){
            return true;
        }else {
            return  false;
        }
    }

    @Override
    public List<Employee> empAll() {
        this.emf = this.em.createEntityManager();
        String sql ="from Employee d";
        List<Employee> x=emf.createQuery(sql).getResultList();
        emf.close();
        return x;
    }

    @Override
    public void update(Employee x) {
        this.emf = this.em.createEntityManager();
        if (x != null) {
            // Begin transaction and update the employee
            emf.getTransaction().begin();
            emf.merge(x); // Use merge() for updates
            emf.getTransaction().commit();
            emf.close();

        } else {
            System.out.println("Employee not found");
            emf.close();
        }

    }

    @Override
    public boolean insertE(Employee x ) {
        this.emf = this.em.createEntityManager();
        EntityTransaction transaction = null;
        boolean success = false;

        try {

            transaction = emf.getTransaction();
            transaction.begin();
            emf.persist(x);
            transaction.commit();
            success = true;
            emf.close();
            System.out.println("empleado insertado");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Log the exception
            e.printStackTrace();
        } finally {
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }

        return success;
    }



    @Override
    public Employee getByIdE(int id) {
        this.emf = this.em.createEntityManager();
        Employee x=emf.find(Employee.class , id);
        emf.close();
        return x;
    }
    @Override
    public boolean getByIdRE(int id) {
        this.emf = this.em.createEntityManager();

        try {
            Employee emp = emf.find(Employee.class, id);

            emf.getTransaction().begin();
            // Merge the emp object back into the persistence context


            // Now, the detachedEmp object is detached from the persistence context
            // and can safely be removed from the database
            emf.remove(emp);
            emf.getTransaction().commit();
            emf.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error removing employee from database");
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean getByIdRD(int id) {
        this.emf = this.em.createEntityManager();
        Departement emp = emf.find(Departement.class, id);
        emf.close();

        if (emp != null) {
            ArrayList<Employee> empall = new ArrayList<>(this.empAll());
            empall.forEach(e -> {
                if (emp.getDeptno() == e.getDep().getDeptno()) {
                    // Get the employee details using the emp object
                    getByIdRE(e.getEmpno()); // assuming getByIdRE takes empno as argument
                }
                System.out.println(e);
            });

            this.emf = this.em.createEntityManager();
            emf.getTransaction().begin();
            // Delete the attached Department entity
            Departement empe = emf.find(Departement.class, id);
            emf.remove(empe);
            emf.getTransaction().commit();
            // Close the EntityManager when you're done
            emf.close();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validationLogin(String usuario,int pass){
        this.emf = this.em.createEntityManager();
        boolean status=false;
        Employee z1=emf.find(Employee.class , pass);
        emf.close();
        if(z1==null){
            return false;
        }
        if(usuario.equals(z1.getApellido())){
            status=true;
        }
        return status;
    }
}
