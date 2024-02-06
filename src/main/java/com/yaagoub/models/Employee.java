/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaagoub.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "EMPLEADOS")
public class Employee  implements Serializable {
    @Id
    @Column(
            name = "empno"
    )
    private int empno;
    @Column(
            name = "apellido"
    )
    private String apellido;



    @Column(
            name = "salario"
    )

    private Float salario;
    @Column(
            name = "comision"
    )
    private Float comision;
    @Column(
            name = "rol"
    )
    private String rol;

    @ManyToOne
    @JoinColumn(name = "deptno",referencedColumnName = "deptno")
    private Departement dep;


    public Employee() {
    }

    public Employee(int empno, String apellido, Float salario, Float comision, String rol, Departement dep) {
        this.empno = empno;
        this.apellido = apellido;
        this.salario = salario;
        this.comision = comision;
        this.rol = rol;
        this.dep = dep;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Float getComision() {
        return comision;
    }

    public void setComision(Float comision) {
        this.comision = comision;
    }

    public Departement getDep() {
        return dep;
    }

    public void setDep(Departement dep) {
        this.dep= dep;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empno=" + empno +
                ", apellido='" + apellido + '\'' +
                ", salario=" + salario +
                ", comision=" + comision +
                ", rol='" + rol + '\'' +
                ", dep=" + dep +
                '}';
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
