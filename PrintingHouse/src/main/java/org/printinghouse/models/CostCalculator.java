package org.printinghouse.models;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class CostCalculator {
    public CostCalculator() {
    }

    public static BigDecimal calculateEmployeeCosts(List<Employee> employees) {
        BigDecimal total = BigDecimal.ZERO;

        for (Employee employee : employees) {
            total = total.add(employee.getSalary());
        }

        return total;
    }

    public static BigDecimal calculatePaperCosts(int sheets, PaperType paperType, PaperSize paperSize) {
        BigDecimal sheetCount = BigDecimal.valueOf(sheets);
        BigDecimal total = sheetCount.multiply(paperType.getPrice()).add(paperSize.getPrice());
        return total;
    }
}
