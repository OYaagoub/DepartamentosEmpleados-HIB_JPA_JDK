package com.yaagoub.models;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "DEPARTMENTS")
public class Departement implements Serializable {
    @Id
    @Column(name = "deptno")
    private int deptno;
    @Column(name = "dnombre")
    private String dnombre;
    @Column(name = "loc")
    private  String loc;
    //@OneToMany
    //@JoinColumn(name = "deptno",referencedColumnName = "deptno")
    //ArrayList<Employee> emps = new ArrayList<>();
    public Departement() {
    }

    public Departement(int deptno, String dnombre, String loc) {
        this.deptno = deptno;
        this.dnombre = dnombre;
        this.loc = loc;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "deptno=" + deptno +
                ", dnombre='" + dnombre + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
