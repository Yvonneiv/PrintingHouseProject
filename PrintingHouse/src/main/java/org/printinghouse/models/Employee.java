package org.printinghouse.models;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)

import java.math.BigDecimal;

public abstract class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return this.name;
    }

    public double getBaseSalary() {return this.baseSalary;
    }

    public abstract BigDecimal getSalary();
}

