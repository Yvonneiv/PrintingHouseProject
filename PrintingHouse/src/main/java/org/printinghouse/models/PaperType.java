package org.printinghouse.models;

import java.math.BigDecimal;

public enum PaperType {
    REGULAR(new BigDecimal("0.1")),
    GLOSSY(new BigDecimal("0.2")),
    NEWSPAPER(new BigDecimal("0.05"));

    private final BigDecimal price1;

    private PaperType(BigDecimal price1) {
        this.price1 = price1;
    }

    public BigDecimal getPrice() {
        return this.price1;
    }
}
