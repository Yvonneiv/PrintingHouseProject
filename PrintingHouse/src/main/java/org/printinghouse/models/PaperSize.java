package org.printinghouse.models;

import java.math.BigDecimal;

public enum PaperSize {
    A1(BigDecimal.ZERO),
    A2(BigDecimal.ZERO),
    A3(BigDecimal.ZERO),
    A4(BigDecimal.ZERO),
    A5(new BigDecimal("0.1"));

    private BigDecimal price;

    private PaperSize(BigDecimal price) {
        this.price = price;
    }

    private PaperSize() {
        this.price = this.calculatePrice();
    }

    private BigDecimal calculatePrice() {
        if (this.ordinal() == 0) {
            return BigDecimal.ZERO;
        } else {
            PaperSize[] values = values();
            BigDecimal previousPrice = values[this.ordinal() - 1].getPrice();
            return previousPrice.multiply(new BigDecimal("1.1"));
        }
    }

    public BigDecimal getPrice() {
        return this.price;
    }
}
