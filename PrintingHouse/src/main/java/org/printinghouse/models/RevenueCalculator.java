package org.printinghouse.models;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class RevenueCalculator {
    public RevenueCalculator() {
    }

    public static BigDecimal calculateRevenues(List<Publication> publications) {
        BigDecimal total = BigDecimal.ZERO;

        for (Publication pub : publications) {
            total = total.add(pub.getPrice());
        }

        return total;
    }
}

