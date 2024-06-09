package org.printinghouse.models;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.math.BigDecimal;

public class Operator extends Employee {
    public Operator(String name, double baseSalary) {
        super(name, baseSalary);
    }

    public BigDecimal getSalary() {
        return BigDecimal.valueOf(this.getBaseSalary());
    }
}
