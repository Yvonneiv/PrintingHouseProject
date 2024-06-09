package org.printinghouse.models;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.math.BigDecimal;

public class Manager extends Employee {
    private double bonusPercentage;
    private double revenueThreshold;

    public Manager(String name, double baseSalary, double bonusPercentage, double revenueThreshold) {
        super(name, baseSalary);
        this.bonusPercentage = bonusPercentage;
        this.revenueThreshold = revenueThreshold;
    }

    public BigDecimal getSalary() {return BigDecimal.valueOf(this.getBaseSalary());
    }
}
